package Project.example.Projekt_IO;

import io.vavr.collection.List;

public class StudentService {
    private List<Student> students = List.empty();
    int id=1;
    public List<Student> getStudents() {
        return this.students;
    }
    public Student addStudent(NewStudent stud){
        Student temp=new Student(id,stud.name,stud.number,stud.grupa);
        id++;
        students=students.push(temp);
        return temp;
    }
}
