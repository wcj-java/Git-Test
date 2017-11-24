package com.yct.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.yct.bean.Role;
import com.yct.bean.base.PaginationEntity;
import com.yct.dao.base.BaseDao;

/**
 *@Description: 角色Dao层
 *@Author:wcj
 *@Since:2015年1月19日上午9:30:36  
 */
@Repository
public class RoleDao extends BaseDao<Role>{

    @Override
    public void insert(Role domain){
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update(Role domain){
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Role domain){
        // TODO Auto-generated method stub
        
    }

    @Override
    public Role selectOne(Role domain){
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Role> selectList(Role domain){
        return getSqlSession ().selectList ("mp.RoleMapper.selectList", domain);
    }
    
    public void insertRole(Role role){
        getSqlSession ().insert ("mp.RoleMapper.insertRole", role);
    }
    
    public void deleteByPrimaryKey(BigInteger roleId){
        getSqlSession ().delete ("mp.RoleMapper.deleteByPrimaryKey", roleId);
    }
    
    public Role selectByPrimaryKey(BigInteger roleId){
        return getSqlSession ().selectOne ("mp.RoleMapper.selectByPrimaryKey", roleId);
    }
    
    public void updateByPrimaryKey(Role role){
        getSqlSession ().update ("mp.RoleMapper.updateByPrimaryKey", role);
    }
    
    /**
     * 查询分页对象
     * @param Role
     * @return
     */
    public PaginationEntity<Role> selectPage(Role role){
        List<Role> list = selectList (role);
        role.setIsPaging (false);
        int count = getSqlSession ().selectOne ("mp.RoleMapper.selectCount", role);
        return new PaginationEntity<Role> (count, list, role);
    }
    
    /**
     *@Description: 根据组织查询角色 
     *@return List<Role>    返回类型 
     *@Author: wcj
     *@Since: 2015年3月4日上午10:02:02
     *@param organizationId
     *@return
     */
    public List<Role> getRoleListByOrganization(BigInteger organizationId){
        return this.getSqlSession ().selectList ("getRoleListByOrganization", organizationId);
    }


}
