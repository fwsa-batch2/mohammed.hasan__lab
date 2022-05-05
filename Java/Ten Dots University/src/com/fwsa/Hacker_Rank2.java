package com.fwsa;
import java.util.Scanner;

public class Hacker_Rank2 {
    public static void main(String[] args) {
     try{
         Float f = new Float("3.0");
         int x = f.intValue();
         byte b = f.byteValue();
         double d = f.doubleValue();
         System.out.println(d);
         System.out.println(x+b+d);
     }catch (NumberFormatException  err){
         System.out.println("Bad num");
     }
    }
}
class SampleDemo implements Runnable {
    private Thread t;
    private String threadName;

    SampleDemo (String threadName){
        this.threadName = threadName;
    }
    public void run()
    {
        int i=0;
        if(Thread.currentThread().getId() == 17)  // A is 17  B is 16. See execution
            Thread.yield();
        while (i < 50) {
            System.out.print(threadName);
            i++;
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start ()
    {
        if (t == null)
        {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}
class TestThread {

    public static void main(String args[]) {

        SampleDemo A = new SampleDemo( "A");
        SampleDemo B = new SampleDemo( "B");
        B.start();
        A.start();
    }
}

