package com.rgs.template.serviceimpl.stream;

import com.rgs.core.stream.common.CommonSource;
import com.rgs.core.stream.group.GroupSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(GroupSource.class)
public class GroupSendService {

    @Autowired
    private GroupSource groupSource;

    public void sendMsg(String msg){

        groupSource.output().send(MessageBuilder.withPayload(msg).build());
    }
}
