package com.yct.filter;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 *@Description:请求有效性拦截器
 *@Author:wcj
 *@Since:2015-03-26
 */

public class RequestInterceptor extends HandlerInterceptorAdapter {
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String requestContent = "";
        //获取所有的请求参数组装
        Enumeration<?> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
         String paramName = (String) paramNames.nextElement();
         String[] paramValues = request.getParameterValues(paramName);
         if (paramValues.length == 1) {
          String paramValue = paramValues[0];
          if (paramValue.length() != 0) {
           requestContent += paramName + "=" + paramValue;
          }
          if(paramNames.hasMoreElements()){requestContent += "&";}
         }
        }
        
        System.out.println ("RequestInterceptor拦截参数=("+requestContent+");请求的连接=("+request.getRequestURI()+")");
		return true;
    }
 
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    	super.postHandle(request, response, handler, modelAndView);
    }
}
