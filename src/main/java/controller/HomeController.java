package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import api.HomeApi;

@Controller
public class HomeController implements HomeApi {

    @Autowired
    JmsTemplate jmsTemplate;

    public ResponseEntity ping() {

        jmsTemplate.convertAndSend("claimQueue", "chinese whisper");
        ResponseEntity responseEntity = new ResponseEntity("pong", new HttpHeaders(), HttpStatus.OK);

        return responseEntity;
    }
}
