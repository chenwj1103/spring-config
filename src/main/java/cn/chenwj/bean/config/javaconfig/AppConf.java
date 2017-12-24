package cn.chenwj.bean.config.javaconfig;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chen weijie
 * @date 2017-12-24 10:58 PM
 */
@Configuration
public class AppConf {


    @Bean
    public UserDao userDao() {
        return new UserDao();
    }

    @Bean
    public LogDao logDao() {
        return new LogDao();
    }

    @Bean
    public LogonService logonService() {
        LogonService logonService = new LogonService();
        logonService.setLogDao(logDao());
        logonService.setUserDao(userDao());
        return logonService;
    }



}
