package com.freeCodeCampPractice;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/test")  // Works for localhost:8080/test
public class Main {
    List<String> all = new ArrayList<String>();
    @PostMapping
    List<String> add(@RequestBody String name) {
        all.add(name);
        return all;
    }

    @GetMapping
    List<String> getAll() {
        return all;
    }
    @PutMapping
    void set(@RequestBody @JsonProperty("index") int index,@JsonProperty("name") String newName) {
        System.out.println(index + " " + newName);
        all.set(index, newName);
    }
}