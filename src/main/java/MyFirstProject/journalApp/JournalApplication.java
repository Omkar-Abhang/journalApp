package MyFirstProject.journalApp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class JournalApplication {

    public static void main(String[] args) {

        SpringApplication.run(JournalApplication.class, args);



    }
    @GetMapping("/hello")
    public String sayhello(){
        return "hello i am omkar ,starting to learn springboot";
    }


}