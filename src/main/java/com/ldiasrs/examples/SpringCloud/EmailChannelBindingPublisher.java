package com.ldiasrs.examples.SpringCloud;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface EmailChannelBindingPublisher {

    String EMAIL = "emailChannel";

    String UNDELIVERABLE = "undeliverableChannel";

    @Output(EMAIL)
    MessageChannel emailPublisher();

    @Output(UNDELIVERABLE)
    MessageChannel undeliverablePublisher();

}
