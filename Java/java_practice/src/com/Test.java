package com;

public class Test implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Test test = new Test();
        for (int i = 0; i < 4; i++) {
            Thread thread = new Thread(test);
            thread.start();
            thread.join();
        }
    }

    public synchronized void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(i + " from " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
