package com.yct.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yct.bean.Menu;
import com.yct.bean.Power;
import com.yct.dao.MenuDao;
import com.yct.service.MenuService;

/**
 *@Description:菜单服务
 *@Author:wcj
 *@Since:2015年1月15日 上午10:02:33
 */
@Service
public class MenuServiceImpl implements MenuService {
    
    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> getFirstMenus(Power p){
        return menuDao.getFirstMenus (p);
    }

    @Override
    public List<Menu> getSubMenus(Power p){
        return menuDao.getSubMenus (p);
    }

    /**
     *@Description: 根据角色查询菜单(当前操作角色权限下的所有菜单+被操作角色已有的权限下的菜单)  
     *@Author: wcj
     *@Since: 2015年3月4日下午2:43:18
     *@param thisRoleId 当前操作角色ID
     *@param beRoleId 被操作角色ID
     *@return
     *@throws BizException
     *@throws SystemException
     */
    @Override
    public List<Menu> getMenuListByRole(BigInteger thisRoleId, BigInteger beRoleId) throws Exception{
        //当前操作角色权限下的所有菜单
        List<Menu> thisMenuList = new ArrayList<Menu> ();
        //被操作角色已有的权限下的菜单
        List<Menu> beMenuList = new ArrayList<Menu> ();
            thisMenuList = menuDao.getMenuListByRole(thisRoleId);
            beMenuList = menuDao.getMenuListByRole(beRoleId);
        //判空
        if(null != thisMenuList && null != beMenuList){
            //组合成一个List
            for ( Menu menu : thisMenuList ) {
                for ( Menu beMenu : beMenuList ) {
                    if(menu.getMenuId ().intValue () == beMenu.getMenuId ().intValue ()){
                        //标记被操作角色已有权限下的菜单
                        menu.setIsPower (1);
                    }
                }
            }
        }
        return thisMenuList;
    }

    @Override
    public List<Menu> getMenuListByRole(BigInteger roleId) throws Exception{
        return menuDao.getMenuListByRole(roleId);
    }

    @Override
    public Menu selectMenu(Menu m) throws Exception{
        return menuDao.selectMenuByUrl(m);
    }

}
