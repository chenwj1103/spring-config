package cn.chenwj.aop.aspectj;

import java.lang.annotation.*;

/**
 * 拦截规则注解
 *
 * @author Chen WeiJie
 * @date 2017-12-19 15:56
 **/

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {

    String name();
}
