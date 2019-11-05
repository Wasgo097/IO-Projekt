package Project.example.Projekt_IO;

import io.vavr.collection.List;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentServiceTest {
    @Test
    public void getEmptyList() {
        final StudentService service = new StudentService();
        List<Student> students = service.getStudents();
        assertTrue(students.isEmpty());
    }

}