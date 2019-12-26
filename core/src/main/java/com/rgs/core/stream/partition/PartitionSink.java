package com.rgs.core.stream.partition;

import com.rgs.core.stream.transform.TransSink;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface PartitionSink {

    String INPUT="partition_input";


    @Input(PartitionSink.INPUT)
    SubscribableChannel input();
}
