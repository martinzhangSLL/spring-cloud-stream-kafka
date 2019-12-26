package com.rgs.core.stream.common;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface CommonSink {

    String INPUT="common_input";


    @Input(CommonSink.INPUT)
    SubscribableChannel input();

}
