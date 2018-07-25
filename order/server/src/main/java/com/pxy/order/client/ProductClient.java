package com.pxy.order.client;

import com.pxy.order.dataobject.ProductInfo;
import com.pxy.order.dto.CartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "product")
public interface ProductClient {

    //调用product服务的方法 用GetMapping与服务端对应
    @GetMapping("/msg")
    String productMsg();

    //@PostMapping("/listForOrder")
    @PostMapping("/product/listForOrder")
    List<ProductInfo> listForOrder(List<String> productIdList);

    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<CartDTO> cartDTOList);

}
