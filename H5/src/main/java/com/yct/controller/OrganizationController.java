package com.yct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yct.bean.Organization;
import com.yct.bean.base.PaginationEntity;
import com.yct.service.OrganizationService;

/**
 *@Description:订单控制层
 *@Author:wcj
 *@Since:2015年1月16日 下午4:24:22
 */
@Controller
@RequestMapping("/organization")
public class OrganizationController{

    @Autowired
    private OrganizationService organizationService;

    /**
     * 订单监控列表
     * @param order
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/page")
    public PaginationEntity<Organization> monitor(Organization organization) throws Exception{
        return organizationService.organizationPagination (organization);
    }
    

}
