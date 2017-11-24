package com.yct.service;

import java.math.BigInteger;
import java.util.List;

import org.omg.CORBA.SystemException;
import org.springframework.stereotype.Repository;

import com.yct.bean.Menu;
import com.yct.bean.Power;

/**
 *@Description:菜单服务接口
 *@Author:wcj
 *@Since:2015年1月14日 下午1:49:58
 */
@Repository
public interface MenuService {
    
    /**
     * 查询用户一级菜单列表
     * @param m
     * @return
     */
    List<Menu> getFirstMenus(Power p) throws Exception;
    
    /**
     * 查询用户子菜单列表
     * @param m
     * @return
     */
    List<Menu> getSubMenus(Power p) throws Exception;
    
    /**
     * 根据角色查询菜单
     * @param beRoleId
     * @return
     * @throws BizException
     * @throws SystemException
     */
    List<Menu> getMenuListByRole(BigInteger roleId) throws Exception;
    
    /**
     *@Description: 根据角色查询菜单 (当前操作角色权限下的所有菜单+被操作角色已有的权限下的菜单) 
     *@return List<Menu>    返回类型 
     *@Author: 俞帅军
     *@Since: 2015年3月4日下午2:42:39
     *@param thisRoleId 当前操作角色ID
     *@param beRoleId 被操作角色ID
     *@return
     *@throws BizException
     *@throws SystemException
     */
    List<Menu> getMenuListByRole(BigInteger thisRoleId, BigInteger beRoleId) throws Exception;
    
    /**
     * 查询单个按钮信息
     * @param m
     * @return
     * @throws BizException
     * @throws SystemException
     */
    Menu selectMenu(Menu m) throws Exception;
    
}
