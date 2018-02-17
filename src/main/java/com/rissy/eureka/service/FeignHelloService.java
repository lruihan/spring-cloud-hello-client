package com.rissy.eureka.service;

import com.rissy.eureka.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("HELLO-SERVICE")
public interface FeignHelloService {

    @RequestMapping("/hello")
    String hello();

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    String hello1(@RequestParam("name") String name);

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    User hello2(@RequestHeader("name") String name, @RequestHeader("age") int age);

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    String hello3(@RequestBody User user);
}
