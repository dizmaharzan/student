package com.example.student.service;

import com.example.student.model.Student;

import java.util.List;

public interface StudentService {
    public List<com.example.student.model.Student> getAllStudent();
    public com.example.student.model.Student createStudent(com.example.student.model.Student customer);
    public void deleteStudent(int id);
    public com.example.student.model.Student getStudent(int id);
}
