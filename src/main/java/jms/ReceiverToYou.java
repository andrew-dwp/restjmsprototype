package jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ReceiverToYou {
    @Autowired
    JmsTemplate jmsTemplate;

    @JmsListener(id = "toYouListener", destination = "toYou", containerFactory = "myFactory")
    public void toYou(String newMessage) throws InterruptedException {
        System.out.println("Received <"+ newMessage + ">");
    }
}
