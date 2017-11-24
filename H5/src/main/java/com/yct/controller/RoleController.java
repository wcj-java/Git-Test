package com.yct.controller;

import java.math.BigInteger;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yct.bean.Emp;
import com.yct.bean.Menu;
import com.yct.bean.Power;
import com.yct.bean.Role;
import com.yct.bean.base.LogPoint;
import com.yct.bean.base.PaginationEntity;
import com.yct.bean.base.RightPoint;
import com.yct.bean.base.TreeNode;
import com.yct.service.MenuService;
import com.yct.service.PowerService;
import com.yct.service.RoleService;

/**
 * 角色 控制层
 *
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService  roleService;
    @Autowired
    private MenuService  menuService;
    @Autowired
    private PowerService powerService;

    /**
     * 查询角色列表
     * @return
     * @throws Exception 
     */
    @ResponseBody
    @RequestMapping("/list")
    @RightPoint(path = "jsp/role/RoleList.jsp")
    public PaginationEntity<Role> getRoleList(Role role,HttpSession session) throws Exception{
        return roleService.rolePagination (role);
    }

    /**
     * 查询角色信息
     * @param role
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/get")
    @RightPoint(path = "jsp/role/RoleList.jsp")
    public Role getRole(Role role,HttpSession session) throws Exception{
        return roleService.getRole (role.getRoleId ());
    }

    /**
     * 新增角色
     * @param role
     * @param session
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/insert")
    @RightPoint
    @LogPoint
    public void insertRole(Role role,HttpSession session) throws Exception{
        roleService.addRole (role);
    }

    /**
     * 修改角色
     * @param role
     * @param session
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/update")
    @RightPoint
    @LogPoint
    public void updateRole(Role role,HttpSession session) throws Exception{
        roleService.upRole (role);
    }

    /**
     * 删除角色
     * @param role
     * @param session
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/delete")
    @RightPoint
    @LogPoint
    public void deleteRole(Role role,HttpSession session) throws Exception{
        for ( String roleId : role.getDelItems () ) {
            roleService.delRole (new BigInteger (roleId));
        }
    }

    /**
     * 权限分配页面
     * @param role
     * @param session
     * @return
     * @throws Exception 
     */
    @ResponseBody
    @RequestMapping("/getPower")
    @RightPoint(path = "/role/power")
    public List<TreeNode> getPower(Role role,HttpSession session) throws Exception{
        // 获取当前用户
        Emp curOper = (Emp) session.getAttribute (MainController.SESSION_KEY);
        return TreeNode.getTreeNodeList (menuService.getMenuListByRole (curOper.getRoleId (), role.getRoleId ()));
    }

    /**
     * 权限分配
     * @param role
     * @param session
     */
    @ResponseBody
    @RequestMapping("/power")
    @RightPoint
    @LogPoint
    public void power(Role role,HttpSession session) throws Exception{
        // 查询角色所有权限
        List<Menu> menuList = menuService.getMenuListByRole (role.getRoleId ());

        if (role.getMenuIds () != null) {
            // 处理新增的菜单
            for ( String menuId : role.getMenuIds () ) {
                boolean flag = true;
                for ( Menu m : menuList ) {
                    if (new BigInteger (menuId).intValue () == m.getMenuId ().intValue ()) {
                        flag = false;
                        continue;
                    }
                }
                if (flag) {
                    powerService.addPower (new Power (role.getRoleId (),new BigInteger (menuId)));
                }
            }
            // 处理去除的菜单
            for ( Menu m : menuList ) {
                boolean flag = true;
                for ( String menuId : role.getMenuIds () ) {
                    if (new BigInteger (menuId).intValue () == m.getMenuId ().intValue ()) {
                        flag = false;
                        continue;
                    }
                }
                if (flag) {
                    powerService.delPower (new Power (role.getRoleId (), m.getMenuId ()));
                }
            }
        } 
        // 删除菜单所有权限
        else {
            powerService.delRoleAll (new Power (role.getRoleId ()));
        }
    }

    /**
     * 查询组织下角色列表
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/roleList")
    @RightPoint(nocheck = true)
    public List<Role> getOrgRoleList(Role role,HttpSession session) throws Exception{
        return roleService.getRoleListByOrganization (role.getOrganizationId ());
    }

}
