package cn.chenwj.bean.config.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author chen weijie
 * @date 2017-12-24 11:05 PM
 */
@Configuration
public class DaoConfig {

    @Bean
    public UserDao userDao() {
        return new UserDao();
    }

    @Bean
    public LogDao logDao() {
        return new LogDao();
    }

}
