package Project.example.Projekt_IO;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/punkty")
public class PunktyController {
    private final StudentService service;
    public PunktyController(StudentService service) {
        this.service = service;
    }
    @RequestMapping(value = "/students",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<Student> getUsers(){
        return  service.getStudents().asJava();
    }
    @RequestMapping(value = "/student",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Student addUser(@RequestBody NewStudent s){return service.addStudent(s); }
    @RequestMapping(value = "/students/{id}/number/{number}",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Student setNumber(@PathVariable("id") long id, @PathVariable("number") String number){
        return this.service.changeNumber(id, number).orElseThrow(
                () -> new IllegalArgumentException("Student o id: " + id + " does not exist") );
    }
    @RequestMapping(value = "/students/{id}/scores")
    public int addScore(@PathVariable("id") long id,@RequestBody Score score) {
        return this.service.addScore(id, score)
                .orElseThrow(
                        ()->new IllegalArgumentException("Student id: " + id + "does not exist"));
    }
}
