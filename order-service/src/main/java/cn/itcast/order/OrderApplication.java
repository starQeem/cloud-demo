package cn.itcast.order;

import cn.starQeem.feign.client.UserClient;
import cn.starQeem.feign.config.DefaultFeignConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(clients = {UserClient.class},defaultConfiguration = DefaultFeignConfiguration.class) //全局生效
//@FeignClient(value = "userservice", configuration = DefaultFeignConfiguration .class)  //局部生效
@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
    //注册RestTemplate
//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }
    //修改负载均衡规则为随机(全局)
//    @Bean
//    public IRule randomRule(){
//        return new RandomRule();
//    }


}