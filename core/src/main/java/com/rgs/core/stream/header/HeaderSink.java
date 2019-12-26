package com.rgs.core.stream.header;

import com.rgs.core.stream.partition.PartitionSink;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface HeaderSink {

    String INPUT="header_input";


    @Input(HeaderSink.INPUT)
    SubscribableChannel input();
}
