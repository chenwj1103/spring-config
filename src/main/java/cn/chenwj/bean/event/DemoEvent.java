package cn.chenwj.bean.event;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件
 *
 * @author Chen WeiJie
 * @date 2017-12-20 14:57
 **/
public class DemoEvent extends ApplicationEvent {


    //spring事件遵循以下流程
    //1.自定义事件 继承applicationEvent
    //2.定义事件监听器 实现applicationListener
    //3.使用容器发布事件

    private String msg;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never {@code null})
     */
    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
