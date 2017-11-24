package com.yct.bean.base;

import java.util.List;


/**
 * 分页对象类，继承于分页基类，存放分页信息和对象
 * 传参数时可以用分页基类
 * 返回时需要用该类，把对象放在items中
 * 
 * @author william
 * @author wcj
 * @since 1.0.0
 *
 */
public class PaginationEntityBase<T extends BaseEntity> extends PaginationBase{

    private static final long serialVersionUID = -993005175060432408L;
    
    private boolean success = true;
    private List<T> data;
    
    public PaginationEntityBase() {
    }

    /**
     * 构造分页对象
     * @param count 总记录数
     * @param domainList 分页列表
     * @param pagination 分页对象
     */
    public PaginationEntityBase(int count, List<T> domainList, PaginationBase pagination) {
        this.setStart (pagination.getStart());
        this.setLimit (pagination.getLimit());
        this.setData (domainList);
        this.setTotalRows (count);
    }
    
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
	@Override
    public String toString(){
        return "NcbPaginationObject [items=" + data + "]";
    }
}
