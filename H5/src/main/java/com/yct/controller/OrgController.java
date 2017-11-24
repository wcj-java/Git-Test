package com.yct.controller;

import java.math.BigInteger;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yct.bean.Organization;
import com.yct.bean.base.LogPoint;
import com.yct.bean.base.PaginationEntity;
import com.yct.bean.base.RightPoint;
import com.yct.service.OrganizationService;

/**
 *@Description:组织管理 Controller
 *@Author:wcj
 *@Since:2015年3月3日 下午2:03:23
 */
@Controller
@RequestMapping("/org")
public class OrgController {

    @Autowired
    private OrganizationService organizationService;

    /**
     * 查询组织分页列表
     * @param organization
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/page")
    public PaginationEntity<Organization> getOrganizationPage(Organization organization) throws Exception{
        return organizationService.organizationPagination (organization);
    }

    /**
     * 查询组织信息
     * @param organization
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/get")
    public Organization queryOrganization(Organization organization) throws Exception{
        return organizationService.getOrganization (organization.getOrganizationId ());
    }

    /**
     * 添加组织
     * @param organization
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/insert")
    @RightPoint
    @LogPoint
    public void addOrganization(Organization organization,HttpSession session) throws Exception{
        organizationService.addOrganization (organization);
    }

    /**
     * 修改组织信息
     * @param organization
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/update")
    @RightPoint
    @LogPoint
    public void updateOrganization(Organization organization,HttpSession session) throws Exception{
        organizationService.upOrganization (organization);
    }

    /**
     * 删除组织
     * @param organization
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/delete")
    @RightPoint
    @LogPoint
    public void deleteOrganization(Organization organization,HttpSession session) throws Exception{
        for ( String organizationId : organization.getDelItems () ) {
            organizationService.delOrganization (new BigInteger (organizationId));
        }
    }

    /**
     * 获取所有组织
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/getAll")
    public List<Organization> getAllOrganization() throws Exception{
        return organizationService.getAllOrganization ();
    }

}
