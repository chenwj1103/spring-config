package cn.chenwj.bean.init;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试主类
 *
 * @author Chen WeiJie
 * @date 2017-12-20 11:59
 **/
public class Main {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        //init 方法在其实是在application容器初始化的时候调用的，并不是在context获取bean的时候调用的。
        BeanConfig beanConfig = context.getBean(BeanConfig.class);
        //而destroy方法是在application容器关闭的时候调用的。
        context.close();
    }

}
