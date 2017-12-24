package cn.chenwj.bean.config.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author chen weijie
 * @date 2017-12-24 11:54 PM
 */
@Configuration
@ImportResource("classpath:config/beans3.xml")
public class LogonAppConfig {


    @Bean
    public LogonService logonService(LogDao logDao, UserDao userDao) {
        LogonService logonService = new LogonService();
        logonService.setLogDao(logDao);
        logonService.setUserDao(userDao);
        return logonService;
    }
}
