package com.yct.bean.base;

import java.util.ArrayList;
import java.util.List;

/**
 *@Description:ligerUI树节点
 *@Author:wcj
 *@Since:2015年1月14日 下午1:44:00
 */
public class TreeNode {

    /** 节点id */
    public String  id;
    /** 父节点id */
    public String  pid;
    /** 节点名称 */
    public String  text;
    /** 节点是否展开 */
    public boolean isexpand  = false;
    /** 节点链接地址 */
    public String  url;
    /** 节点图标名称 */
    public String  icon;
    /** 是否勾选 */
    public boolean ischecked = false;

    // ====================================================

    public TreeNode(String id, String pid, String text, boolean isexpand, String url, String icon, boolean ischecked) {
        super ();
        this.id = id;
        this.pid = pid;
        this.text = text;
        this.isexpand = isexpand;
        this.url = url;
        this.icon = icon;
        this.ischecked = ischecked;
    }

    // ====================================================

    /**
      * 将任意domainList变成treenodeList
      *
      * @param bl
      * @return
      * @throws Exception 
      */
    public static List<TreeNode> getTreeNodeList(List<? extends BaseEntity> bl){
        List<TreeNode> treeNodes = new ArrayList<TreeNode> ();
        for ( BaseEntity d : bl ) {
            try {
                treeNodes.add (d.getTreeNode ());
            } catch (Exception e) {
                // TODO
            }
        }
        return treeNodes;
    }

}
