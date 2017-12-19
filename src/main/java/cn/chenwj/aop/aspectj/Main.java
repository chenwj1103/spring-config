package cn.chenwj.aop.aspectj;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 主类
 *
 * @author Chen WeiJie
 * @date 2017-12-19 16:26
 **/
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);

        DemoAnnotationService demoAnnotationService = applicationContext.getBean(DemoAnnotationService.class);
        demoAnnotationService.add();

        DemoMethodService demoMethodService = applicationContext.getBean(DemoMethodService.class);
        demoMethodService.add();

        applicationContext.close();


    }

}
