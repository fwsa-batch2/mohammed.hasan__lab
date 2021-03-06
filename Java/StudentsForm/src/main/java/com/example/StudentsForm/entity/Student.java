package com.example.StudentsForm.entity;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sun.istack.NotNull;
import netscape.javascript.JSObject;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    private Long id;
    @Column(name = "f_name") @NotNull
    private String firstName;
    @Column(name = "l_name")
    private String lastName;
    @Column(name = "city")
    private String city;

    public Student() {
    }

    public Student(Long id, String firstName, String lastName, String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
