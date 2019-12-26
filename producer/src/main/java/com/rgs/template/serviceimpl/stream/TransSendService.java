package com.rgs.template.serviceimpl.stream;

import com.rgs.core.stream.transform.TransSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(TransSource.class)
public class TransSendService {

    @Autowired
    private TransSource transSource;

    public void sendMsg(String msg){

        transSource.output().send(MessageBuilder.withPayload(msg).build());
    }
}
