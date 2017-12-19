package cn.chenwj.aop.aspectj;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 配置类
 *
 * @author Chen WeiJie
 * @date 2017-12-19 16:24
 **/
@Configuration
@ComponentScan("cn.chenwj.aop.aspectj")
@EnableAspectJAutoProxy
public class AopConfig {


}
