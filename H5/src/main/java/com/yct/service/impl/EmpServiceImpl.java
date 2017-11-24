package com.yct.service.impl;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yct.bean.Emp;
import com.yct.bean.Organization;
import com.yct.bean.Role;
import com.yct.bean.base.PaginationEntity;
import com.yct.bean.base.PaginationEntityBase;
import com.yct.dao.EmpDao;
import com.yct.dao.OrganizationDao;
import com.yct.dao.RoleDao;
import com.yct.exception.BizException;
import com.yct.service.EmpService;
import com.yct.util.MD5;

/**
 *@Description:员工服务
 *@Author:wcj
 *@Since:2015年1月15日 上午10:02:14
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;
    
    @Autowired
    private OrganizationDao organizationDao;
    
    @Autowired
    private RoleDao roleDao;

    @Override
    public Emp login(Emp emp) throws Exception{
        Emp db = empDao.selectEmpByUsername (emp);
        return db;
    }

    /**
     *@Description: 增加员工 
     *@Author: wcj
     *@Since: 2015年2月2日上午10:09:17
     *@param emp
     *@throws BizException
     *@throws SystemException
     */
    @Override
    public void addEmp(Emp emp) throws Exception{
        //判断是否已有此工号
        empDao.selectEmpByEmpNum(emp);
        //密码初始
        String password = MD5.encodeByMD5ForLowercase ("123456");
        emp.setPassword (password);
        //状态初始
        emp.setStatus (0);
        //时间初始
        Date time = new Date ();
        emp.setUpdatetime (time);
        emp.setCreatetime (time);
            empDao.insert (emp);
    }

    /**
     *@Description: 根据ID删除员工信息
     *@Author: wcj
     *@Since: 2015年3月3日上午9:31:29
     *@param empId
     *@throws BizException
     *@throws SystemException
     */
    @Override
    public void delEmp(BigInteger empId) throws Exception{
            Emp emp = new Emp ();
            emp.setEmpId (empId);
            empDao.delete (emp);
    }

    /**
     *@Description: 根据ID查询员工信息
     *@Author: wcj
     *@Since: 2015年3月3日上午9:31:50
     *@param empId
     *@return
     *@throws BizException
     *@throws SystemException
     */
    @Override
    public Emp getEmp(BigInteger empId) throws Exception{
        Emp emp = new Emp ();
            Emp e = new Emp ();
            e.setEmpId (empId);
            emp = empDao.selectOne (e);
        if(null == emp){
            return null;
        }
        //所属组织
        if(null != emp.getOrganizationId ()){
            Organization organization = organizationDao.selectByPrimaryKey (emp.getOrganizationId ());
            if(null != organization){
                emp.setOrganizationStr (organization.getOrganizationName ());
            }
        }
        //所属角色
        if(null != emp.getRoleId ()){
            Role role = roleDao.selectByPrimaryKey (emp.getRoleId ());
            if(null != role){
                emp.setRoleStr (role.getRoleName ());
            }
        }
        return emp;
    }

    /**
     *@Description: 修改员工信息 
     *@Author: wcj
     *@Since: 2015年3月3日上午9:32:13
     *@param emp
     *@throws BizException
     *@throws SystemException
     */
    @Override
    public void upEmp(Emp emp) throws Exception{
        //修改时间
        emp.setUpdatetime (new Date ());
            empDao.update (emp);
    }

    /**
     *@Description: 修改员工密码
     *@Author: wcj
     *@Since: 2015年3月3日上午9:32:27
     *@param emp
     *@throws BizException
     *@throws SystemException
     */
    @Override
    public void upEmpPassword(Emp emp) throws Exception{
        //修改时间
        emp.setUpdatetime (new Date ());
        //加密
        String password = MD5.encodeByMD5ForLowercase (emp.getPassword ());
        emp.setPassword (password);
            empDao.updatePasswordByEmpId (emp); 
    }
    
    /**
     *@Description: 分页查询
     *@Author: wcj
     *@Since: 2015年3月3日上午9:34:41
     *@param emp
     *@return
     *@throws BizException
     *@throws SystemException
     */
    @Override
    public PaginationEntityBase<Emp> empPagination(Emp emp) throws Exception{
    	PaginationEntityBase<Emp> empPagination = empDao.selectPage (emp);
        List<Emp> empList = empPagination.getData ();
        //判空
        if(null != empList && 0 != empList.size ()){
            for ( Emp emp2 : empList ) {
                //所属组织
                if(null != emp2.getOrganizationId ()){
                    Organization organization = organizationDao.selectByPrimaryKey (emp2.getOrganizationId ());
                    if(null != organization){
                        emp2.setOrganizationStr (organization.getOrganizationName ());
                    }
                }
                //所属角色
                if(null != emp2.getRoleId ()){
                    Role role = roleDao.selectByPrimaryKey (emp2.getRoleId ());
                    if(null != role){
                        emp2.setRoleStr (role.getRoleName ());
                    }
                }
            }
        }
        return empPagination;
    }

    /**
     *@Description: 根据组织ID查询员工信息
     *@Author: wcj
     *@Since: 2015年3月3日下午3:50:05
     *@param organizationId
     *@return
     *@throws BizException
     *@throws SystemException
     */
    @Override
    public List<Emp> getEmpListByOrganization(BigInteger organizationId) throws Exception{
        List<Emp> empList = empDao.getEmpListByOrganization (organizationId);
        return empList;
    }

    /**
     *@Description: 重置密碼
     *@Author: wcj
     *@Since: 2015年3月5日下午12:54:13
     *@param emp
     *@throws BizException
     *@throws SystemException
     */
    @Override
    public void resetPassword(Emp emp) throws Exception{
        //密码重置
        String password = MD5.encodeByMD5ForLowercase ("123456");
        emp.setPassword (password);
        //修改時間
        emp.setUpdatetime (new Date ());
            empDao.updatePasswordByEmpId(emp);
    }

    /**
     *@Description: 修改密码 (要先验证旧密码)
     *@Author: wcj
     *@Since: 2015年3月5日下午3:50:43
     *@param emp 旧密码
     *@param password
     *@throws BizException
     *@throws SystemException
     */
    @Override
    public void upPasswordVerifyOldPassword(Emp emp, String password) throws Exception{
        //验证旧密码
        empDao.selectOne(emp);
        //验证正确，写入新密码
        emp.setPassword (password);
        upEmpPassword(emp);
    }
}
