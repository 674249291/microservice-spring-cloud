package com.itmuch.cloud;

import com.itmuch.conf.TestConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "microservice-provider-user", configuration = TestConfiguration.class) //设置自定义的负载规则
public class MicroserviceRibbonConsumerMovieApplication {

  /**
   * @LoadBalanced 说明已经开始使用ribiion了 ,负载均衡
   * @return
   */
  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  public static void main(String[] args) {
    SpringApplication.run(MicroserviceRibbonConsumerMovieApplication.class, args);
  }
}
