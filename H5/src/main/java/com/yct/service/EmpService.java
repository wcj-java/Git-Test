package com.yct.service;

import java.math.BigInteger;
import java.util.List;

import org.omg.CORBA.SystemException;
import org.springframework.stereotype.Repository;

import com.yct.bean.Emp;
import com.yct.bean.base.PaginationEntityBase;
import com.yct.exception.BizException;

/**
 *@Description:员工服务接口
 *@Author:wcj
 *@Since:2015年1月15日 上午9:59:58
 */
@Repository
public interface EmpService {

    /**
     * 登录获取员工信息
     * @param emp
     * @return
     */
    Emp login(Emp emp) throws Exception;

    /**
     *@Description: 增加员工 
     *@return void    返回类型 
     *@Author: wcj
     *@Since: 2015年2月2日上午9:54:52
     *@param emp
     *@throws BizException
     *@throws SystemException
     */
    void addEmp(Emp emp) throws Exception;

    /**
     *@Description: 删除员工
     *@return void    返回类型 
     *@Author: wcj
     *@Since: 2015年2月2日上午9:54:48
     *@param empId
     *@throws BizException
     *@throws SystemException
     */
    void delEmp(BigInteger empId) throws Exception;

    /**
     *@Description: 查询员工
     *@return Emp    返回类型 
     *@Author: wcj
     *@Since: 2015年2月2日上午9:54:44
     *@param empId
     *@return
     *@throws BizException
     *@throws SystemException
     */
    Emp getEmp(BigInteger empId) throws Exception;
    
    /**
     *@Description: 修改员工信息
     *@return void    返回类型 
     *@Author: wcj
     *@Since: 2015年2月2日上午9:54:40
     *@param emp
     *@throws BizException
     *@throws SystemException
     */
    void upEmp(Emp emp) throws Exception;
    
    /**
     *@Description: 修改密码 (要先验证旧密码)
     *@return void    返回类型 
     *@Author: wcj
     *@Since: 2015年3月3日上午9:30:21
     *@param emp 旧密码
     *@param password 新密码
     *@throws BizException
     *@throws SystemException
     */
    void upPasswordVerifyOldPassword(Emp emp, String password) throws Exception;
    
    /**
     *@Description: 修改密码
     *@return void    返回类型 
     *@Author: wcj
     *@Since: 2015年3月5日下午3:49:20
     *@param emp
     *@throws BizException
     *@throws SystemException
     */
    void upEmpPassword(Emp emp) throws Exception;
    
    /**
     *@Description: 重置密碼
     *@return void    返回类型 
     *@Author: wcj
     *@Since: 2015年3月5日下午12:52:12
     *@param emp
     *@throws BizException
     *@throws SystemException
     */
    void resetPassword(Emp emp) throws Exception;
    
    /**
     *@Description: 查询员工列表信息（分页） 
     *@return PaginationEntity<Emp>    返回类型 
     *@Author: wcj
     *@Since: 2015年2月2日上午9:56:16
     *@param emp
     *@return
     *@throws BizException
     *@throws SystemException
     */
    PaginationEntityBase<Emp> empPagination(Emp emp) throws Exception;
    
    /**
     *@Description: 根据组织ID查询员工信息
     *@return List<Emp>    返回类型 
     *@Author: wcj
     *@Since: 2015年3月3日下午3:49:05
     *@return
     *@throws BizException
     *@throws SystemException
     */
    List<Emp> getEmpListByOrganization(BigInteger organizationId) throws Exception;
}
