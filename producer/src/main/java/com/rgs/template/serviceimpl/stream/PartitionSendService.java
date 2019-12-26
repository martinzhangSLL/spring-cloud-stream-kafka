package com.rgs.template.serviceimpl.stream;

import com.rgs.core.stream.partition.PartitionSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(PartitionSource.class)
public class PartitionSendService {

    @Autowired
    PartitionSource partitionSource;

    public void sendMsg(String msg){

        partitionSource.output().send(MessageBuilder.withPayload(msg).build());
    }
}
