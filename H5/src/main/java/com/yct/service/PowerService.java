package com.yct.service;

import org.omg.CORBA.SystemException;
import org.springframework.stereotype.Repository;

import com.yct.bean.Power;

/**
 *@Description:权限接口
 *@Author:wcj
 *@Since:2015年3月2日下午1:25:20  
 */
@Repository
public interface PowerService {
    
    /**
     *@Description: 增加权限，插入重复数据前台控制
     *@return void    返回类型 
     *@Author: wcj
     *@Since: 2015年3月2日下午1:27:39
     *@param power
     *@throws BizException
     *@throws SystemException
     */
    void addPower(Power power) throws Exception;
    
    /**
     *@Description: 根据角色和菜单删除权限，删除父菜单权限时，一并删除所有子菜单权限现在前端处理
     *@return void    返回类型 
     *@Author: wcj
     *@Since: 2015年3月2日下午1:28:50
     *@param roleId
     *@throws BizException
     *@throws SystemException
     */
    void delPower(Power power) throws Exception;
    
    /**
     * 删除角色所有权限
     * @param power
     * @throws BizException
     * @throws SystemException
     */
    void delRoleAll(Power power) throws Exception;

}
