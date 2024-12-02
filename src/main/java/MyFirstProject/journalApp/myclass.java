package MyFirstProject.journalApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myclass {


    @GetMapping("/hello")
    public String sayhello(){
        return "hello i am omkar ,starting to learn springboot";
    }

    @Autowired
    private ExampleforBean ob;

    @GetMapping("/Ebean")
    public String call(){
        return ob.fun();
    }

}
