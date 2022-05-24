package com.example.demo;

import com.freeCodeCampPractice.Main;
import com.project.Home;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Main.class, args);
//		applicationContext.getBean(Alien.class);
	}

}
