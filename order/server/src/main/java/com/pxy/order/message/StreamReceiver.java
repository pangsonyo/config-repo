package com.pxy.order.message;

import com.pxy.order.dto.OrderDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.stereotype.Component;

@Component
@EnableBinding({Sink.class,Source.class})
@Log4j2
public class StreamReceiver {


    /*@StreamListener(Sink.INPUT)
    public void process(OrderDTO message){
        System.out.println(message);
    }*/

}
