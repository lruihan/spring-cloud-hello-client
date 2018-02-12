package com.rissy.eureka.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.rissy.eureka.ConsumerController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    private Logger logger = LoggerFactory.getLogger(HelloService.class);

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService() {
        long start = System.currentTimeMillis();
        String result = restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
        long end = System.currentTimeMillis();
        logger.info("Spend time: " + (end - start));
        return result;
    }

    public String helloFallback() {
        return "error";
    }
}