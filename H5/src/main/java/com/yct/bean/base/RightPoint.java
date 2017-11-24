package com.yct.bean.base;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解，用于标注权限验证点
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RightPoint {

    /**
     * 不检查权限，只检查登录状态，默认否
     * @return
     */
    boolean nocheck( ) default false;

    /**
     * 权限路径不是默认路径时，需指定
     * @return
     */
    String path( ) default "";

}
