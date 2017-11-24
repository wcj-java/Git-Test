package com.yct.service.impl;

import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yct.bean.Power;
import com.yct.dao.MenuDao;
import com.yct.dao.PowerDao;
import com.yct.dao.RoleDao;
import com.yct.service.PowerService;

/**
 *@Description:权限接口实现
 *@Author:wcj
 *@Since:2015年3月2日下午1:31:57  
 */
@Service
public class PowerServiceImpl implements PowerService{
    @Autowired
    private PowerDao powerDao;
    
    @Autowired
    private RoleDao roleDao;
    
    @Autowired
    private MenuDao menuDao;

    /**
     *@Description: 增加权限，插入重复数据前台控制
     *@Author: wcj
     *@Since: 2015年3月2日下午1:32:19
     *@param power                                 
     *@throws BizException
     *@throws SystemException
     */
    @Override
    public void addPower(Power power) throws Exception{
            powerDao.insertPower (power);
    }

    /**
     *@Description: 根据角色删除权限，删除父菜单权限时，一并删除所有子菜单权限现在前端处理
     *@Author: wcj
     *@Since: 2015年3月2日下午1:39:25
     *@param roleId
     *@throws BizException
     *@throws SystemException
     */
    @Override
    public void delPower(Power power) throws Exception{
            powerDao.deletePower (power);
    }

    @Override
    public void delRoleAll(Power power) throws Exception{
            powerDao.deleteRolePower (power);
        
    }

}
