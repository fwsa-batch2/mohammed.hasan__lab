package com.example.StudentsForm;

import com.example.StudentsForm.entity.Student;
import com.example.StudentsForm.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentsFormApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsFormApplication.class, args);
	}

// Implement CommandLineRunner ->	To add these data to table when application is started
//	@Autowired
//	private StudentRepo studentRepo;
//	@Override
//	public void run(String... args) throws Exception {
//		Student student1 = new Student(4L,"Vaishnavi","Paramathma","Chennai");
//		studentRepo.save(student1);
//		Student student2 = new Student(7L,"Kasi","Antony","Tirunelveli");
//		studentRepo.save(student2);
//	}
}
