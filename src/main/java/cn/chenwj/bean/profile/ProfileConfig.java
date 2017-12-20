package cn.chenwj.bean.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * profile配置文件
 *
 * @author Chen WeiJie
 * @date 2017-12-20 12:27
 **/
@Configuration
public class ProfileConfig {


    //当profile为dev的时候初始化demoBean对象
    @Bean
    @Profile("dev")
    public DemoBean getDemoBeanFromDev() {
        return new DemoBean("get demoBean from dev");
    }

    //当profile为prod的时候初始化demoBean对象
    @Bean
    @Profile("prod")
    public DemoBean getDemoBeanFromProd() {
        return new DemoBean("get demoBean from prod");
    }


}
