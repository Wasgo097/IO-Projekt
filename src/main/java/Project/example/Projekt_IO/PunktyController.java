package Project.example.Projekt_IO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RestController
@RequestMapping("/punkty")
public class PunktyController {
    StudentService service =new StudentService();
    public PunktyController(){}
    @RequestMapping("/index")
    String index(){
        return"<form method='POST' action='http://localhost:8080/punkty/users'>" +
                "<input type='text' name='name'/>" +
                "<br/><input type='submit' value='Submit'><br/>" +
                "</form>";
    }
    @RequestMapping(value = "/students",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<Student> getUsers(){
        return  service.getStudents().asJava();
    }
    @RequestMapping(value = "/student",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Student addUser(@RequestBody NewStudent s){return service.addStudent(s); }
}
