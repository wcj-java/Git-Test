package com.yct.service;

import java.math.BigInteger;
import java.util.List;

import org.omg.CORBA.SystemException;
import org.springframework.stereotype.Repository;

import com.yct.bean.Role;
import com.yct.bean.base.PaginationEntity;

/**
 *@Description:角色接口
 *@Author:wcj
 *@Since:2015年2月2日上午9:57:34  
 */
@Repository
public interface RoleService {

    /**
     *@Description: 增加角色
     *@return void    返回类型 
     *@Author: wcj
     *@Since: 2015年2月2日上午10:02:05
     *@param role
     *@throws BizException
     *@throws SystemException
     */
    void addRole(Role role) throws Exception;

    /**
     *@Description: 删除角色
     *@return void    返回类型 
     *@Author: wcj
     *@Since: 2015年2月2日上午10:02:02
     *@param roleId
     *@throws BizException
     *@throws SystemException
     */
    void delRole(BigInteger roleId) throws Exception;

    /**
     *@Description: 查询角色
     *@return Role    返回类型 
     *@Author: wcj
     *@Since: 2015年2月2日上午10:01:58
     *@param roleId
     *@return
     *@throws BizException
     *@throws SystemException
     */
    Role getRole(BigInteger roleId) throws Exception;

    /**
     *@Description: 修改角色
     *@return void    返回类型 
     *@Author: wcj
     *@Since: 2015年2月2日上午10:01:55
     *@param role
     *@throws BizException
     *@throws SystemException
     */
    void upRole(Role role) throws Exception;
    
    /**
     *@Description: 查询角色信息列表（分页）
     *@return PaginationEntity<Role>    返回类型 
     *@Author: wcj
     *@Since: 2015年2月2日上午10:01:52
     *@param role
     *@return
     *@throws BizException
     *@throws SystemException
     */
    PaginationEntity<Role> rolePagination(Role role) throws Exception;
    
    /**
     *@Description: 根据组织查询角色
     *@return List<Role>    返回类型 
     *@Author: wcj
     *@Since: 2015年3月4日上午9:58:12
     *@return
     *@throws BizException
     *@throws SystemException
     */
    List<Role> getRoleListByOrganization(BigInteger organizationId) throws Exception;

}
