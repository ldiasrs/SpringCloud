package com.ldiasrs.examples.SpringCloud;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface EmailChannelBindingConsumer {

    String EMAIL = "emailChannel";

    @Input(EMAIL)
    SubscribableChannel emailConsumer();
}
