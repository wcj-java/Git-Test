package com.yct.bean;

import java.math.BigInteger;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.yct.bean.base.Pagination;

/**
 *@Description:组织实体类
 *@Author:wcj
 *@Since:2015年12月10日下午1:58:30  
 */
public class Organization extends Pagination{
    
    /** 
     *@Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */ 
    private static final long serialVersionUID = -3770348208720725616L;

    /**
     * 组织编号
     */
    private BigInteger organizationId;

    /**
     * 组织名称
     */
    private String organizationName;

    /**
     * 负责人
     */
    private BigInteger principalId;

    /**
     * 上级组织
     */
    private BigInteger parentId;

    /**
     * 组织描述
     */
    private String description;

    /**
     * 创建时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    /**
     * 最后更新时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date lastupdatetime;

    
    //--------------------------------用于运营平台
    /**
     * 负责人姓名
     */
    private String principalName;

    /**
     * 上级组织
     */
    private String parentName;
    
    
    
    public BigInteger getOrganizationId(){
        return organizationId;
    }

    
    public void setOrganizationId(BigInteger organizationId){
        this.organizationId = organizationId;
    }

    
    public String getOrganizationName(){
        return organizationName;
    }

    
    public void setOrganizationName(String organizationName){
        this.organizationName = organizationName;
    }

    
    public BigInteger getPrincipalId(){
        return principalId;
    }

    
    public void setPrincipalId(BigInteger principalId){
        this.principalId = principalId;
    }

    
    public BigInteger getParentId(){
        return parentId;
    }

    
    public void setParentId(BigInteger parentId){
        this.parentId = parentId;
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


    public String getPrincipalName(){
        return principalName;
    }

    
    public void setPrincipalName(String principalName){
        this.principalName = principalName;
    }

    
    public String getParentName(){
        return parentName;
    }

    
    public void setParentName(String parentName){
        this.parentName = parentName;
    }

}