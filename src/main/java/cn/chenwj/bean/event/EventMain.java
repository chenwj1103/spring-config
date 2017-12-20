package cn.chenwj.bean.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试主类
 *
 * @author Chen WeiJie
 * @date 2017-12-20 15:12
 **/
public class EventMain {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(EventConfig.class);
        DemoPublisher demoPublisher = applicationContext.getBean(DemoPublisher.class);
        demoPublisher.publish("hello application event");
        applicationContext.close();
    }

}
