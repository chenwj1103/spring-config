package cn.chenwj.bean.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试主类
 *
 * @author Chen WeiJie
 * @date 2017-12-20 12:31
 **/
public class ProfileMain {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //配置环境的类型
        applicationContext.getEnvironment().setActiveProfiles("dev");
        applicationContext.register(ProfileConfig.class);
        applicationContext.refresh();
        DemoBean demoBean = applicationContext.getBean(DemoBean.class);
        System.out.println(demoBean.getContent());
        applicationContext.close();

    }

}
