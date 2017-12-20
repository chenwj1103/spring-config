package cn.chenwj.bean.init;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * bean初始化和销毁的配置类
 *
 * @author Chen WeiJie
 * @date 2017-12-20 11:55
 **/
@Configuration
@ComponentScan("cn.chenwj.bean.init")
public class BeanConfig {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    BeanService getBeanService() {
        return new BeanService();
    }

}
