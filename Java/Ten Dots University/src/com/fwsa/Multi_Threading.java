package com.fwsa;

public class Multi_Threading implements Runnable {
    int thread;
    private int thread1;

    Multi_Threading(int thread){
        this.thread = thread;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Multi Threading");
        for(int i = 1 ; i < 5 ; i++) {
            Multi_Threading obj = new Multi_Threading(i);
            Thread thread = new Thread(obj);
            thread.start();
//            thread.join();
        }
        System.out.println("Ended");
    }
    @Override
    public void run() {
        try {
            for(int i = 0; i < 5; i++){
//                if(Thread.currentThread().getId() == 17) {
//                    System.out.println(Thread.currentThread().getId());
//                      Thread.yield();
//                }
               thread(thread,i);
            }
        }catch (Exception err){
            err.printStackTrace();
        }
    }
   synchronized static void thread(int thread,int i) throws Exception{
        System.out.println(i + " from Thread " + thread);
//      System.out.println("Name "+ Thread.currentThread().getId());
        Thread.sleep(600);
    }

}
