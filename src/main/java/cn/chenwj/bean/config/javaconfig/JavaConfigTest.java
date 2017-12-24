package cn.chenwj.bean.config.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * javaConfig 如何引入多个配置文件
 *
 * @author chen weijie
 * @date 2017-12-24 11:15 PM
 */
public class JavaConfigTest {

    public static void main(String[] args) {



//1.通过构造函数加载配置类
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConf.class);
//        LogonService logonService = applicationContext.getBean(LogonService.class);
//
//        logonService.printHelllo();

//2.通过编码方式注册配置类
//		 AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//		 ctx.register(DaoConfig.class);
//		 ctx.register(ServiceConfig.class);
        //使用refresh刷新容器,使得注册生效
//		 ctx.refresh();

//3.通过XML组装@Configuration配置类所提供的配置信息
//		 ApplicationContext ctx = new ClassPathXmlApplicationContext("com/smart/conf/beans2.xml");

//4.通过@Configuration组装XML配置所提供的配置信息
		 ApplicationContext ctx = new AnnotationConfigApplicationContext(LogonAppConfig.class);

        //5.@Configuration的配置类相互引用
//        ApplicationContext ctx2 = new AnnotationConfigApplicationContext(ServiceConfig.class);

        LogonService logonService2 = ctx.getBean(LogonService.class);
        System.out.println((logonService2.getLogDao() != null));
        logonService2.printHelllo();
    }


}
