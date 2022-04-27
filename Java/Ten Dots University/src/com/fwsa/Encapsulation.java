package com.fwsa;

import tendotsuniv.in.Sub;

import java.util.ArrayList;

public class Encapsulation {
    private String name;
    private String password;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
class Encapsulation2{
    public static void main(String[] args) {
//        Encapsulation2 obj = new Encapsulation2();
//        System.out.println(Encapsulation2.hasan);     // Example for protected access modifier

        Encapsulation ob = new Encapsulation();
        ob.setName("Hasan");
        ob.setPassword("*****");
        System.out.println("Name : " + ob.getName() + " Password : " + ob.getPassword());
    }
}
