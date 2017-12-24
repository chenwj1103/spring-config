package cn.chenwj.bean.config.anno;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 * @author chen weijie
 * @date 2017-12-24 7:58 PM
 */
@Repository
@Lazy //需要 引用该logDao对象的地方也使用lazy注解才可以时lazy加载生效.
public class LogDao implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("LogDa...");
    }

    public void saveLog() {
    }

}
