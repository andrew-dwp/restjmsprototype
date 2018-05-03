package jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(id = "claimListener", destination = "claimQueue", containerFactory = "myFactory")
    public void jimbbp(String newMessage) {
        System.out.println("Received <"+ newMessage + ">");
    }
}
