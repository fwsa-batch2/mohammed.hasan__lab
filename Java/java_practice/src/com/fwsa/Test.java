package com.fwsa;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
//        leapYear();
//        largest();
        alphabets();
    }
    static public void leapYear(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a year to check Leap Year : ");
       int in = input.nextInt();
        String output = in % 4 == 0 ? "Leap year" : "not a Leap year";
        System.out.println(in + " is " + output);
    }
    static void largest(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 3 numbers : ");
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        if(a>b && a>c){
            System.out.println(a + " is greatest");
        }else if(b>c && b>a){
            System.out.println(b + " is greatest");
        }else{
            System.out.println(c + " is greatest");
        }
    }
    static void alphabets(){
        for (int i = 97; i < 123; i++) {
            System.out.print((char)i + " ");
        }
        System.out.println();
        for (int i = 65; i < 91; i++) {
            System.out.print((char)i + " ");
        }
    }
}
