package com.bw.feign;

import com.bw.bean.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by lenovo on 2017/7/24.eureka-server   eureka-client
 * 该项目是一个消费者,它是通过在配置文件中配置server服务端,与客户端client建立连接
 * 通过在feign的接口中加上@FeignClient("eureka-client")注解是为了读取客户端的实现方法,
 * 该注解的括号中加的是(提供注册信息的)客户端的项目名称,
 * 当然多个客户端,题目的项目名(配置文件中spring.application.name=对应的名字)是一样的,
 * 然后该接口中的方法上的mapping地址
 * 要与客户端的一致
 *
 */
@FeignClient("eureka-client")
public interface DcClient {

    @GetMapping("/get")
    public User get(@RequestParam("id") Integer id, @RequestParam("name") String name);

    @PostMapping("/post")
    public User post(@RequestBody User user);

}
