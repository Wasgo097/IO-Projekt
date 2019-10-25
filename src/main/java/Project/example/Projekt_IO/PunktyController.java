package Project.example.Projekt_IO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
@RestController
@RequestMapping("/punkty")
public class PunktyController {
    public static CopyOnWriteArrayList<String> list;
    public PunktyController(){
        list=new CopyOnWriteArrayList<>();
        list.add("us1");
        list.add("us2");
    }
    @RequestMapping("/index")
    String index(){
        return"<form method='POST' action='http://localhost:8080/punkty/users'>" +
                "<input type='text' name='name'/>" +
                "<br/><input type='submit' value='Submit'>" +
                "</form>";
    }
    @RequestMapping(value = "/users",method={ RequestMethod.GET})
    ArrayList<String> getUsers(){
        return new ArrayList<>(list);
    }
    @RequestMapping(value = "/users",method = {RequestMethod.POST})
    int addUser(@RequestBody String name){
        list.add(name);
        return list.size();
    }
}
