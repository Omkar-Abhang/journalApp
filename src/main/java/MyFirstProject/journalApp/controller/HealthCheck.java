package MyFirstProject.journalApp.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@SpringBootApplication
public class HealthCheck {

    @GetMapping("/health")
    public String healthCheck(){
        return "okay";
    }
}
