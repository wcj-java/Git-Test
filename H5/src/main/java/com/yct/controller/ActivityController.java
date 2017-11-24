package com.yct.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yct.bean.Activity;
import com.yct.bean.Emp;
import com.yct.service.EmpService;

/**
 *@Description:员工管理 controller
 *@Author:wcj
 *@Since:2015年3月3日 下午2:23:27
 */
@Controller
@RequestMapping("/api/mobile/activity/")
public class ActivityController {

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
    @RequestMapping("/shop")
    public List<Activity> getEmpList() throws Exception{
    	Activity activity = new Activity();
    	List<Activity> list = new ArrayList<Activity>();
    	activity.setShopId(1);
    	activity.setName("sdfsf");
    	activity.setEndTime("2016-05-10");
    	list.add(activity);
        return list;
    }

  
}
