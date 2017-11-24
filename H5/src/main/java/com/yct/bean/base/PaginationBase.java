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
public class PaginationBase extends BaseEntity {

    private static final long serialVersionUID = 6435231251230621635L;

    /** RequestInterceptor拦截参数=(b=b1&start=0&limit=3&pageIndex=0);请求的连接=(/win7/emp/list)
    * 页码，第几页的数据，从1开始。（大于0的整数。默认为1）<br /> 支持最大值为：2147483647<br /> 支持最小值为：-21474836478
     */
    private Integer           start           = 1;

    /** 
    * 每页条数。（每页条数不超过50条）<br /> 支持最大值为：2147483647<br /> 支持最小值为：-21474836478
     */
    private Integer           limit         = 10;

    /**
     * 总记录数。<br />支持最大值为：2147483647<br /> 支持最小值为：-21474836478
     */
    private Integer           totalRows;

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}

    
    
}
