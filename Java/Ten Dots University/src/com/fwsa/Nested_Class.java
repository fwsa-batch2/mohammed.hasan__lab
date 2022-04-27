package com.fwsa;

public class Nested_Class {
    public class nested{
        public void method() {
            System.out.println("Hello");
        }
    }
}

// Paste this in another package
class Dum{
    public static void main(String[] args) {
        Nested_Class.nested ob = new Nested_Class().new nested();
        ob.method();
    }
}
