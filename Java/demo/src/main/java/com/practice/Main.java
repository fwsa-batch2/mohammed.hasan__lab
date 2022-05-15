package com.practice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@SpringBootApplication
@RequestMapping("test")
@RestController
public class Main {
    ArrayList<String> all = new ArrayList<>();

    @PostMapping
    void add(@RequestBody String name) {
        all.add(name);
    }

    @GetMapping
    ArrayList<String> getAll() {
        return all;
    }
    @PutMapping
    boolean set(@RequestBody @JsonProperty("index")int index,@JsonProperty("name") String newName) {
        try {
            all.set(index, newName);
            return true;
        } catch (Exception r) {
            return false;
        }
    }
}