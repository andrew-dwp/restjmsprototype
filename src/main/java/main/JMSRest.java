package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import config.SwaggerConfig;
import controller.HomeController;
import jms.Receiver;

@SpringBootApplication
@ComponentScan(basePackageClasses = {HomeController.class, SwaggerConfig.class, Receiver.class})
public class JMSRest {

    public static void main(String[] args) {
        SpringApplication.run(JMSRest.class, args);
    }
}
