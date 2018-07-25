package com.pxy.order.message;

import com.fasterxml.jackson.core.type.TypeReference;
import com.peng.product.common.ProductInfoOutput;
import com.pxy.order.utils.JsonUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Log4j2
public class ProductInfoReceiver {

    //监听购物车List
    @RabbitListener(queuesToDeclare =@Queue("productInfo"))
    public void process(String message){
        List<ProductInfoOutput> outputList = (List<ProductInfoOutput>) JsonUtil
                .fromJson(message,
                        new TypeReference<List<ProductInfoOutput>>(){});
        log.info("接收"+outputList);

        //存储到redis

    }


}
