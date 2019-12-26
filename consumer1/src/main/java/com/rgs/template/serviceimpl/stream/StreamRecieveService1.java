package com.rgs.template.serviceimpl.stream;

import com.rgs.core.stream.common.CommonSink;
import com.rgs.core.stream.group.GroupSink;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;

@EnableBinding({CommonSink.class, GroupSink.class})
@Slf4j
public class StreamRecieveService1 {

    @StreamListener(CommonSink.INPUT)
    public void recieve(Object payload){

        log.info("Consumer1: Msg recieved:{}",payload);
        System.out.println(payload);
    }

    @StreamListener(GroupSink.INPUT)
    public void groupRecieve(Object payload){

        log.info("Consumer1: Group Msg recieved:{}",payload);
        System.out.println(payload);
    }
}
