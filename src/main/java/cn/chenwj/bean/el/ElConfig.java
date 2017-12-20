package cn.chenwj.bean.el;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * 测试el配置类
 *
 * @author Chen WeiJie
 * @date 2017-12-20 10:47
 **/
@Configuration
@PropertySource("classpath:beanConfig/testBean.properties")
@ComponentScan("cn.chenwj.bean.el")
public class ElConfig {


    //注入普通字符串
    @Value("I LOVE YOU")
    private String normal;

    //注入操作系统属性
    @Value("#{systemProperties['os.name']}")
    private String osName;

    //注入表达式结果
    @Value("#{T(java.lang.Math).random()*100.0}")
    private double randomNumber;

    //注入文件资源
    @Value("classpath:beanConfig/test.txt")
    private Resource testFile;

    //注入网址资源
    @Value("https://www.baidu.com/")
    private Resource testUrl;

    //注入配置文件
    @Value("${book.name}")
    private String bookName;

    //注入配置文件 注入properties还可以从Environment中获取
    @Autowired
    private Environment environment;


    /**
     * 注入配置文件需要使用@PropertySource指定文件地址，如果使用@value注入，
     * 则需要PropertySourcesPlaceholderConfigurer的bean的配置
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigure() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource() throws IOException {

        System.out.println(normal);
        System.out.println(osName);
        System.out.println(randomNumber);
        System.out.println(IOUtils.toString(testFile.getInputStream()));
        System.out.println(IOUtils.toString(testUrl.getInputStream()));
        System.out.println(bookName);
        System.out.println(environment.getProperty("book.author"));
    }

}
