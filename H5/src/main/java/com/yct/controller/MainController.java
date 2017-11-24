package com.yct.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yct.bean.Emp;
import com.yct.bean.Menu;
import com.yct.bean.Power;
import com.yct.bean.base.RightPoint;
import com.yct.bean.base.TreeNode;
import com.yct.exception.BizException;
import com.yct.exception.BizExceptionMessage;
import com.yct.service.EmpService;
import com.yct.service.MenuService;
import com.yct.util.DateUtil;
import com.yct.util.MD5;

/**
 *@Description:系统基础功能控制层，包括登录、退出、权限检查等
 *@Author:wcj
 *@Since:2015年1月13日 下午2:53:12
 */
@Controller
@RequestMapping("/main")
public class MainController {

    /**
     * session用户key
     */
    public static final String SESSION_KEY = "oper_key";

    @Autowired
    private EmpService         empService;
    @Autowired
    private MenuService        menuService;

    /**
     * 员工登录
     * 
     * @param oper
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/login")
    public BizException login(Emp emp,HttpServletRequest request,HttpSession session) throws Exception{
    	BizException bizE = new BizException(BizExceptionMessage.SUCCESS);
        // 0.验证码
//        String code = (String) session.getAttribute ("patchcaimg");
//        if (code == null || !code.equalsIgnoreCase (checkCode)) { throw new Exception (); }

        // 1.登录检查，返回员工信息包含一级菜单信息
        Emp db = empService.login (emp);

        // 2.获取菜单
        List<Menu> menuList = menuService.getFirstMenus (new Power (db.getRoleId ()));

        // 3.判断是否首次登录
        if (db.getPassword ().equals (MD5.encodeByMD5ForLowercase ("123456"))) {// TODO 取业务参数
            session.setAttribute ("firstLogin", true);
        }

        // 5.设置session
        session.setAttribute ("firstMenus", menuList);
        session.setAttribute ("sysDateTime", DateUtil.getDateStr (new Date (), "CNS") + "/" + DateUtil.getWeek (new Date ()));
        session.setAttribute (SESSION_KEY, db);
		return bizE;
    }

    /**
     * 员工退出
     * 
     * @param oper
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/logout")
    public void logout(HttpSession session) throws Exception{
        if (session.getAttribute ("logId") != null) {
        }

        // 2.清除session
        session.removeAttribute (SESSION_KEY);
    }

    /**
     * 检查按钮权限
     * 
     * @param user
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/right")
    @RightPoint(nocheck = true)
    public String btnRight(String[] paths,HttpSession session) throws Exception{
        // 获取当前用户
        Emp curOper = (Emp) session.getAttribute (SESSION_KEY);
        // 判断用户权限列表中，是否包含当前路径
        List<Menu> menuList = menuService.getMenuListByRole (curOper.getRoleId ());

        StringBuffer sb = new StringBuffer ();
        int count = 0;
        for ( String path : paths ) {
            boolean hasRight = false;
            for ( Menu menu : menuList ) {
                if (menu.getMenuUrl () != null && menu.getMenuUrl ().contains (path)) {
                    hasRight = true;
                    break;
                }
            }
            sb.append (hasRight).append (++count == paths.length ? "" : "|");
        }

        return sb.toString ();
    }

    /**
     * 获取指定菜单的子菜单列表
     * 
     * @param rm
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/subMenus")
    @RightPoint(nocheck = true)
    public List<TreeNode> getSubMenus(Power power,HttpSession session) throws Exception{
        // 获取当前用户
        Emp curOper = (Emp) session.getAttribute (SESSION_KEY);
        power.setRoleId (curOper.getRoleId ());
        List<Menu> mList = menuService.getSubMenus (power);
        List<TreeNode> mTN = new ArrayList<TreeNode> ();
        for ( Menu m : mList ) {
            mTN.add (m.getTreeNode ());
        }
        return mTN;
    }

    /**
     * 获取当前登录员工
     * 
     * @param session
     */
    @ResponseBody
    @RequestMapping("/getCurOper")
    public Emp getCurOper(HttpSession session){
        return (Emp) session.getAttribute (SESSION_KEY);
    }

}
