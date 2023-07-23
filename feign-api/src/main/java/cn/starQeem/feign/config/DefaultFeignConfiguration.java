package cn.starQeem.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @Date: 2023/4/12 10:41
 * @author: Qeem
 */
public class DefaultFeignConfiguration {
    @Bean
    public Logger.Level feignLogLevel(){
        return Logger.Level.BASIC; // 日志级别为BASIC
    }
}
