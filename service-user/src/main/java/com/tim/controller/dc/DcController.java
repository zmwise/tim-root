package com.tim.controller.dc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

@RestController
public class DcController {

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/hello")
    public String hello(String name){
        return "Hello " + name;
    }

    @GetMapping("/dc")
    public String dc(){
        String services = "Services: "+ discoveryClient.getServices();
        System.out.println(services);
        return services;
    }

    @GetMapping("/getUser")
    public String getUser(Long id){
        System.out.println("根据ID获取用户信息");
        return "根据ID获取用户信息(ID="+id+")";
    }
}
