package com.yct.exception;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


/**
 * 业务错误代码
 * @author wcj
 *
 */
public class BizExceptionMessage {

    @ExceptionInfo(key = "0",value = "运行正确。")
    public static final String         SUCCESS                        = "0";
    
    // -------------------------------后台服务9001开头------------------------------------------
    @ExceptionInfo(key = "9001001",value = "登录失败，验证码不正确")
    public static final String         ERROR_LOGIN_CHECKCODE          = "9001001";

    @ExceptionInfo(key = "9001002",value = "登录失败，用户名或密码不正确")
    public static final String         ERROR_LOGIN_USERNAMEORPASSWORD = "9001002";
    @ExceptionInfo(key = "9001003",value = "该活动已经结束，禁止操作")
    public static final String         ERROR_ACTIVITY_EXSIXS = "9001003";
    
    @ExceptionInfo(key = "9001004",value = "添加失败，该运营人员电话已存在")
    public static final String         ERROR_PHONE_EXIST          = "9001004";
    
    @ExceptionInfo(key = "9001005",value = "添加失败，该客户人员电话已存在")
    public static final String         ERROR_CUSTEMERPHONE_EXIST          = "9001005";
    
    // ==================================================================================================
    
    /** 异常map */
    private Map<String, String>        exps                           = new HashMap<String, String> ();

    /** 单例实现 */
    private static BizExceptionMessage ce                             = null;

    private BizExceptionMessage() {}

    public synchronized static BizExceptionMessage getInstance(){
        if (ce == null) ce = new BizExceptionMessage ();
        // 支持热部署
        ce.exps.clear ();
        /** 构造异常map */
        for ( Field f : BizExceptionMessage.class.getDeclaredFields () ) {
            ExceptionInfo expInfo = f.getAnnotation (ExceptionInfo.class);
            if (expInfo == null) {
                continue;
            }
            ce.exps.put (expInfo.key (), expInfo.value ());
        }
        return ce;
    }

    /**
     * 获得异常信息
     * @param key
     * @return
     */
    public String getExpInfo(String key){
        return exps.get (key);
    }

    /**
     * 打印测试
     * @param args
     */
    public static void main(String[] args){
        System.out.println (BizExceptionMessage.getInstance ().exps.toString ().replace ("{", "").replace ("}", "").replaceAll (", ", "\r\n"));
    }
}
