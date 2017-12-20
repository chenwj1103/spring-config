package cn.chenwj.bean.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 事件监听器
 *
 * @author Chen WeiJie
 * @date 2017-12-20 15:01
 **/
@Component
public class DemoListener implements ApplicationListener<DemoEvent> { //指定监听事件类型


    /**
     * 监听事件的方法 对消息进行接收处理
     *
     * @param event 被监视事件
     */
    @Override
    public void onApplicationEvent(DemoEvent event) {
        String msg = event.getMsg();
        System.out.println("接收到event事件发过来的消息msg：" + msg);
    }
}
