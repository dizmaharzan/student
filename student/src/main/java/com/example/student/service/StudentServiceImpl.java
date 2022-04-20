package com.example.student.service;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;
import com.example.student.repository.StudentRepository;
import com.example.student.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(int id) {
        Student student =studentRepository.findById(id).get();
        studentRepository.delete(student);


    }

    @Override
    public Student getStudent(int id) {
        return studentRepository.findById(id).get();
    }
}
