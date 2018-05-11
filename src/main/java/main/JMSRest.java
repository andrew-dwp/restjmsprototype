package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import config.SwaggerConfig;
import controller.HomeController;
import jms.ReceiverToMe;

@SpringBootApplication
@ComponentScan(basePackageClasses = {HomeController.class, SwaggerConfig.class, ReceiverToMe.class})
public class JMSRest {

    public static void main(String[] args) {
        SpringApplication.run(JMSRest.class, args);
    }
}
