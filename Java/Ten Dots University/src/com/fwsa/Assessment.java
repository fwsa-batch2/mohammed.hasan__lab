package com.fwsa;

import java.util.Arrays;
import java.util.Scanner;

public class Assessment {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
//        int cores = Runtime.getRuntime().availableProcessors();
//        System.out.println(cores);
//        reverseAnything();
//        twoDimensionalArray();
//        sortingArray();
//        amstrong();
//        strongNumber();
//        counter("Kasi is 19 year old");
//        dummy();
    }
    static void dummy(){
        String a="abc";
        String b = "abc";
        System.out.println(a==b);
        String c=new String("abc");
        String d = new String("abc");
        System.out.println(c==d);
        System.out.println(c.equals(d));
    }

    static void reverseAnything() {
        System.out.println("Enter something to reverse it : ");
        String in = input.nextLine();
        StringBuilder result = new StringBuilder();
        result.append(in);
        System.out.println("Reverse is: " + result.reverse());
    }

    static void twoDimensionalArray() {
        int[][] arr = {{1, 2}, {2, 3}, {4, 5, 5, 7, 67, 98}};
        for (int i[] : arr) {
            String output = "";
            for (int j : i) {
                output += " " + j + " ";
            }
            System.out.println("[" + output + "]");
        }
    }

    static void sortingArray() {
        System.out.println("Enter the number of elements in array : ");
        int len = input.nextInt(), i = 0, temp = 0;
        int[] arr = new int[len];
        System.out.println("Enter the elements of array : ");
        for (i = 0; i < len; i++)
            arr[i] = input.nextInt();
        for (int el = 0; el < arr.length; el++) {
            for (int innerEl = el + 1; innerEl < arr.length; innerEl++) {
                if (arr[el] > arr[innerEl]) {
                    temp = arr[el];
                    arr[el] = arr[innerEl];
                    arr[innerEl] = temp;
                }
            }
        }
        System.out.println("Sorted array : " + Arrays.toString(arr));
    }

    static void amstrong() {
        System.out.println("Enter a number to check whether it is amstrong or not :");
        int in = input.nextInt(), num = in, result = 0;
        int len = Integer.toString(num).length();
        System.out.println(len);
        int[] numArray = new int[len];
        System.out.println(Arrays.toString(numArray));
        // 153
        for (int i = 0; i < len; i++) {
            numArray[i] = num % 10;
            num = num / 10;
            result = (int) (result + (Math.pow(numArray[i], len)));
        }
        System.out.println(Arrays.toString(numArray));
        String condition = result == in ? "an Amstrong number" : "not an Amstrong number";
        System.out.println("The given number is " + condition);
    }

    static void strongNumber() {
        System.out.println("Enter a number to check whether it is Strong or not : ");
        int num = input.nextInt(), result = 0, temp = num;
        int len = Integer.toString(num).length();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = temp % 10;
            temp /= 10;
        }
        for (int i : arr) {
            int fact = 1;
            for (; i > 0; i--) {
                fact *= i;
            }
            result += fact;
        }
        String output = result == num ? "is a Strong number" : "is not a Strong number";
        System.out.println("The given number " + output);
    }

    public static void counter(String sentence) {
        int dbl = 0;
        int str = 0;
        int integer = 0;
        String[] arr = String.valueOf(sentence).split("\\s");
        for (int i = 0; i < arr.length; i++) {
            try {
                Integer.parseInt(arr[i]);
                integer++;
            } catch (Exception e) {
                try {
                    Double.parseDouble(arr[i]);
                    dbl++;
                } catch (Exception err) {
                    str++;
                }
            }
        }
        System.out.println("Integers " + integer);
        System.out.println("Strings " + str);
        System.out.println("Double " + dbl);
    }
}
abstract class Car {
    abstract void name();

    abstract void speed();

    private String guaranty() {
        return "Guaranty is 1 year";
    }

    void getGuaranty() {
        System.out.println(guaranty());
    }

}

class Bugatti extends Car {
    @Override
    void name() {
        System.out.println("Bugatti");
    }

    @Override
    void speed() {
        System.out.println("200km/hr");
    }

    public static void main(String[] args) {
        Bugatti ob = new Bugatti();
        ob.name();
        ob.speed();
        ob.getGuaranty();
    }
}
