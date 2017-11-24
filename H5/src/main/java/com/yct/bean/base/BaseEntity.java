package com.yct.bean.base;


/**
 * 抽象实体类，可作为所有领域实体的基类。
 *
 * @author wcj
 *
 */
public abstract class BaseEntity implements Entity {

    private static final long serialVersionUID = 5071144190106865772L;
    
    /** 辅助字段 */
    private String param;
    
    /** 辅助字段，操作日志 */
    private String logDetail;

    /** 数组辅助参数 */
    protected String[] delItems;

    //==================================================
    
    /**
     * 获取树节点数据结构（子类中实现）
     * @return
     */
    public TreeNode getTreeNode() {
        return null;
    }
    
    //==================================================
    
    public String getParam(){
        return param;
    }
    public void setParam(String param){
        this.param = param;
    }
    public String getLogDetail(){
        return logDetail;
    }
    public void setLogDetail(String logDetail){
        this.logDetail = logDetail;
    }
    public String[] getDelItems(){
        return delItems;
    }
    public void setDelItems(String[] delItems){
        this.delItems = delItems;
    }
    
}
