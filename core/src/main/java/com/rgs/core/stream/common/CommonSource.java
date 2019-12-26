package com.rgs.core.stream.common;


import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CommonSource {

    @Output("common_output")
    MessageChannel output();

}
