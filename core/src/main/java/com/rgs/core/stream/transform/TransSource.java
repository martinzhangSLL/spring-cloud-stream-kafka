package com.rgs.core.stream.transform;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface TransSource {

    String OUTPUT="trans_output";

    @Output(TransSource.OUTPUT)
    MessageChannel output();
}
