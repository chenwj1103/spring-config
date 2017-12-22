package cn.chenwj.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 * InstantiationAwareBeanPostProcessor的实现类  即为后处理器
 *
 * @author chen weijie
 * @date 2017-12-21 11:54 PM
 */
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {


    private static final String CAR_INSTANCE = "car";

    //在bean实例化前调用
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {

        if (CAR_INSTANCE.equals(beanName)) {
            System.out.println("调用 postProcessBeforeInstantiation方法 -----before");
        }

        return null;
    }

    //在实例化bean后调用
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (CAR_INSTANCE.equals(beanName)) {
            System.out.println("调用 postProcessAfterInstantiation 方法  -----after");
        }

        return true;
    }

    // 仅对bean的特定属性值进行处理
    @Override
    public PropertyValues postProcessPropertyValues(
            PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName)
            throws BeansException {

        if (CAR_INSTANCE.equals(beanName)) {
            System.out.println("调用 postProcessPropertyValues 方法  -----PropertyValues");
        }

        return pvs;
    }


}
