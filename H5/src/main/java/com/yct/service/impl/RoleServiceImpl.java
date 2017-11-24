package com.yct.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yct.bean.Emp;
import com.yct.bean.Organization;
import com.yct.bean.Role;
import com.yct.bean.base.PaginationEntity;
import com.yct.dao.EmpDao;
import com.yct.dao.OrganizationDao;
import com.yct.dao.RoleDao;
import com.yct.service.RoleService;

/**
 *@Description:角色接口实现 
 *@Author:wcj
 *@Since:2015年3月3日上午9:40:25  
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    
    @Autowired
    private OrganizationDao organizationDao;
    
    @Autowired
    private EmpDao empDao;
    

    /**
     *@Description: 增加角色信息
     *@Author: wcj
     *@Since: 2015年3月3日上午9:41:05
     *@param role
     *@throws BizException
     *@throws SystemException
     */
    @Override
    public void addRole(Role role) throws Exception{
        //时间填充
        Date time = new Date ();
        role.setCreatetime (time);
        role.setLastupdatetime (time);
            roleDao.insertRole (role);
    }

    /**
     *@Description: 根据id删除员工信息
     *@Author: wcj
     *@Since: 2015年3月3日上午9:45:19
     *@param roleId
     *@throws BizException
     *@throws SystemException
     */
    @Override
    public void delRole(BigInteger roleId) throws Exception{
        //判断角色下是否有员工，有员工不允许删除
        List<Emp> empList = new ArrayList<Emp> ();
            empList = empDao.getEmpListByRole (roleId);
        if(null != empList){
            throw new Exception();
        }
            roleDao.deleteByPrimaryKey (roleId);
    }

    /**
     *@Description: 根据ID查询角色信息
     *@Author: wcj
     *@Since: 2015年3月3日上午9:46:10
     *@param roleId
     *@return
     *@throws BizException
     *@throws SystemException
     */
    @Override
    public Role getRole(BigInteger roleId) throws Exception{
        Role role = new Role ();
            role = roleDao.selectByPrimaryKey (roleId);
        if(null == role){
            return null;
        }
        //上级角色
        if(null != role.getParentId ()){
            Role r = new Role ();
                r = roleDao.selectByPrimaryKey (role.getParentId ());
            if(null != r){
                role.setParentStr (r.getRoleName ());
            }
        }
        //所属组织
        if(null != role.getOrganizationId ()){
            Organization organization = new Organization ();
                organization = organizationDao.selectByPrimaryKey (role.getOrganizationId ());
            if(null != organization){
                role.setOrganizationStr (organization.getOrganizationName ());
            }
        }
        return role;
    }

    /**
     *@Description: 根据id修改角色信息
     *@Author: wcj
     *@Since: 2015年3月3日上午10:01:55
     *@param role
     *@throws BizException
     *@throws SystemException
     */
    @Override
    public void upRole(Role role) throws Exception{
        //最后修改时间
        role.setLastupdatetime (new Date ());
            roleDao.updateByPrimaryKey (role);
    }

    /**
     *@Description: 分页查询 
     *@Author: wcj
     *@Since: 2015年3月3日上午10:03:07
     *@param role
     *@return
     *@throws BizException
     *@throws SystemException
     */
    @Override
    public PaginationEntity<Role> rolePagination(Role role) throws Exception{
        PaginationEntity<Role> rolePagination = new PaginationEntity<Role> ();
            rolePagination = roleDao.selectPage(role);
        List<Role> roleList = rolePagination.getItems ();
        if(null != roleList && 0 != roleList.size ()){
            for ( Role role2 : roleList ) {
                //上级角色
                if(null != role2.getParentId ()){
                    Role r = new Role ();
                        r = roleDao.selectByPrimaryKey (role2.getParentId ());
                    if(null != r){
                        role2.setParentStr (r.getRoleName ());
                    }
                }
                //所属组织
                if(null != role2.getOrganizationId ()){
                    Organization organization = new Organization ();
                        organization = organizationDao.selectByPrimaryKey (role2.getOrganizationId ());
                    if(null != organization){
                        role2.setOrganizationStr (organization.getOrganizationName ());
                    }
                }
            }
        }
        return rolePagination;
    }

    /**
     *@Description: 根据组织查询角色 
     *@Author: wcj
     *@Since: 2015年3月4日上午10:02:47
     *@param organizationId
     *@return
     *@throws BizException
     *@throws SystemException
     */
    @Override
    public List<Role> getRoleListByOrganization(BigInteger organizationId) throws Exception{
        return roleDao.getRoleListByOrganization (organizationId);
    }
    
    //---------------------------------已使用异常号已使用到23

}
