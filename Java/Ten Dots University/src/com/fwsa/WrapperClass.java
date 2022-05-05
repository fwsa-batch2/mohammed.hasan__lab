package com.fwsa;

public class WrapperClass {
    public static void main(String[] args) {
        System.out.println("Wrapper Class");
        Integer a = 5;
        // Unboxing
        int b = a;
        // Auto-boxing
        Integer c = b;
        System.out.println(a + " " + b);
    }
}
