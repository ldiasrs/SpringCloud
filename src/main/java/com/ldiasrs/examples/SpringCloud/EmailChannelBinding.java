package com.ldiasrs.examples.SpringCloud;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface EmailChannelBinding {

    String EMAIL = "emailChannel";

    @Output(EMAIL)
    MessageChannel emailPublisher();

    @Input(EMAIL)
    SubscribableChannel emailConsumer();
}
