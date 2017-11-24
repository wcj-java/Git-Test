package com.yct.bean;

import java.math.BigInteger;

import com.yct.bean.base.BaseEntity;

/**
 *@Description:权限实体类
 *@Author:wcj
 *@Since:2015年1月10日下午2:01:29  
 */
public class Power extends BaseEntity{
    /** 
     *@Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */ 
    private static final long serialVersionUID = -8297608927174475744L;

    /**
     * 角色编号
     */
    private BigInteger roleId;

    /**
     * 菜单编号
     */
    private BigInteger menuId;
    
    //--------------------------------用于运营平台
    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 菜单名称
     */
    private String menuName;
    
    
    
    public Power() {
        
    }
    public Power(BigInteger roleId) {
        this.roleId = roleId;
    }
    public Power(BigInteger roleId, BigInteger menuId) {
        this.roleId = roleId;
        this.menuId = menuId;
    }


    public BigInteger getRoleId(){
        return roleId;
    }

    
    public void setRoleId(BigInteger roleId){
        this.roleId = roleId;
    }

    
    public BigInteger getMenuId(){
        return menuId;
    }

    
    public void setMenuId(BigInteger menuId){
        this.menuId = menuId;
    }
    
    public String getRoleName(){
        return roleName;
    }
    
    public void setRoleName(String roleName){
        this.roleName = roleName;
    }
    
    public String getMenuName(){
        return menuName;
    }
    
    public void setMenuName(String menuName){
        this.menuName = menuName;
    }
    
    

}