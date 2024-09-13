package kz.bitlab.G126FirstProject.service;


import kz.bitlab.G126FirstProject.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

     List<Student> getAllStudents();

     Student getStudentById(int id);

     void deleteStudentById(int id);

     void updateStudent(Student student);

     void addStudent(Student student);
}
