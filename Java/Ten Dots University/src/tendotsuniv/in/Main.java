package tendotsuniv.in;
import com.fwsa.Nested_Class;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

// import java.lang.System.Logger;
public class Main {
    public static void main(String[] name) {
//        System.out.println("first name " + name[0].toLowerCase());
//        System.out.println("second name " + name[1].toUpperCase());

        //      Calling classes in other files but same package
//        Sub subObj = new Sub();
//        subObj.main();
//        System.out.println(subObj);

        final int a = 5;
        int b = 10;
        System.out.println((new String("Hasan")).hashCode() + "   " + (new String("Hasan")).hashCode());
//        Cat obj = new Cat();
//        obj.main();
        Hasan ob = new Hasan();
//        ob.twoDimenArray();

//        Hasan h = new Hasan();
//        h.twoDimenArray();
//        returnName();
//        dateTimeConcept();
//         System.out.println("Sum is " + (a+b));
//         Main h = new Main();
//         arrayTraversing();
//        fhrnToCelsius();
//        addingAllDigits();

    }
    static void dateTimeConcept(){
        //        LocalDateTime date = LocalDateTime.now();   Since now() is static we can call directly
        System.out.println(LocalDateTime.now());

//        Formatting a date according to our wish
        DateTimeFormatter dateObj = DateTimeFormatter.ofPattern("dd E,MMMM yyyy hh-mm");
        // If 3 'M' is given for month then displays shorter
        System.out.println( LocalDateTime.now().format(dateObj));
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
    static void arrayTraversing(){
        int[] arr = {1,2,3};
        int a = 5;
        System.out.println(Arrays.toString(arr));   // Way to display an Array properly
        System.out.println(arr.getClass().getSimpleName());  // To get type of all variables except int
        System.out.println(((Object)a).getClass().getSimpleName());  // To get type of all variables

//        String[] arr = {"hasan", "ismail", "mushraf" , "aswath"};
//        for(String i : arr){  // for each loop
//            System.out.println(i);
//        }
        Collections.reverse(Arrays.asList(arr));    // Reverse an array


    }
    static void returnName(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter name :");
        String nameOfUser = input.nextLine();
        System.out.println("Hello " + nameOfUser);
        input.close();

    }
}
class Hasan{
    void twoDimenArray(){
        int[][] twoDimenArray = {{1,2,3},{4,5}};
        // Two-dimensional Array in which size of elements are different are called Jagged Array
        for(int k[]:twoDimenArray){
            for(int i:k){
                System.out.println(i);
            }
        }
        System.out.println(twoDimenArray[1][1]);
    }
    public static void main(String[] args){
//         arrayList();
//         hashMap();
//        tryCatch();

    }
    static void tryCatch(){
        try{
            int[] arr = {2,3,4};
            System.out.println(arr[3]);
        }catch(Exception err) {     // Replacing Exception by Error gives line of error and details of where error occurs
            System.out.println(err);
        }
    }

    // Array List
    static void arrayList(){
        ArrayList <String> students = new ArrayList <String>();     // If need to declare int, then type "Integer" in brackets
        students.add("hasan");
        students.add("ismail");
        students.add("aswath");
        students.set(1,"Mass");   // This comes first because "M" is capital. So it is case-sensitive
        int size = students.size();
        System.out.println((students.get(1)));
        Collections.sort(students);
        for(String i : students){
            System.out.println(i);
        }
    }
    static void hashMap(){
        HashMap <String, String> courses = new HashMap <String,String>();
        courses.put("name", "Mechanical");
        courses.put("name", "Computer");
        System.out.println(courses.get("name"));        // Displays last added element if key is same
for(String i : courses.keySet()){
    System.out.println(i);      // Displays only 1 element
}
    }
}

//      Abstraction
abstract class Car {
    public String name() {
        Animal ob = new Animal();
        System.out.println(ob.sample1);     // Using protected variable in other class
        return "Hello";
    }
    abstract  void carName();
    abstract  void carSpeed();
}

class Bugatti extends Car{
    void carName(){
        System.out.println("Bugatti");
    }
    void carSpeed(){
        System.out.println("200 km/hr");
    }
    void main(){
        Car bugatti = new Bugatti();
        bugatti.carName();
        bugatti.carSpeed();
    }
}

//      Polymorphism

class Animal{
    void name(){
        System.out.println("Dog");
    }
    protected int sample1 = 5;
}
class Cat extends Animal{
    void name(){
        System.out.println("Cat");
    }
    public void main(){
        Animal cat = new Cat();
        cat.name();
        super.name();
    }
}

// Interface  i.e complete abstraction
interface Animal2{
   public void name();       // Cannot have any method with body. This is the difference between abstraction
    // and interface. Whereas abstraction can have method with body also.
    static void user(){
        System.out.println("Interface body");   // Whereas we can do by declaring static method
    }
}
class Cat2 implements Animal2{
   public void name(){
       System.out.println("Cat");
    }
    void main(){
        Animal2 cat = new Cat2();
        cat.name();
        forEnum();
 
    }
    void forEnum(){
        enum Grades{        // Can also be declared outside of a Class and also use it since it is a class
            LOW(5),   
            MEDIUM,
            HIGH;
            int a = 5; // If want can pass argument to constructor. Only three objects or options are avail. for enum
            Grades(){};
            Grades(int a){
            	this.a = a;
            }
           public void print() {
            	System.out.println(a);
            }
        	
        }
        Grades var = Grades.HIGH;
        var.print();
   }
}

