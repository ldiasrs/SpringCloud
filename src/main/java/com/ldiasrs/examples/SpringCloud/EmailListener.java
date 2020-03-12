package com.ldiasrs.examples.SpringCloud;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(EmailBinding.class)
public class EmailListener {

    @StreamListener(target = EmailBinding.EMAIL)
    public void processEmailMsg(String msg) {
        System.out.println("Consuming msg:" +  msg);
    }
}