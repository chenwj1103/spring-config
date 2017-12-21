package cn.chenwj.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * beanFactory的生命周期  实现管理bean生命周期的接口
 *
 * @author chen weijie
 * @date 2017-12-21 11:30 PM
 */
public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private String brand;

    private String color;

    private int maxSpeed;


    private BeanFactory beanFactory;

    private String beanName;

    public Car() {
        System.out.println("调用car的构造函数!");
    }

    public Car(String brand, String color, int maxSpeed) {

        System.out.println("调用car的多参数构造函数!");
        this.brand = brand;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public void setBrand(String brand) {
        System.out.println("调用setBrand()设置属性");
        this.brand = brand;
    }

    public void introduce() {
        System.out.println("Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", beanFactory=" + beanFactory +
                ", beanName='" + beanName + '\'' +
                '}');
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryAware的setBeanFactory()方法");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("调用BeanNameAware的setBeanName()方法");
        this.beanName = s;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用InitializingBean的afterPropertiesSet()方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("调用DisposableBean的destroy()方法");
    }

    public void myInit() {
        System.out.println("调用init-method指定的myInit(),将maxSpeed设置为240");
        this.maxSpeed = 240;

    }

    public void myDestroy() {
        System.out.println("调用init-method指定的myDestroy()");
    }


    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
