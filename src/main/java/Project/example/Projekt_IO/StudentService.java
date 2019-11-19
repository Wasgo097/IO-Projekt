package Project.example.Projekt_IO;
import Project.example.Projekt_IO.db.StudentRepository;
import Project.example.Projekt_IO.db.StudentRow;
import io.vavr.collection.List;
import org.springframework.stereotype.Service;
import java.util.function.Function;
@Service
public class StudentService {
    private final StudentRepository repository;
    public List<Student> getStudents() {
        return List.ofAll(this.repository.findAll()).map(getStudentRowStudentFunction());
    }
    private Function<StudentRow, Student> getStudentRowStudentFunction() {
        return dbObj->
                new Student(
                        dbObj.getId(),
                        dbObj.getName(),
                        dbObj.getNumber(),
                        dbObj.getGroup());
    }
    public Student addStudent(final NewStudent stud){
        StudentRow created=this.repository.save(new StudentRow(stud.name,stud.number,stud.grupa));
        return getStudentRowStudentFunction().apply(created);
    }
    public StudentService(StudentRepository repository) {
        this.repository=repository;
    }
}
