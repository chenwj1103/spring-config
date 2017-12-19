package cn.chenwj.aop.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 日志切面
 *
 * @author Chen WeiJie
 * @date 2017-12-19 16:07
 **/

//通过aspect注解声明一个切面，通过component使其成为spring容器管理的类
@Aspect
@Component
public class LogAspect {

    //使用pointcut声明切点
    @Pointcut("@annotation(cn.chenwj.aspectj.Action)")
    public void annotationPointCut() {

    }

    //使用after声明一个建言，并使用@pointCut定义的切点
    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();

        Action action = method.getAnnotation(Action.class);

        System.out.println("注解式拦截：" + action.name());
    }


    //execution表达式 http://blog.csdn.net/yakoo5/article/details/17001381
    @Before("execution(* cn.chenwj.aspectj.DemoMethodService.*(..))")
    public void before(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println("方法规则式拦截：" + method.getName());
    }


}
