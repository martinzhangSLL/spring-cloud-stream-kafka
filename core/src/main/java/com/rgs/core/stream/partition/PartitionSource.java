package com.rgs.core.stream.partition;

import com.rgs.core.stream.transform.TransSource;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface PartitionSource {

    String OUTPUT="partition_output";

    @Output(PartitionSource.OUTPUT)
    MessageChannel output();
}
