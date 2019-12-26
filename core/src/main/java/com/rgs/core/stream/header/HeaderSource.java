package com.rgs.core.stream.header;

import com.rgs.core.stream.partition.PartitionSource;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface HeaderSource {

    String OUTPUT="header_output";

    @Output(HeaderSource.OUTPUT)
    MessageChannel output();
}
