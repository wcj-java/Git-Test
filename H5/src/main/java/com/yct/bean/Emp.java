package com.yct.bean;

import java.math.BigInteger;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.yct.bean.base.PaginationBase;

/**
 *@Description:员工实体类
 *@Author:wcj
 *@Since:2015年1月10日下午1:48:56  
 */
public class Emp extends PaginationBase{
    /** 
     *@Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */ 
    private static final long serialVersionUID = -1665058428871090694L;

    /**
     * 员工编号
     */
    private BigInteger empId;
    /**
     * 员工工号
     */
    private String empNum;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别(0:男  1:女)
     */
    private Integer sex;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 座机
     */
    private String telphone;

    /**
     * 手机
     */
    private String mobilephone;

    /**
     * qq
     */
    private String qq;

    /**
     * email
     */
    private String email;

    /**
     * 所属组织
     */
    private BigInteger organizationId;

    /**
     * 所属角色
     */
    private BigInteger roleId;

    /**
     * 登录账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;
    
    /**
     * 状态(0：正常，1：注销，2：暂时冻结)
     */
    private Integer status;

    /**
     * 创建时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    /**
     * 最后更新时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updatetime;
    
    
    //--------------------------------用于运营平台
    /**
     * 性别(0:男  1:女)
     */
    private String sexStr;
    
    /**
     * 状态(0：正常，1：注销，2：暂时冻结)
     */
    private String statusStr;
    
    /**
     * 所属组织
     */
    private String organizationStr;

    /**
     * 所属角色
     */
    private String roleStr;
    
    
    public BigInteger getEmpId(){
        return empId;
    }

    
    public void setEmpId(BigInteger empId){
        this.empId = empId;
    }
    
    public String getEmpNum(){
        return empNum;
    }

    public void setEmpNum(String empNum){
        this.empNum = empNum;
    }

    public String getName(){
        return name;
    }

    
    public void setName(String name){
        this.name = name;
    }

    
    public Integer getSex(){
        return sex;
    }

    
    public void setSex(Integer sex){
        this.sex = sex;
    }

    public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public String getTelphone(){
        return telphone;
    }

    
    public void setTelphone(String telphone){
        this.telphone = telphone;
    }

    
    public String getMobilephone(){
        return mobilephone;
    }

    
    public void setMobilephone(String mobilephone){
        this.mobilephone = mobilephone;
    }

    
    public String getQq(){
        return qq;
    }

    
    public void setQq(String qq){
        this.qq = qq;
    }

    
    public String getEmail(){
        return email;
    }

    
    public void setEmail(String email){
        this.email = email;
    }

    
    public BigInteger getOrganizationId(){
        return organizationId;
    }

    
    public void setOrganizationId(BigInteger organizationId){
        this.organizationId = organizationId;
    }

    
    public BigInteger getRoleId(){
        return roleId;
    }

    
    public void setRoleId(BigInteger roleId){
        this.roleId = roleId;
    }

    
    public String getUsername(){
        return username;
    }

    
    public void setUsername(String username){
        this.username = username;
    }

    
    public String getPassword(){
        return password;
    }

    
    public void setPassword(String password){
        this.password = password;
    }

    
    public Date getCreatetime(){
        return createtime;
    }

    
    public void setCreatetime(Date createtime){
        this.createtime = createtime;
    }

    
    public Date getUpdatetime(){
        return updatetime;
    }

    
    public void setUpdatetime(Date updatetime){
        this.updatetime = updatetime;
    }

    
    public Integer getStatus(){
        return status;
    }


    public void setStatus(Integer status){
        this.status = status;
    }


    //性别(0:男  1:女)
    public String getSexStr(){
        if(null != this.sex && null == this.sexStr){
            if(0 == this.sex){
                this.sexStr = "男";
            }else if (1 == this.sex) {
                this.sexStr = "女";
            }
        }
        return sexStr;
    }


    
    public void setSexStr(String sexStr){
        this.sexStr = sexStr;
    }


    //状态(0：正常，1：注销，2：暂时冻结)
    public String getStatusStr(){
        if(null != this.status && null == this.statusStr){
            if(0 == this.status){
                this.statusStr = "正常";
            }else if (1 == this.status) {
                this.statusStr = "注销";
            }else if (2 == this.status) {
                this.statusStr = "暂时冻结"; 
            }
        }
        return statusStr;
    }


    
    public void setStatusStr(String statusStr){
        this.statusStr = statusStr;
    }


    
    public String getOrganizationStr(){
        return organizationStr;
    }


    
    public void setOrganizationStr(String organizationStr){
        this.organizationStr = organizationStr;
    }


    
    public String getRoleStr(){
        return roleStr;
    }


    
    public void setRoleStr(String roleStr){
        this.roleStr = roleStr;
    }

    
}