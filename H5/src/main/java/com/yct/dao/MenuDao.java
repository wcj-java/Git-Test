package com.yct.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.yct.bean.Menu;
import com.yct.bean.Power;
import com.yct.dao.base.BaseDao;

/**
 *@Description:菜单持久层
 *@Author:wcj
 *@Since:2015年1月14日 下午2:26:50
 */
@Repository
public class MenuDao extends BaseDao<Menu> {

    @Override
    public void insert(Menu domain){
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update(Menu domain){
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Menu domain){
        // TODO Auto-generated method stub
        
    }

    @Override
    public Menu selectOne(Menu domain){
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Menu> selectList(Menu domain){
        // TODO Auto-generated method stub
        return null;
    }
    
    /**
     * 查询用户一级菜单列表
     * @param m
     * @return
     */
    public List<Menu> getFirstMenus(Power p) {
        return this.getSqlSession ().selectList ("mp.MenuMapper.selectFistMenuList", p);
    }
    
    /**
     * 查询用户子菜单(只一层)列表
     * @param m
     * @return
     */
    public List<Menu> getSubMenus(Power p) {
        return this.getSqlSession ().selectList ("mp.MenuMapper.selectSubMenuList", p);
    }
    
    public void insertMenu(Menu menu){
        getSqlSession ().insert ("mp.MenuMapper.insertMenu",menu);
    }
    
    public void deleteByPrimaryKey(BigInteger menuId){
        getSqlSession ().delete ("mp.MenuMapper.deleteByPrimaryKey", menuId);
    }
    
    public Menu selectByPrimaryKey(BigInteger menuId){
        return getSqlSession ().selectOne ("mp.MenuMapper.selectByPrimaryKey", menuId);
    }
    
    public void updateByPrimaryKey(Menu menu){
        getSqlSession ().update ("mp.MenuMapper.updateByPrimaryKey", menu);
    }
    
    /**
     *@Description: 根据角色查询菜单
     *@return List<Menu>    返回类型 
     *@Author: wcj
     *@Since: 2015年3月4日下午2:51:53
     *@param roleId
     *@return
     */
    public List<Menu> getMenuListByRole(BigInteger roleId){
        return getSqlSession ().selectList ("mp.MenuMapper.getMenuListByRole", roleId);
    }

    /**
     * 根据菜单url查询菜单
     * @param m
     * @return
     */
    public Menu selectMenuByUrl(Menu m){
        return getSqlSession ().selectOne ("mp.MenuMapper.getMenuByUrl", m.getMenuUrl ());
    }

}
