package cn.chenwj.bean.config.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author chen weijie
 * @date 2017-12-24 11:10 PM
 */
@Configuration
@Import(DaoConfig.class)
public class ServiceConfig {


    //使用@import注解注入配置文件代替@Autowired注解

//    @Autowired
//    private DaoConfig daoConfig;

    @Bean
    public LogonService logonService() {
        LogonService logonService = new LogonService();
//        logonService.setUserDao(daoConfig.userDao());
//        logonService.setLogDao(daoConfig.logDao());
        return logonService;
    }


}
