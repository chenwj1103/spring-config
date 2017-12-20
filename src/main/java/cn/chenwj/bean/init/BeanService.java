package cn.chenwj.bean.init;

/**
 * bean初始化和销毁的对象
 *
 * @author Chen WeiJie
 * @date 2017-12-20 11:52
 **/
public class BeanService {

    public void init() {
        System.out.println("bean init!");
    }

    public void destroy() {
        System.out.println("bean destroy!");
    }

}
