package com.yct.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.yct.bean.Emp;
import com.yct.bean.base.PaginationEntityBase;
import com.yct.dao.base.BaseDao;

/**
 *@Description:员工持久层
 *@Author:wcj
 *@Since:2015年1月13日 上午9:51:06
 */
@Repository
public class EmpDao extends BaseDao<Emp> {

    @Override
    public void insert(Emp domain){
        this.getSqlSession ().insert ("mp.EmpMapper.insert", domain);
    }

    @Override
    public void update(Emp domain){
        this.getSqlSession ().update ("mp.EmpMapper.updateByPrimaryKey", domain);
    }

    @Override
    public void delete(Emp domain){
        this.getSqlSession ().delete ("mp.EmpMapper.deleteByPrimaryKey", domain);
    }

    @Override
    public Emp selectOne(Emp domain){
        return this.getSqlSession ().selectOne ("mp.EmpMapper.selectByPrimaryKey", domain);
    }

    @Override
    public List<Emp> selectList(Emp domain){
        return this.getSqlSession ().selectList ("mp.EmpMapper.selectList", domain);
    }

    /**
     * 查询分页对象
     * @param domain
     * @return
     */
    public PaginationEntityBase<Emp> selectPage(Emp domain){
        List<Emp> list = selectList (domain);
        int count = this.getSqlSession ().selectOne ("mp.EmpMapper.selectCount", domain);
        return new PaginationEntityBase<Emp> (count, list, domain);
    }

    /**
     * 根据用户名查询员工
     * @param emp
     * @return
     */
    public Emp selectEmpByUsername(Emp emp) {
        return this.getSqlSession ().selectOne ("mp.EmpMapper.selectEmpByUsername", emp);
    }
    
    /**
     * 根据工号查询员工
     * @param emp
     * @return
     */
    public Emp selectEmpByEmpNum(Emp emp) {
        return this.getSqlSession ().selectOne ("mp.EmpMapper.selectEmpByEmpNum", emp);
    }
    
    /**
     * 修改密码
     */
    public void updatePasswordByEmpId(Emp emp){
        this.getSqlSession ().update ("mp.EmpMapper.updatePasswordByEmpId", emp);
    }
    
    /**
     * 根据角色查询员工
     */
    public List<Emp> getEmpListByRole(BigInteger roleId){
        return this.getSqlSession ().selectList ("mp.EmpMapper.getEmpListByRole", roleId);
    }
    
    /**
     *根据组织查询员工
     */
    public List<Emp> getEmpListByOrganization(BigInteger organizationId){
        return this.getSqlSession ().selectList ("mp.EmpMapper.getEmpListByOrganization", organizationId);
    }
    
}
