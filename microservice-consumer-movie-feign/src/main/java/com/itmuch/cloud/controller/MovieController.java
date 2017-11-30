package com.itmuch.cloud.controller;

import com.itmuch.cloud.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.entity.User;

@RestController
public class MovieController {

  @Autowired
  private UserFeign userFeign;

  @GetMapping("/movie/{id}")
  public User findById(@PathVariable Long id) {
    return userFeign.findById(id);
  }

  @PostMapping("/showUser")
  public User showUser(User user){
    return userFeign.postUser(user);
  }
}
