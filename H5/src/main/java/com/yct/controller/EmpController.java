package com.yct.controller;

import java.math.BigInteger;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yct.bean.Emp;
import com.yct.bean.base.LogPoint;
import com.yct.bean.base.PaginationEntityBase;
import com.yct.bean.base.RightPoint;
import com.yct.service.EmpService;

/**
 *@Description:员工管理 controller
 *@Author:wcj
 *@Since:2015年3月3日 下午2:23:27
 */
@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     * 查询员工列表
     * 
     * @param emp
     * @param session
     * @return
     * @throws Exception
     */

    @ResponseBody
    @RequestMapping("/list")
    public PaginationEntityBase<Emp> getEmpList(Emp emp,HttpSession session) throws Exception{
        return empService.empPagination (emp);
    }

    /**
     * 查询员工信息
     * 
     * @param emp
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/get")
    @RightPoint(path = "jsp/emp/EmpList.jsp")
    public Emp getEmp(Emp emp,HttpSession session) throws Exception{
        return empService.getEmp (emp.getEmpId ());
    }

    /**
     * 新增员工
     * 
     * @param emp
     * @param session
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/insert")
    @RightPoint
    @LogPoint
    public void insertEmp(Emp emp,HttpSession session) throws Exception{
        empService.addEmp (emp);
    }

    /**
     * 修改员工
     * 
     * @param emp
     * @param session
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/update")
    @RightPoint
    @LogPoint
    public void updateEmp(Emp emp,HttpSession session) throws Exception{
        empService.upEmp (emp);
    }

    /**
     * 删除员工
     * 
     * @param emp
     * @param session
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/delete")
    @RightPoint
    @LogPoint
    public void deleteEmp(Emp emp,HttpSession session) throws Exception{
        for ( String empId : emp.getDelItems () ) {
            empService.delEmp (new BigInteger(empId));
        }
    }

    /**
     * 重置密码为初始密码
     * 
     * @param emp
     * @param session
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/resetPwd")
    @RightPoint
    @LogPoint
    public void resetPwd(Emp emp,HttpSession session) throws Exception{
        empService.resetPassword (emp);
    }

    /**
     * 修改用户的密码
     * 
     * @param emp
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/modPwd")
    @RightPoint(nocheck = true)
    @LogPoint
    public void modifyPwd(Emp emp, String newPassword,HttpSession session) throws Exception{
        if(emp.getPassword () == null) {//重设密码
            emp.setPassword (newPassword);
            empService.upEmpPassword (emp);
            session.removeAttribute ("firstLogin");
        }else{
            empService.upPasswordVerifyOldPassword (emp, newPassword);
        }
    }

    /**
     * 个人信息修改
     * 
     * @param emp
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/empSet")
    @RightPoint(nocheck = true)
    @LogPoint
    public void empSet(Emp emp,HttpSession session) throws Exception{
        empService.upEmp (emp);
    }

    /**
     * 查询组织下的员工列表
     * 
     * @param emp
     * @param session
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/empList")
    @RightPoint(nocheck = true)
    public List<Emp> getEmpLists(Emp emp,HttpSession session) throws Exception{
        return empService.getEmpListByOrganization (emp.getOrganizationId ());
    }

}
