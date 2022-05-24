package com.example.StudentsForm.controller;

import com.example.StudentsForm.service.StudentServiceImpl;
import com.example.StudentsForm.entity.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {
    private StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }
    //  Displaying students
    @RequestMapping("/students")
    public ModelAndView listStudents(ModelAndView model) throws JsonProcessingException {
        List<Student> list = studentService.getAllStudents();
        model.addObject("students", list);
        model.setViewName("students");
        return model;

        // Passing this as 2nd arg in addObject
//        System.out.println(new Gson().toJson(list.get(0)));

//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String json = ow.writeValueAsString(list.get(0));
//        model.addObject("student", json);
    }

    //  Adding Student
   //  When does this gets called  ?
    @RequestMapping("/students/new")
    public ModelAndView addStudent(ModelAndView modelAndView){
        Student student = new Student();
        modelAndView.addObject("student", student);
        modelAndView.setViewName("newStudent");
        return modelAndView;
    }

    // When Model gets refreshed or when does it get reloaded or deletes all objects added to it

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    //  Updating Students
    @RequestMapping("students/edit/{id}")
    public ModelAndView editStudent(@PathVariable Long id,ModelAndView modelAndView){
        modelAndView.addObject("student",studentService.getStudentById(id));
        modelAndView.setViewName("editStudent");
        return modelAndView;
    }
    @PostMapping("students/{id}")
    public String updateStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    // Deleting Student
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id){
    studentService.deleteStudentById(id);
    return "redirect:/students";
    }
}
