package com.bw.controller;

import com.bw.bean.User;
import com.bw.feign.DcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lenovo on 2017/7/21.
 */
@RestController
public class DcController {
    @Autowired
    private DcClient dcClient;

    @Autowired
    DiscoveryClient discoveryClient;
    public String dc() throws InterruptedException {

        Thread.sleep(3000L);
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
 }



    //@RequestMapping("consumer")
    @GetMapping("/getconsumer")
    public User getdc(@RequestParam("id") Integer id,@RequestParam("name") String name){

        return  dcClient.get(id,name);
    }

    @PostMapping("/postconsumer")
    public User postdc(@RequestParam Integer id,@RequestParam String name){

        return  dcClient.get(id,name);
    }



}
