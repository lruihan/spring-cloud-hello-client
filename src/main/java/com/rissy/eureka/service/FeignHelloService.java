package com.rissy.eureka.service;

import com.rissy.eureka.FullLogConfiguration;
import com.rissy.eureka.HelloServiceFallback;
import com.rissy.eureka.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="HELLO-SERVICE", configuration = FullLogConfiguration.class, fallback = HelloServiceFallback.class)
public interface FeignHelloService {

    @RequestMapping("/hello")
    String hello();

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    User hello(@RequestHeader("name") String name, @RequestHeader("age") int age);

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    String hello(@RequestBody User user);
}
