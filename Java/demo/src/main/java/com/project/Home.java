package com.project;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
@Controller
@RequestMapping("test")
public class Home {
    @GetMapping
   public ModelAndView home( Alien obj) {
        System.out.println("Name: " + obj.getName() + " Id: " + obj.getId());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("obj", obj);
        modelAndView.setViewName("home");
        return modelAndView;
    }
}
