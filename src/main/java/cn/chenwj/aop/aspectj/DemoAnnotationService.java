package cn.chenwj.aop.aspectj;

import org.springframework.stereotype.Service;

/**
 * 编写使用注解的被拦截类
 *
 * @author Chen WeiJie
 * @date 2017-12-19 15:59
 **/
@Service
public class DemoAnnotationService {

    @Action(name = "注解式拦截的add操作")
    public void add() {
    }

}
