package com.pxy.order.controller;


import com.pxy.order.dto.OrderDTO;
import com.pxy.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SendMessageController {

//    @Autowired
//    private StreamClient streamClient ;

    @Autowired
    private Sink sink;

    @Autowired
    private Source source;


    @GetMapping("/sendMessage")
    public void process(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("123456");
        source.output().send(MessageBuilder.withPayload(orderDTO).build());
    }

}
