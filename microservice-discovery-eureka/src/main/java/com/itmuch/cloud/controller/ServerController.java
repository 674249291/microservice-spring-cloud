package com.itmuch.cloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xiong on 2017/11/30.
 */
@Controller
public class ServerController {

    @Autowired
    private EurekaClient discoveryClient;

    @GetMapping("/server")
    @ResponseBody
    public String serviceUrl(){
        InstanceInfo nextServerFromEureka = discoveryClient.getNextServerFromEureka("us-east-1", true);
        return nextServerFromEureka.getHomePageUrl();
    }
}
