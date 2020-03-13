package com.ldiasrs.examples.SpringCloud;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@EnableBinding({EmailChannelBindingConsumer.class, EmailChannelBindingPublisher.class})
@Component
public class EmailListener {

    private static final String X_RETRIES_HEADER = "x-retries";

    private MessageChannel emailChannel;
    private MessageChannel undeliverablePublisher;

    @Autowired
    public EmailListener(EmailChannelBindingConsumer consumer, EmailChannelBindingPublisher publisher) {
        this.emailChannel = consumer.emailConsumer();
        this.undeliverablePublisher = publisher.undeliverablePublisher();
    }

    @StreamListener(target = EmailChannelBindingConsumer.EMAIL)
    public void processEmailMsg(Message msg) {
        System.out.println("Consuming msg:" +  msg);
        AtomicInteger retries = msg.getHeaders().get("deliveryAttempt", AtomicInteger.class);
        if (retries!=null && retries.intValue() >= 3) {
            System.out.println("Retries exhausted for " + msg);
            undeliverablePublisher.send(MessageBuilder.fromMessage(msg)
                    .build());
        } else {
            System.out.println("Another retry for " + msg);
            if (true)
                throw new RuntimeException("Nao deve aparecer no POSMAN");
        }
    }
}