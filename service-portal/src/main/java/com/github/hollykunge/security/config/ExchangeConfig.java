package com.github.hollykunge.security.config;

import com.github.hollykunge.security.common.constant.CommonConstants;
import com.github.hollykunge.security.constants.Constants;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 消息交换机配置  可以配置多个
 * @author zhhongyu
 * @create 2019/5/9 15:40
 */
@Configuration
public class ExchangeConfig {

    /**
     *   定义fanout exchange
     *   durable="true" rabbitmq重启的时候不需要创建新的交换机
     *   direct交换器相对来说比较简单，匹配规则为：如果路由键匹配，消息就被投送到相关的队列
     *     fanout交换器中没有路由键的概念，他会把消息发送到所有绑定在此交换器上面的队列中。
     *   消息将会转发给queue参数指定的消息队列
     */
    @Bean
    public FanoutExchange fanoutExchange(){
        FanoutExchange fanoutExchange = new FanoutExchange(CommonConstants.PORTAL_EXCHANGE, true, false);
        return fanoutExchange;
    }
}