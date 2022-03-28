package tendots.in;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

// import java.lang.System.Logger;
public class Main {
    final int a = 5;

    public static void main(String[] name) {
        System.out.println("first name " + name[0].toLowerCase());
        System.out.println("second name " + name[1].toUpperCase());
        int b = 10;
//        returnName();
        // System.out.println("Sum is " + (a+b));
         Main h = new Main();
        // System.out.println(h.sample1());
        // arrayTraversing();
//        fhrnToCelsius();
//        addingAllDigits();

    }
    static void addingAllDigits() {
        Scanner input = new Scanner(System.in);
        int data = input.nextInt();
        int output = 0;
        for(int i = 0; data > 0; i ++){
            output+= data%10;
            data/=10;
        }
        System.out.println(output);

    }
    static void fhrnToCelsius(){
        System.out.println(5/9);    // Returns 0 because by default it is int data type
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Fahrenheit");
        int fahrenheit = input.nextInt();
        float celsius = (fahrenheit - 32) * 5/9;
        System.out.println("Celcius " + celsius);
    }
    private String sample1(){       // Here string means , it "must" return a string value
        System.out.println("Hello guys");
//        private String name;      Cannot use private inside fn. Can only be used inside class and outside fn.
        if( a < 5 ){
            return "Hasan";
        }
        else{
            return "DON";
        }
    }
    static void arrayTraversing(){
//        int[] arr = {1,2,3};
//        System.out.println(Arrays.toString(arr));   // Way to display an Array
//        System.out.println(((Object)data).getClass().getSimpleName());  // To get type
        
        String[] arr = {"hasan", "ismail", "mushraf" , "aswath"};
        for(String i : arr){  // for each loop
            System.out.println(i);
        }

    }
    static void returnName(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter name :");
        String nameOfUser = input.nextLine();
        System.out.println("Hello " + nameOfUser);
        input.close();
        Hasan h = new Hasan();
        h.twoDimenArray();
    }
}
class Hasan{
    void twoDimenArray(){
        int[][] twoDimenArray = {{1,2,3},{4,5}};
        System.out.println(twoDimenArray[1][1]);
    }
}
