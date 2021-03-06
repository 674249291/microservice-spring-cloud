package com.itmuch.cloud.controller;

import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itmuch.cloud.entity.User;

@RestController
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /* @Value("${user.userServicePath}")
    private String userServicePath;*/

    /*@GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
    return this.restTemplate.getForObject(this.userServicePath + id, User.class);
    }*/

    /**
    * 使用的是虚拟ip
    * VIP virtual ip
    * @param id
    * @return
    */
    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
    return this.restTemplate.getForObject("http://MICROSERVICE-PROVIDER-USER/simple/" + id, User.class);
    }

    /**
     * 主要测试的负载均衡的方式
     * @return
     */
    @GetMapping("/test")
    public String test(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("microservice-provider-user");
        System.out.println("11:serviceId:" + serviceInstance.getServiceId() + " host:" + serviceInstance.getHost() + " port:" + serviceInstance.getPort());
        ServiceInstance serviceInstance2 = loadBalancerClient.choose("microservice-provider-user2");
        System.out.println("22:serviceId:" + serviceInstance2.getServiceId() + " host:" + serviceInstance2.getHost() + " port:" + serviceInstance2.getPort());
        return "1";
    }
}
