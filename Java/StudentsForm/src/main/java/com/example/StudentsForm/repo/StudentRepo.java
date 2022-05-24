package com.example.StudentsForm.repo;

import com.example.StudentsForm.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Long> {

}
