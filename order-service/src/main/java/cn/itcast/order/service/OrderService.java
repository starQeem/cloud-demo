package cn.itcast.order.service;

import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import cn.starQeem.feign.client.UserClient;
import cn.starQeem.feign.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserClient userClient;
    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // 2.远程查询User
        User user = userClient.findById(order.getUserId());
        // 3.存入order
        order.setUser(user);
        // 4.返回
        return order;
    }
//    @Resource
//    private RestTemplate restTemplate; //注入RestTemplate
//    public Order queryOrderById(Long orderId) {
//        // 1.查询订单
//        Order order = orderMapper.findById(orderId);
//        // 2.远程查询User
//        // 2.1.url地址(根据order表中的userId查询)
//        String url = "http://userservice/user/" + order.getUserId();
//        // 2.2.发起调用
//        User user = restTemplate.getForObject(url, User.class);
//        // 3.存入order
//        order.setUser(user);
//        // 4.返回
//        return order;
//    }
}
