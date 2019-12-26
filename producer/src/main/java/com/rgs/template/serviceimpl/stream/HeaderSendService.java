package com.rgs.template.serviceimpl.stream;

import com.rgs.core.stream.header.HeaderSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(HeaderSource.class)
public class HeaderSendService {

    @Autowired
    HeaderSource headerSource;

    public void sendMsg(String msg,String header){

        headerSource.output().send(MessageBuilder.withPayload(msg).setHeader("htype",header).build());
    }
}
