package com.yct.dao.base;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.yct.bean.base.BaseEntity;

/**
 * Dao基类
 * @param <O>
 * 
 * @version 1.0.0
 * @author wcj
 * @since 2014.10.28
 */
public abstract class BaseDao<O extends BaseEntity> extends SqlSessionDaoSupport {

    @Resource
    private SqlSessionFactory sqlSessionFactory;

    @PostConstruct
    public void setSqlSessionFactory(){
        super.setSqlSessionFactory (sqlSessionFactory);
    }
	
    /**
     * 插入
     * 
     * @param model
     */
    public abstract void insert(O domain);

    /**
     * 更新
     * 
     * @param model
     */
    public abstract void update(O domain);

    /**
     * 删除
     * 
     * @param model
     */
    public abstract void delete(O domain);

    /**
     * 查询单个实体
     * 
     * @param model
     */
    public abstract O selectOne(O domain);

    /**
     * 查询实体列表
     * 
     * @param model
     */
    public abstract List<O> selectList(O domain);

}
