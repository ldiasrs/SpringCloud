package com.ldiasrs.examples.SpringCloud;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(EmailChannelBindingPublisher.class)
public class ProducerController {

    private MessageChannel emailChannel;

    public ProducerController(EmailChannelBindingPublisher emailChannelBindingPublisher) {
        emailChannel = emailChannelBindingPublisher.emailPublisher();
    }

    @GetMapping("/msg/{name}")
    public void publish(@PathVariable String name) {
        String greeting = "Hello, " + name + "!";
        Message<String> msg = MessageBuilder.withPayload(greeting).build();
        this.emailChannel.send(msg);
    }
}
