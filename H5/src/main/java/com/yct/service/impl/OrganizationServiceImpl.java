package com.yct.service.impl;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yct.bean.Emp;
import com.yct.bean.Organization;
import com.yct.bean.base.PaginationEntity;
import com.yct.dao.EmpDao;
import com.yct.dao.OrganizationDao;
import com.yct.service.OrganizationService;

/**
 *@Description:组织接口实现
 *@Author:wcj
 *@Since:2015年3月2日上午10:39:33  
 */
@Service
public class OrganizationServiceImpl implements OrganizationService{
    
    @Autowired
    private OrganizationDao organizationDao;
    @Autowired
    private EmpDao empDao;

    /**
     *@Description: 增加组织信息
     *@Author: wcj
     *@Since: 2015年3月2日上午10:39:52
     *@param organization
     *@throws BizException
     *@throws SystemException
     */
    @Override
    public void addOrganization(Organization organization) throws Exception{
        //填充时间
        Date time = new Date ();
        organization.setCreatetime (time);
        organization.setLastupdatetime (time);
            organizationDao.insertOrganization (organization);
    }

    /**
     *@Description: 根据id删除组织信息
     *@Author: wcj
     *@Since: 2015年3月2日上午10:46:54
     *@param organizationId
     *@throws BizException
     *@throws SystemException
     */
    @Override
    public void delOrganization(BigInteger organizationId) throws Exception{
        //判断组织下是否有员工，有员工不允许删除
        List<Emp> empList = empDao.getEmpListByOrganization (organizationId);
        if(null != empList && 0 != empList.size ()){
            throw new Exception();
        }
        organizationDao.deleteByPrimaryKey (organizationId);
        
    }

    /**
     *@Description: 根据ID查询组织信息
     *@Author: wcj
     *@Since: 2015年3月2日上午10:56:15
     *@param organizationId
     *@return
     *@throws BizException
     *@throws SystemException
     */
    @Override
    public Organization getOrganization(BigInteger organizationId) throws Exception{
        Organization organization = organizationDao.selectByPrimaryKey (organizationId);
        //判空
        if(null == organization){
            return null;
        }
        //负责人
        if(null != organization.getPrincipalId ()){
            	Emp emp = new Emp ();
                Emp e = new Emp ();
                e.setEmpId (organization.getPrincipalId ());
                emp = empDao.selectOne (e);
            if(null != emp){
                organization.setPrincipalName (emp.getName ());
            }
        }
        //上级组织
        if(null != organization.getParentId ()){
            Organization o = new Organization ();
                o = organizationDao.selectByPrimaryKey (organization.getParentId ());
            if(null != o){
                organization.setParentName (o.getOrganizationName ());
            }
        }
        return organization;
    }

    /**
     *@Description: 根据ID修改组织信息
     *@Author: wcj
     *@Since: 2015年3月2日上午11:18:33
     *@param organization
     *@throws BizException
     *@throws SystemException
     */
    @Override
    public void upOrganization(Organization organization) throws Exception{
        //最后更新时间
        organization.setLastupdatetime (new Date ());
        organizationDao.updateByPrimaryKey (organization);
    }

    /**
     *@Description: 分页
     *@Author: wcj
     *@Since: 2015年3月2日上午11:22:12
     *@param organization
     *@return
     *@throws BizException
     *@throws SystemException
     */
    @Override
    public PaginationEntity<Organization> organizationPagination(Organization organization) throws Exception{
        PaginationEntity<Organization> organizationPagination = new PaginationEntity<Organization> ();
            organizationPagination = organizationDao.selectPage (organization);
        List<Organization> organizationlist = organizationPagination.getItems ();
        if(null != organizationlist && 0 != organizationlist.size ()){
            for ( Organization organization2 : organizationlist ) {
                //负责人
                if(null != organization2.getPrincipalId ()){
                    Emp emp = new Emp ();
                        Emp e = new Emp ();
                        e.setEmpId (organization2.getPrincipalId ());
                        emp = empDao.selectOne (e);
                    if(null != emp){
                        organization2.setPrincipalName (emp.getName ());
                    }
                }
                //上级组织
                if(null != organization2.getParentId ()){
                    Organization o = organizationDao.selectByPrimaryKey (organization2.getParentId ());
                    if(null != o){
                        organization2.setParentName (o.getOrganizationName ());
                    }
                }
            }
        }
        return organizationPagination;
    }

    /**
     *@Description: 查询所有组织
     *@Author: wcj
     *@Since: 2015年3月3日下午4:14:10
     *@return
     *@throws BizException
     *@throws SystemException
     */
    @Override
    public List<Organization> getAllOrganization() throws Exception{
        return organizationDao.getAllOrganization ();
    }
    
  //-----------------异常号已使用到23
}
