package com.pxy.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;


public interface StreamClient {
//input 和 output 不能是同一个
//参考https://my.oschina.net/u/2350117/blog/1633577
//和 https://blog.csdn.net/qq_26545305/article/details/80381146

    String INPUT = "myMessage";

    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    @Output(Source.OUTPUT)
    MessageChannel output();


}
