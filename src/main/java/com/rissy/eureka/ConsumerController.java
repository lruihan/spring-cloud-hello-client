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

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        //return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
        return helloService.helloService();
    }

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String feignHelloConsumer() {
        return feignHelloService.hello();
    }

    @RequestMapping(value = "/feign-consumer1", method = RequestMethod.GET)
    public String feignHelloConsumer1() {
        return feignHelloService.hello1("Rissy");
    }

    @RequestMapping(value = "/feign-consumer2", method = RequestMethod.GET)
    public String feignHelloConsumer2() {
        return feignHelloService.hello2("Rissy", 28).toString();
    }

    @RequestMapping(value = "/feign-consumer3", method = RequestMethod.POST)
    public String feignHelloConsumer3() {
        return feignHelloService.hello3(new User("Rissy", 28)).toString();
    }

}
