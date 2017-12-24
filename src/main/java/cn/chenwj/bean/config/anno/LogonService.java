package cn.chenwj.bean.config.anno;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author chen weijie
 * @date 2017-12-24 8:00 PM
 */
@Service
public class LogonService implements BeanNameAware {


    @Lazy
    @Autowired(required = false)
    private LogDao logDao;


    //Qualifier 限定多个注解中 注解的名称
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    @Override
    public void setBeanName(String name) {

    }


    public LogDao getLogDao() {
        return logDao;
    }

    public void setLogDao(LogDao logDao) {
        this.logDao = logDao;
    }


    //可以对方法使用autowired注解.
    @Autowired
    public void init(@Qualifier("userDao") UserDao userDao, LogDao logDao) {
        System.out.println("multi param inject");
        this.userDao = userDao;
        this.logDao = logDao;
    }




}
