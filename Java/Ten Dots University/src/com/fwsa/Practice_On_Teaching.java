package com.fwsa;

import com.whatsapp.Main;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Pattern;

// String Builder and Buffer
public class Practice_On_Teaching extends Thread implements Runnable {
    public static void main(String[] args) throws Exception {
//        StringBuilder st = new StringBuilder("Hasan");
//        System.out.println(st.capacity());

//        String string = "Hello";
//        String[] stArray = string.split("l");
//        System.out.println(Arrays.toString(stArray));
//        priorityQueue();
//        BlockingQueue();
        deque();
    }
    static void priorityQueue(){
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(4);
        queue.add(2);
        queue.add(1);
        queue.add(6);
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue.peek());
    }

    static BlockingQueue<String> ob;
    static void BlockingQueue() throws InterruptedException {
        System.out.println();
       ob = new ArrayBlockingQueue<>(3);
        ob.put("Riyaz");
        ob.put("Hasan");
        ob.put("Kaushik");
        System.out.println(ob);
        new Practice_On_Teaching().start();
        ob.put("Aswath");
        System.out.println(ob);
}
static  void deque(){
        Deque deque = new ArrayDeque();
        deque.add(2);
        deque.add(1);
        deque.offerFirst(5);
        deque.offerLast(4);

        System.out.println(deque);
}

    public void run(){
        try {
            Thread.sleep(5000);
            ob.remove("Hasan");
        } catch (InterruptedException e) {
                e.getMessage();
        }
    }

}
class Solution {
    public static void main(String[] args) {
//     reversingString();
//        list();
//        practiceInRegex();
//        basicRegex();
//        bigInteger();
    }

    static void formattingInOutput(){
        List all = new ArrayList();
        System.out.println(Arrays.asList(Collections.reverse(all)));
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<3;i++)
        {
            String output = "";
            String s1=sc.next();
            int x=sc.nextInt();
            System.out.printf("%-15s",s1); // formatiing in sout itself
            System.out.printf("%03d",x);
            System.out.println();
        }
    }
    static void reversingString() {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        StringBuilder result = new StringBuilder("");
        result.append(A);
        String B = result.reverse().toString();
        System.out.println(B.equals(A) ? "Yes" : "No");
    }
    static void list(){
        HashMap<String,String> lst = new HashMap();
        lst.put("no1","Hasan");
        lst.put("no2","Kasi");
        lst.put(null,"nulish");
        lst.put(null,null);
        System.out.println(lst);
    }
   static void practiceInRegex(){
       Scanner scan = new Scanner(System.in);
       String s = scan.nextLine();
       String[] arr = s.split("[^a-zA-Z]");
       int counter = 0;
       String output = "";
       for (String i : arr) {
          if(i.length() > 0) {
              counter++;
              output += i + "\n";
          }
       }
       System.out.println(counter);
       System.out.println(output);
       scan.close();
   }
   static void basicRegex(){
       Scanner in = new Scanner(System.in);
       int testCases = Integer.parseInt(in.nextLine());
       while(testCases>0){
           String pattern = in.nextLine();
           //Write your code
           System.out.println(pattern);
       }
   }
   static void bigInteger(){
       Scanner input = new Scanner(System.in);
       BigInteger a = input.nextBigInteger();
       BigInteger b = input.nextBigInteger();
       System.out.println(a.add(b));
       System.out.println(a.multiply(b));
   }
}


class MyRegex{
    public static void main(String[] args) {
//        String zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|\\d2[0-4]|25[0-5])";

        Pattern pattern = Pattern.compile("[0-255]{1,3}\\.[0-255]{1,3}\\.[0-255]{1,3}\\.[0-255]{1,3}");
        System.out.println(Pattern.matches(pattern.toString(),"000.132.132.034"));
    }
}





