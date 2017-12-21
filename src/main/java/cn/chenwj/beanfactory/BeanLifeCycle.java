package cn.chenwj.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 容器配置文件
 *
 * @author chen weijie
 * @date 2017-12-22 12:29 AM
 */
public class BeanLifeCycle {

    private static void LifeCycleInBeanFactory() {

        //下面两句装载配置文件并启动容器
        Resource res = new ClassPathResource("beanFactory/beans.xml");

        BeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((DefaultListableBeanFactory) beanFactory);

        reader.loadBeanDefinitions(res);

        //向容器中注册MyBeanPostProcessor
        ((ConfigurableBeanFactory) beanFactory).addBeanPostProcessor(new MyBeanPostProcessor());

        //向容器中注册 MyInstantiationAwareBeanPostProcessor
        ((ConfigurableBeanFactory) beanFactory).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());


        //第一次从容器中获取car，将触发容器实例化该Bean，这将引发Bean生命周期方法的调用。
        Car car1 = (Car) beanFactory.getBean("car");

        car1.introduce();
        car1.setColor("红色");

        //第二次从容器中获取car，直接从缓存池中获取
        Car car2 = (Car) beanFactory.getBean("car");


        System.out.println("查看car1和car2是否指向同一个引用:" + (car1 == car2));

        //关闭容器
        ((DefaultListableBeanFactory) beanFactory).destroySingletons();
    }

    public static void main(String[] args) {

        LifeCycleInBeanFactory();
    }


}
