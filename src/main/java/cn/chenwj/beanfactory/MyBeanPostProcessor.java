package cn.chenwj.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * BeanPostProcessor的实现类  在该实现中对bean的配置属性值进行查漏补缺  也是后处理器
 *
 * @author chen weijie
 * @date 2017-12-22 12:10 AM
 */
public class MyBeanPostProcessor implements BeanPostProcessor {


    private static final String CAR_INSTANCE = "car";

    private static final int MAX_SPEED = 200;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if (CAR_INSTANCE.equals(beanName)) {
            Car car = (Car) bean;
            if (car.getColor() == null) {
                System.out.println("postProcessBeforeInitialization 将color设置为黑色.");
                car.setColor("黑色");
            }

        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if (CAR_INSTANCE.equals(beanName)) {
            Car car = (Car) bean;
            if (car.getMaxSpeed() > MAX_SPEED) {
                System.out.println("postProcessAfterInitialization 将MaxSpeed设置为 200.");
                car.setMaxSpeed(200);
            }
        }
        return bean;
    }
}
