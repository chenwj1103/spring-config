package cn.chenwj.bean.el;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * 测试主类
 *
 * @author Chen WeiJie
 * @date 2017-12-20 11:15
 **/
public class Main {


    public static void main(String[] args) throws IOException {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ElConfig.class);
        ElConfig elConfig = applicationContext.getBean(ElConfig.class);

        elConfig.outputResource();


    }

}
