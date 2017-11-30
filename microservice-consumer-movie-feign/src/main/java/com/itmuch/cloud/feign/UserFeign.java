package com.itmuch.cloud.feign;

import com.itmuch.cloud.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 创建feigen客户端
 * Created by xiong on 2017/11/30.
 */
@FeignClient("microservice-provider-user")
public interface UserFeign {

    @RequestMapping(method = RequestMethod.GET, value = "/simple/{id}")
    public User findById(@PathVariable("id") Long id);

    @RequestMapping(method = RequestMethod.POST , value = "/user")
    public User postUser(@RequestBody User user);
}
