package com.rissy.eureka;

import com.rissy.eureka.service.FeignHelloService;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceFallback implements FeignHelloService {

    @Override
    public String hello() {
        return "error";
    }

    @Override
    public String hello(String name) {
        return "error1";
    }

    @Override
    public User hello(String name, int age) {
        return new User("error2", 0);
    }

    @Override
    public String hello(User user) {
        return "error3";
    }

}
