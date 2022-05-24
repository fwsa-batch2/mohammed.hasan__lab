package com.example.StudentsForm.service;

import com.example.StudentsForm.entity.Student;

import java.util.List;

public interface StudentService {
     List<Student> getAllStudents();
     Student saveStudent(Student student);
     Student getStudentById(Long id);
     void deleteStudentById(Long id);
}
