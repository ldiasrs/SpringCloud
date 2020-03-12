package com.ldiasrs.examples.SpringCloud;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface EmailBinding {

    String EMAIL = "emailChannel";

    @Output(EMAIL)
    MessageChannel greetingOut();

    @Input(EMAIL)
    SubscribableChannel greetingIn();
}
