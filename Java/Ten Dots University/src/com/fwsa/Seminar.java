package com.fwsa;

public class Seminar implements Runnable{
    public static void main(String[] args) throws InterruptedException {
        Seminar obj = new Seminar();
        Thread thread = new Thread(obj);
        thread.start();
        Thread thread1 = new Thread(obj);
        thread1.start();
    }
    @Override
   synchronized public void run(){
        if(Thread.currentThread().getName().equals("Thread-0")) {
            try {
               wait();                              // can only be declared in sync method
               System.out.println("Entered Thread 0");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(Thread.currentThread().getName().equals("Thread-1")) {
            System.out.println("Entered Thread 1");
            try {
                Thread.sleep(5000);
                notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Sample2 extends Thread{
    public static void main(String[] args) {
        Sample2 obj = new Sample2();
        obj.start();
    }
    public void run(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Running thread");
    }
}
