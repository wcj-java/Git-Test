package com.yct.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.yct.bean.Power;
import com.yct.dao.base.BaseDao;

/**
 *@Description:权限Dao层
 *@Author:wcj
 *@Since:2015年1月19日上午9:25:56  
 */
@Repository
public class PowerDao extends BaseDao<Power>{

    @Override
    public void insert(Power domain){
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update(Power domain){
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Power domain){
        // TODO Auto-generated method stub
        
    }

    @Override
    public Power selectOne(Power domain){
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Power> selectList(Power domain){
        // TODO Auto-generated method stub
        return null;
    }
    
    public void insertPower(Power power){
        getSqlSession ().insert ("mp.PowerMapper.insertPower", power);
    }
    
    public void deletePower(Power power){
        getSqlSession ().delete ("mp.PowerMapper.deletePower", power);
    }
    
    public void deleteRolePower(Power power){
        getSqlSession ().delete ("mp.PowerMapper.deleteRolePower", power);
    }
    
    public List<Power> selectPowerByRoleId(BigInteger roleId){
        return getSqlSession ().selectList ("mp.PowerMapper.selectPowerByRoleId", roleId);
    }


}
