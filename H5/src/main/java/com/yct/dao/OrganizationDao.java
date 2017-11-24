package com.yct.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.yct.bean.Organization;
import com.yct.bean.base.PaginationEntity;
import com.yct.dao.base.BaseDao;

/**
 *@Description:组织Dao层
 *@Author:wcj
 *@Since:2015年1月19日上午9:20:39  
 */
@Repository
public class OrganizationDao extends BaseDao<Organization>{

    @Override
    public void insert(Organization domain){
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update(Organization domain){
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Organization domain){
        // TODO Auto-generated method stub
        
    }

    @Override
    public Organization selectOne(Organization domain){
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Organization> selectList(Organization domain){
        return getSqlSession ().selectList ("mp.OrganizationMapper.selectList", domain);
    }
    
    public void insertOrganization(Organization organization){
        getSqlSession ().insert ("mp.OrganizationMapper.insertOrganization", organization);
    }
    
    public void deleteByPrimaryKey(BigInteger organizationId){
        getSqlSession ().update ("mp.OrganizationMapper.deleteByPrimaryKey", organizationId);
    }
    
    public Organization selectByPrimaryKey(BigInteger organizationId){
        return getSqlSession ().selectOne ("mp.OrganizationMapper.selectByPrimaryKey", organizationId);
    }
    
    public void updateByPrimaryKey(Organization organization){
        getSqlSession ().update ("mp.OrganizationMapper.updateByPrimaryKey", organization);
    }
    
    /**
     * 查询分页对象
     * @param CallLog
     * @return
     */
    public PaginationEntity<Organization> selectPage(Organization organization){
        List<Organization> list = selectList (organization);
        organization.setIsPaging (false);
        int count = getSqlSession ().selectOne ("mp.OrganizationMapper.selectCount", organization);
        return new PaginationEntity<Organization> (count, list, organization);
    }
    
    /**
     * 查询所有组织信息
     */
    public List<Organization> getAllOrganization(){
        return this.getSqlSession ().selectList ("mp.OrganizationMapper.getAllOrganization");
    }


}
