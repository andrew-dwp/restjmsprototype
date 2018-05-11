package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import api.HomeApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeController implements HomeApi {

    @Autowired
    JmsTemplate jmsTemplate;

    public ResponseEntity toYou() {

        final String url = "http://localhost:8081/tome";
        jmsTemplate.convertAndSend("toYou", "to you");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RestTemplate toMeCall = new RestTemplate();
        String result = toMeCall.getForObject(url, String.class);
        ResponseEntity responseEntity = new ResponseEntity("to you", new HttpHeaders(), HttpStatus.OK);
        return responseEntity;
    }

    public ResponseEntity toMe() {

        final String url = "http://localhost:8081/toyou";
        jmsTemplate.convertAndSend("toMe", "to me");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RestTemplate toYouCall = new RestTemplate();
        String result = toYouCall.getForObject(url, String.class);
        ResponseEntity responseEntity = new ResponseEntity("to me", new HttpHeaders(), HttpStatus.OK);

        return responseEntity;
    }
}
