package com.rgs.template.serviceimpl.stream;

import com.rgs.core.stream.common.CommonSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(CommonSource.class)
public class CommonSendService {

    @Autowired
    private CommonSource commonSource;

    public void SendMsg(String msg){

        commonSource.output().send(MessageBuilder.withPayload(msg).build());
    }
}
