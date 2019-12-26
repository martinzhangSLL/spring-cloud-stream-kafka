package com.rgs.template.serviceimpl.stream;

import com.rgs.core.stream.common.CommonSink;
import com.rgs.core.stream.group.GroupSink;
import com.rgs.core.stream.header.HeaderSink;
import com.rgs.core.stream.partition.PartitionSink;
import com.rgs.core.stream.transform.TransProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.SendTo;

import java.util.Map;

@EnableBinding({CommonSink.class, GroupSink.class, TransProcessor.class, PartitionSink.class, HeaderSink.class})
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

    //@ServiceActivator(inputChannel = TransProcessor.INPUT,outputChannel = TransProcessor.OUTPUT)
    @StreamListener(TransProcessor.INPUT)
    @SendTo(TransProcessor.OUTPUT)
    public Object transRecieve(Object payload){

        log.info("Consumer1: Trans Msg recieved:{}",payload);
        System.out.println(payload);

        Object obj=String.format("%s- trans",payload);
        log.info("Consumer1: Trans Msg Sent:{}",obj);
        return obj;
    }

    @StreamListener(PartitionSink.INPUT)
    public void partitionRecieve(Object payload){

        log.info("Consumer1: partition Msg recieved:{}",payload);
        System.out.println(payload);
    }

    @StreamListener(value = HeaderSink.INPUT, condition = "headers['htype']=='1'")
    public void HeaderRecieve(Object payload){

        log.info("Consumer1: Header Msg recieved with the header==1:{}",payload);
        System.out.println(payload);
    }

    @StreamListener(value = HeaderSink.INPUT, condition = "headers['htype']=='1'")
    public void HeaderRecieve1(Object payload, @Header(name="htype") String header){

        log.info("Consumer1: Header Msg recieved with the header=={}:{}",header,payload);
        System.out.println(payload);
    }

    @StreamListener(value = HeaderSink.INPUT, condition = "headers['htype']=='1'")
    public void HeaderRecieve3(Object payload, @Headers Map<String,Object> headers){

        log.info("Consumer1: Header Msg recieved with the header==1:{}",payload);
        System.out.println(payload);
    }
}
