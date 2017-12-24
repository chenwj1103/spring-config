package cn.chenwj.bean.config.anno;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author chen weijie
 * @date 2017-12-24 8:16 PM
 */
@Component
@Order(value = 2)
public class TwoPlugin implements Plugin{

}
