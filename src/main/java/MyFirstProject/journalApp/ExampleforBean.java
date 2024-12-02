package MyFirstProject.journalApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleforBean {


    public String fun(){
       return "Hello this is bean calling";
    }
}
