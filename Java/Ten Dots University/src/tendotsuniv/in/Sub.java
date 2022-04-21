package tendotsuniv.in;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Sub {
    protected int hasan = 0;
    public static void main(String[] args){
//        patternConcept();
//        dum.main();
//        listConcepts();
    }
    static void patternConcept(){
        Pattern pattern = Pattern.compile("don", Pattern.CASE_INSENSITIVE);
        Matcher match = pattern.matcher("Hasan is the Don");
        System.out.println(match.find());
    }
    static void listConcepts(){
        List <String> lst1 = new ArrayList<>();
        lst1.add("Humaira");
        lst1.add("Hasn");
        lst1.add("Don");
        List <String> lst2 = new ArrayList<>();
        lst2.addAll(lst1);   // addAll is used to all other list elements
        System.out.println(lst2);
    }
}

// Manipulation of Array
class Array{
    private int count = 0;
    int[] array;
    int[] extendedArr;

    public static void main(String[] args) {
        Array ob = new Array(1);
        ob.insert(1);
        ob.insert(2);
        ob.insert(3);
        ob.insert(4);
        ob.insert(5);
        ob.removeAt(3);
        ob.print();
    }
    public Array(int length){
       array = new int[length];
    }
    void print(){
        for(int i= 0; i < count; i++){
            System.out.println(array[i]);
        }
    }
    void insert(int item){
        if(array.length == count){
            extendedArr = new int[array.length * 2];
            for(int i = 0; i< count; i++){
                extendedArr[i] = array[i];
            }
            array = extendedArr;
        }
        array[count++] = item;      // For inserting the item in array
    }
    void removeAt(int index){
        if(index < 0 || index >= count){
            throw  new IllegalArgumentException();
        }
        for(int i = index; i < count; i++){
            array[index] = array[index+1];
        }
        count--;
    }
}

// Assignments given by Mam
class Assignments{
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
//        reverseDigit();
//        factorial();
//        fibonacci();
//        amstrong();
//        palindrome();
//        averageOfNum();
//        reverseAnything();
//        perfectNumber();
//        strongNumber();
//        sortingArray();
    }
    static void strongNumber(){
        System.out.println("Enter a number to check whether it is Strong or not : ");
        int num = input.nextInt(),result = 0, temp = num;
        int len = Integer.toString(num).length();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = temp%10;
            temp/=10;
        }
        for (int i : arr) {
            int fact = 1;
            for(; i > 0; i--){
                fact *= i;
            }
            result+=fact;
        }
        String output  = result == num ? "is a Strong number" : "is not a Strong number" ;
        System.out.println("The given number " + output);
    }
    static void perfectNumber(){
        System.out.print("Enter a number to check whether it is Perfect number or not :  ");
        int num = input.nextInt(),result = 0;
        for (int i = 1; i < num; i++) {
           if(num % i ==0){
               result += i;
           }
        }
        String output = result == num ? "is a Perfect number" : "not a Perfect number";
        System.out.println("The given number " + output);
    }
    static void reverseAnything(){
        System.out.println("Enter something to reverse it : ");
        String in = input.nextLine();
        StringBuilder result = new StringBuilder();
        result.append(in);
        System.out.println("Reverse is: "+result.reverse());
    }
    static void reverseDigit(){
        System.out.println("Enter a number to reverse it : ");
        int num = input.nextInt();
        int reverse = 0,reminder;
        while(num!=0){
            reminder = num%10;
            reverse = (reverse *10) + reminder;
            num/=10;
        }
        System.out.println("Reversed number is : " +reverse);
    }
    static void factorial(){
        System.out.println("Enter the number for which you need Factorial : ");
        int num = input.nextInt();
        int result = 1;
        for(int i = num; i > 0 ;i--){
           result*=i;                           //  result = i * result;
        }
        System.out.println("Factorial of the given number is : " + result);
    }
    static  void fibonacci(){
        int a = -1,b =1,c;
        System.out.println("Enter the number of Fibonacci series youn need: ");
        int count = input.nextInt();
       for(int i = 0; i < count; i++){
           c= a+b;
           System.out.println(c);
           a=b;
           b=c;
       }
    }
    static void amstrong() {
        System.out.println("Enter a number to check whether it is amstrong or not :");
        int in = input.nextInt(),num = in,result = 0;
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
        System.out.println("The given number is " + condition) ;
    }
    static void palindrome(){
        System.out.println("Enter a string to check palindrome: ");
        String in = input.nextLine();
        String reverse = "";
        for(int i = in.length() - 1; i >= 0;i--){
            reverse+= in.charAt(i);
        }
        System.out.println(in);
        System.out.println(reverse);
        String result = reverse.equals(in) ? "is a Palindrome" : "is not a Palindrome";
        // == operator gives error so using equals()
        System.out.println("The entered string " + result);
    }
    static  void averageOfNum(){
        System.out.println("Enter the count of numbers : ");
        int count = input.nextInt();
        int[] numbers = new int[count];
        for (int i = 0; i < count; i++) {
            System.out.println("Enter the number: ");
            numbers[i] = input.nextInt();
        }
        int result = IntStream.of(numbers).sum();
        System.out.println("Average of given numbers is: " +(float)result/count);
    }
    static void sortingArray(){
        System.out.println("Enter the number of elements in array : ");
        int len = input.nextInt(),i = 0,temp = 0;
        int[] arr = new int[len];
        System.out.println("Enter the elements of array : ");
        for(i = 0 ; i < len; i++)
            arr[i] = input.nextInt();
        for(int el = 0; el < arr.length; el++){
            for(int innerEl = el+1; innerEl < arr.length; innerEl++){
                if(arr[el] > arr[innerEl]){
                    temp = arr[el];
                    arr[el] = arr[innerEl];
                    arr[innerEl] = temp;
                }
            }
        }
        System.out.println("Sorted array : " + Arrays.toString(arr));
    }
}

//  Constructor Concept
class CreateObject {
    int a;
    CreateObject(int in){
        a = in;
        System.out.println(a);
    }
}
class Constructor {
    public static void main(String[] args) {
        CreateObject ob = new CreateObject(2);
        System.out.println(ob.a);
    }
}

// Simple Calculator
class Calculator{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num1 = input.nextInt(),result = 0;
        System.out.print("Enter the operator you need to perform ( + , - , * , / , % , ^ ) : ");
        String operator = input.next();
        System.out.print("Enter second number : ");
        int num2 = input.nextInt();
        switch (operator){
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            case "%":
                result = num1 % num2;
            case "^":
                result = (int) Math.pow(num1,num2);
                break;
            default:
                System.out.println("Please enter proper operator ..!");
        }
        System.out.println("Result : " + result);
    }
}


// Thread Concept
class dum extends Thread  {
    public static int amount = 0;
    public static void main() {
        dum thread = new dum();
        thread.start();
        // Waits for the thread to finish
        while(thread.isAlive()) {
            System.out.println("Waiting...");
        }
        // Update amount and print its value
        System.out.println("Main: " + amount);
        amount++;
        System.out.println("Main: " + amount);
    }
    public void run() {         // Is automatically invoked while calling start() method.
        // But if we call run(), it executes only that

//      System.out.println("Run" + amount);
        amount++;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

