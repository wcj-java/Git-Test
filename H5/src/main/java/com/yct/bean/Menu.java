package com.yct.bean;

import java.math.BigInteger;

import com.yct.bean.base.BaseEntity;
import com.yct.bean.base.TreeNode;

/**
 *@Description:菜单实体类
 *@Author:wcj
 *@Since:2015年1月10日下午1:51:09  
 */
public class Menu extends BaseEntity {

    private static final long serialVersionUID = 356902824856702827L;

    /**
     * 实体类编号
     */
    private BigInteger        menuId;

    /**
     * 菜单名称
     */
    private String            menuName;

    /**
     * 父层菜单
     */
    private BigInteger        parentId;

    /**
     * 菜单地址
     */
    private String            menuUrl;

    /**
     * 菜单级别
     */
    private Integer           menuLevel;

    /**
     * 菜单状态
     */
    private Integer           menuState;
    /**
     * 菜单描述
     */
    private String           menuDesc;
    
    /**
     * 菜单排序
     */
    private Integer           menuOrder;
    
    //--------------------运营平台
    /**
     * (被操作者)是否有权限
     *  0:没有权限
     *  1：有权限
     */
     private int isPower;

    // =============================================================================
    
    public Menu() {}

    public Menu(BigInteger menuId, String menuName) {
        this.menuId = menuId;
        this.menuName = menuName;
    }

    // =============================================================================

    public TreeNode getTreeNode(){
        return new TreeNode (this.menuId.toString (),this.parentId.toString (),this.menuName,this.menuState - 1 == 0,this.menuUrl,this.menuId + ".gif", isPower == 1);
    }

    // =============================================================================

    public BigInteger getMenuId(){
        return menuId;
    }

    public void setMenuId(BigInteger menuId){
        this.menuId = menuId;
    }

    public String getMenuName(){
        return menuName;
    }

    public void setMenuName(String menuName){
        this.menuName = menuName;
    }

    public BigInteger getParentId(){
        return parentId;
    }

    public void setParentId(BigInteger parentId){
        this.parentId = parentId;
    }

    public String getMenuUrl(){
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl){
        this.menuUrl = menuUrl;
    }

    public Integer getMenuLevel(){
        return menuLevel;
    }

    public void setMenuLevel(Integer menuLevel){
        this.menuLevel = menuLevel;
    }

    public Integer getMenuState(){
        return menuState;
    }

    public void setMenuState(Integer menuState){
        this.menuState = menuState;
    }

    public String getMenuDesc(){
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc){
        this.menuDesc = menuDesc;
    }

    public Integer getMenuOrder(){
        return menuOrder;
    }

    public void setMenuOrder(Integer menuOrder){
        this.menuOrder = menuOrder;
    }
    
    public int getIsPower(){
        return isPower;
    }
    
    public void setIsPower(int isPower){
        this.isPower = isPower;
    }

}