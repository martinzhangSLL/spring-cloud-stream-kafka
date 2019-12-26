package com.rgs.template.serviceimpl.stream;

import com.rgs.core.stream.common.CommonSink;
import com.rgs.core.stream.group.GroupSink;
import com.rgs.core.stream.header.HeaderSink;
import com.rgs.core.stream.partition.PartitionSink;
import com.rgs.core.stream.transform.TransProcessor;
import com.rgs.core.stream.transform.TransSink;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.ServiceActivator;

@EnableBinding({CommonSink.class, GroupSink.class, TransSink.class, PartitionSink.class, HeaderSink.class})
@Slf4j
public class StreamRecieveService2 {

    @StreamListener(CommonSink.INPUT)
    public void recieve(Object payload){

        log.info("Consumer2: Msg recieved:{}",payload);
        System.out.println(payload);
    }

    @StreamListener(GroupSink.INPUT)
    public void groupRecieve(Object payload){

        log.info("Consumer2: Group Msg recieved:{}",payload);
        System.out.println(payload);
    }

    @StreamListener(TransSink.INPUT)
    public void transRecieve(Object payload){

        log.info("Consumer2: Trans Msg recieved:{}",payload);
        System.out.println(payload);
    }

    @StreamListener(PartitionSink.INPUT)
    public void partitionRecieve(Object payload){

        log.info("Consumer2: partition Msg recieved:{}",payload);
        System.out.println(payload);
    }

    @StreamListener(value = HeaderSink.INPUT, condition = "headers['htype']=='2'")
    public void HeaderRecieve(Object payload){

        log.info("Consumer2: Header Msg recieved with the header==2:{}",payload);
        System.out.println(payload);
    }
}
