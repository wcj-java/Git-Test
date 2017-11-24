package com.yct.bean.base;

/**
 * 分页基类<br />
 * 传参数时可以用该基类<br />
 * 返回时需要用PaginationEntity，把对象放在items中
 * 
 * @version 1.0.0
 * @author wcj
 * @since 1.0.0
 *
 */
public class Pagination extends BaseEntity {

    private static final long serialVersionUID = 6435231251230621635L;

    /** 
    * 页码，第几页的数据，从1开始。（大于0的整数。默认为1）<br /> 支持最大值为：2147483647<br /> 支持最小值为：-21474836478
     */
    private Integer           pageNo           = 1;

    /** 
    * 每页条数。（每页条数不超过50条）<br /> 支持最大值为：2147483647<br /> 支持最小值为：-21474836478
     */
    private Integer           pageSize         = 10;

    /**
     * 总记录数。<br />支持最大值为：2147483647<br /> 支持最小值为：-21474836478
     */
    private Integer           totalCount;

    /**
     * 总页数。
     */
    private Integer           pageCount;

    /**
     * 是否分页
     */
    private Boolean           isPaging         = false;

    /**
     * 要排序的字段名（需是数据库表中的属性名称）
     */
    private String            sortName;
    
    /**
     * 排序，为空不排序，desc倒序，asc顺序
     */
    private String            sortOrder;

    public Integer getPageNo(){
        return pageNo;
    }

    public void setPageNo(Integer pageNo){
        this.pageNo = pageNo;
    }

    public Integer getPageSize(){
        return pageSize;
    }

    public void setPageSize(Integer pageSize){
        this.pageSize = pageSize;
    }

    public Integer getTotalCount(){
        return totalCount;
    }

    public void setTotalCount(Integer totalCount){
        this.totalCount = totalCount;
    }

    public Integer getPageCount(){
        return pageCount;
    }

    public void setPageCount(Integer pageCount){
        this.pageCount = pageCount;
    }

    public Boolean getIsPaging(){
        return isPaging;
    }

    public void setIsPaging(Boolean isPaging){
        this.isPaging = isPaging;
    }

    
    public String getSortName(){
        return sortName;
    }

    
    public void setSortName(String sortName){
        this.sortName = sortName;
    }

    
    public String getSortOrder(){
        return sortOrder;
    }

    
    public void setSortOrder(String sortOrder){
        this.sortOrder = sortOrder;
    }
    
}
