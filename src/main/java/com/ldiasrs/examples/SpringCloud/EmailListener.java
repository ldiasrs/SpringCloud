package com.ldiasrs.examples.SpringCloud;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(EmailChannelBinding.class)
public class EmailListener {

    @StreamListener(target = EmailChannelBinding.EMAIL)
    public void processEmailMsg(String msg) {
        System.out.println("Consuming msg:" +  msg);
    }
}