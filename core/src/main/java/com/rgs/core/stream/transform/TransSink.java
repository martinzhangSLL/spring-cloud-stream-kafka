package com.rgs.core.stream.transform;

import com.rgs.core.stream.group.GroupSink;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface TransSink {

    String INPUT="trans_input";


    @Input(TransSink.INPUT)
    SubscribableChannel input();
}
