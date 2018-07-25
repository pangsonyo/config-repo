package com.pxy.order.controller;

import com.pxy.order.client.ProductClient;
import com.pxy.order.dataobject.ProductInfo;
import com.pxy.order.dto.CartDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class ClientController {

    //  @Autowired
    //  private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {

//      String response = restTemplate.getForObject("http://PRODUCT/msg",String.class);

        String response = productClient.productMsg();
        //log.info("response={}", response);

        return response;
    }

    @GetMapping("/getProductList")
    public String getProductList() {
        List<ProductInfo> productInfoList = productClient.listForOrder(Arrays.asList("000000003"));
     //   log.info("这里调用商品服务", productInfoList);
        return "OK";
    }

    @GetMapping("/productDecreaseStock")
    public String productDecreaseStock() {
        productClient.decreaseStock(Arrays.asList(new CartDTO("000000003", 10)));
        return "stock has decreased";
    }


}
