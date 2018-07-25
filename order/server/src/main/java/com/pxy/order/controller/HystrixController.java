package com.pxy.order.controller;



import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
//all config
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

//    //config of time out
//    @HystrixCommand(commandProperties ={@HystrixProperty(
//            name="execution.isolation.thread.timeoutInMilliseconds",
//            value = "3000")})

//    @HystrixCommand(commandProperties ={
//            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),
//            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),
//            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
//            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60"),
//
//    })
    @HystrixCommand
    @GetMapping("/getProductInfoList")
    public String getProductInfoList(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http:127.0.0.1:8090/product/listForOrder",
                Arrays.asList("000000001"),
                String.class);
        //throw new RuntimeException("error sent");
    }

    private String fallback(){
        return "太拥挤了 请稍后再试";
    }

    private String defaultFallback(){
        return "默认提示：太拥挤了 请稍后再试";
    }
}
