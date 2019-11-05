package Project.example.Projekt_IO;

import io.vavr.collection.List;

public class StudentService {

    private List<Student> students = List.empty();

    List<Student> getStudents() {
        //1 test
        //return List.empty();
        //3 test
        return this.students;
    }

    public boolean addStudent(NewStudnet stud){
//        if(students!=null){
//            students.append(new Student(id,name,number,grupa));
//            return true;
//        }
//        else return false;
        throw new UnsupportedOperationException();
    }
}
