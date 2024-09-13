package kz.bitlab.G126FirstProject.service.impl;

import kz.bitlab.G126FirstProject.model.Student;
import kz.bitlab.G126FirstProject.repository.StudentRepository;
import kz.bitlab.G126FirstProject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository repository;
    @Override
    public List <Student> getAllStudents() {
        return  repository.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void deleteStudentById(int id) {
        repository.deleteById(id);
    }

    @Override
    public void updateStudent(Student student) {
        repository.save(student);
    }

    @Override
    public void addStudent(Student student) {
        repository.save(student);
    }
}
