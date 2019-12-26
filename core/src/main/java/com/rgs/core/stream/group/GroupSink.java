package com.rgs.core.stream.group;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface GroupSink {

    String INPUT="group_input";


    @Input(GroupSink.INPUT)
    SubscribableChannel input();
}
