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
public class PaginationEntity<T extends BaseEntity> extends Pagination {

    private static final long serialVersionUID = -993005175060432408L;

    public PaginationEntity() {
    }

    /**
     * 构造分页对象
     * @param count 总记录数
     * @param domainList 分页列表
     * @param pagination 分页对象
     */
    public PaginationEntity(int count, List<T> domainList, Pagination pagination) {
        this.setIsPaging (pagination.getIsPaging ());
        this.setPageNo (pagination.getPageNo ());
        this.setPageSize (pagination.getPageSize ());
        this.setItems (domainList);
        this.setTotalCount (count);
        this.setPageCount (count % pagination.getPageSize () == 0 ? count / pagination.getPageSize () : count / pagination.getPageSize () + 1);
    }

    private List<T> items;

    public List<T> getItems(){
        return items;
    }

    public void setItems(List<T> items){
        this.items = items;
    }

    @Override
    public String toString(){
        return "NcbPaginationObject [items=" + items + "]";
    }
}
