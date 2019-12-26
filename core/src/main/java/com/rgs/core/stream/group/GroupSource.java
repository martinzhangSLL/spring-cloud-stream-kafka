package com.rgs.core.stream.group;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface GroupSource {

    @Output("group_output")
    MessageChannel output();
}
