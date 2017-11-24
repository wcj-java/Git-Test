package com.yct.service;

import java.math.BigInteger;
import java.util.List;

import org.omg.CORBA.SystemException;
import org.springframework.stereotype.Repository;

import com.yct.bean.Organization;
import com.yct.bean.base.PaginationEntity;

/**
 *@Description:组织接口
 *@Author:wcj
 *@Since:2015年2月2日上午9:57:47  
 */
@Repository
public interface OrganizationService {

    /**
     *@Description: 增加组织
     *@return void    返回类型 
     *@Author: wcj
     *@Since: 2015年2月2日上午10:07:48
     *@param organization
     *@throws BizException
     *@throws SystemException
     */
    void addOrganization(Organization organization) throws Exception;

    /**
     *@Description: 删除组织
     *@return void    返回类型 
     *@Author: wcj
     *@Since: 2015年2月2日上午10:07:45
     *@param organizationId
     *@throws BizException
     *@throws SystemException
     */
    void delOrganization(BigInteger organizationId) throws Exception;

    /**
     *@Description: 查询组织
     *@return Organization    返回类型 
     *@Author: wcj
     *@Since: 2015年2月2日上午10:07:42
     *@param organizationId
     *@return
     *@throws BizException
     *@throws SystemException
     */
    Organization getOrganization(BigInteger organizationId) throws Exception;

    /**
     *@Description: 修改组织
     *@return void    返回类型 
     *@Author: wcj
     *@Since: 2015年2月2日上午10:07:39
     *@param organization
     *@throws BizException
     *@throws SystemException
     */
    void upOrganization(Organization organization) throws Exception;
    
    /**
     *@Description: 查询组织信息列表（分页）
     *@return PaginationEntity<Organization>    返回类型 
     *@Author: wcj
     *@Since: 2015年2月2日上午10:07:36
     *@param organization
     *@return
     *@throws BizException
     *@throws SystemException
     */
    PaginationEntity<Organization> organizationPagination(Organization organization) throws Exception;
    
    /**
     *@Description: 查询所有组织信息
     *@return List<Organization>    返回类型 
     *@Author: wcj
     *@Since: 2015年3月3日下午3:47:58
     *@return
     *@throws BizException
     *@throws SystemException
     */
    List<Organization> getAllOrganization() throws Exception;

}
