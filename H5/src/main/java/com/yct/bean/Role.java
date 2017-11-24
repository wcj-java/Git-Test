package com.yct.bean;

import java.math.BigInteger;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.yct.bean.base.Pagination;

/**
 *@Description:角色实体类
 *@Author:wcj
 *@Since:2015年1月10日下午2:02:49  
 */
public class Role extends Pagination{
    
    private static final long serialVersionUID = 7566270859391671244L;

    /**
     * 角色编号
     */
    private BigInteger roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 上级角色编号
     */
    private BigInteger parentId;

    /**
     * 所属组织
     */
    private BigInteger organizationId;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 创建时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    /**
     * 最后修改时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date lastupdatetime;
    
    
    //---------------------用于运营平台
    /**
     * 上级角色
     */
    private String parentStr;

    /**
     * 所属组织
     */
    private String organizationStr;
    
    //========================================
    
    /**
     * 菜单列表，用于权限分配提交参数
     */
    private String[] menuIds;
    
    //========================================

    
    public BigInteger getRoleId(){
        return roleId;
    }

    
    public void setRoleId(BigInteger roleId){
        this.roleId = roleId;
    }

    
    public String getRoleName(){
        return roleName;
    }

    
    public void setRoleName(String roleName){
        this.roleName = roleName;
    }

    
    public BigInteger getParentId(){
        return parentId;
    }

    
    public void setParentId(BigInteger parentId){
        this.parentId = parentId;
    }

    
    public BigInteger getOrganizationId(){
        return organizationId;
    }

    
    public void setOrganizationId(BigInteger organizationId){
        this.organizationId = organizationId;
    }

    
    public String getDescription(){
        return description;
    }

    
    public void setDescription(String description){
        this.description = description;
    }

    
    public Date getCreatetime(){
        return createtime;
    }

    
    public void setCreatetime(Date createtime){
        this.createtime = createtime;
    }

    
    public Date getLastupdatetime(){
        return lastupdatetime;
    }

    
    public void setLastupdatetime(Date lastupdatetime){
        this.lastupdatetime = lastupdatetime;
    }

    
    public String getParentStr(){
        return parentStr;
    }


    public void setParentStr(String parentStr){
        this.parentStr = parentStr;
    }

    
    public String getOrganizationStr(){
        return organizationStr;
    }

    
    public void setOrganizationStr(String organizationStr){
        this.organizationStr = organizationStr;
    }
    
    public String[] getMenuIds(){
        return menuIds;
    }

    public void setMenuIds(String[] menuIds){
        this.menuIds = menuIds;
    }

}