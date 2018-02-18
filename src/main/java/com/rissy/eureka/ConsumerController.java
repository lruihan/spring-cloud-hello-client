package com.rissy.eureka;

import com.rissy.eureka.service.FeignHelloService;
import com.rissy.eureka.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService;

    @Autowired
    FeignHelloService feignHelloService;

//    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
//    public String helloConsumer() {
//        //return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
//        return helloService.helloService();
//    }

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String feignHelloConsumer() {
        return feignHelloService.hello();
    }
    @RequestMapping(value = "/feign-consumer2", method = RequestMethod.GET)
    public String feignHelloConsumer2() {
        StringBuilder builder = new StringBuilder();
        builder.append(feignHelloService.hello()).append("\n");
        builder.append(feignHelloService.hello("Rissy")).append("\n");
        builder.append(feignHelloService.hello("Rissy2", 28)).append("\n");
        builder.append(feignHelloService.hello(new User("Test", 18))).append("\n");
        return builder.toString();
    }

}
