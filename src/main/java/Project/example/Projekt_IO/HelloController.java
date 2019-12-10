package Project.example.Projekt_IO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
@RestController
public class HelloController {
    //Returns 'hello <current time>'
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String hello(){
        return "hello " + LocalDateTime.now();
    }
}