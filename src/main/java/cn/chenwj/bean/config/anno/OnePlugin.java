package cn.chenwj.bean.config.anno;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author chen weijie
 * @date 2017-12-24 8:15 PM
 */
@Component
@Order(value = 1)
public class OnePlugin implements Plugin {

}
