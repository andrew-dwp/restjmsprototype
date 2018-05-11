package jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ReceiverToMe {
    @Autowired
    JmsTemplate jmsTemplate;

    @JmsListener(id = "toMeListener", destination = "toMe", containerFactory = "myFactory")
    public void toMe(String newMessage) throws InterruptedException {
        System.out.println("Received <"+ newMessage + ">");
    }
}
