package cn.chenwj.bean.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 事件发布类
 *
 * @author Chen WeiJie
 * @date 2017-12-20 15:06
 **/
@Component
public class DemoPublisher {

    //注入application来发布事件
    @Autowired
    ApplicationContext applicationContext;

    /**
     * 使用applicationContext的publishEvent来发布事件
     *
     * @param msg 发布的消息内容
     */
    public void publish(String msg) {

        applicationContext.publishEvent(new DemoEvent(this, msg));
    }


}
