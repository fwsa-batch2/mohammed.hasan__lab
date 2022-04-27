package com.fwsa;

import java.io.*;

public class Serialization {
    public static void main(String[] args) throws Exception {
            System.out.println("Serialization");
            Student ob = new Student(1,"Hasan",20);
            FileOutputStream fileOutputStream = new FileOutputStream("serialized.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            out.writeObject(ob);
            out.flush();
            out.close();
            System.out.println("Serialization Success");

            System.out.println("Deserialization");
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("serialized.txt"));
            Student obj = (Student) in.readObject();
            System.out.println(obj.id + " " + obj.name);
             System.out.println("Deserialization Success");
    }
}
class Student implements Serializable {
    int id;
    String name;
    int age;
    public Student(int id,String name,int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
}

