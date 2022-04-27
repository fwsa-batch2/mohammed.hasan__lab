package com.fwsa;

public class Multi_Threading implements Runnable {
    int thread;
    Multi_Threading(int thread){
        this.thread = thread;
    }

    public static void main(String[] args) {
        System.out.println("Multi Threading");
        for(int i = 1 ; i < 5 ; i++) {
            Multi_Threading obj = new Multi_Threading(i);
            Thread thread = new Thread(obj);
            thread.start();
        }
    }
    @Override
    public void run() {
        try {
            for(int i = 0; i < 5; i++){
                System.out.println(i + " from Thread " + thread);
                Thread.sleep(1000);
            }

        }catch (Exception err){
            err.printStackTrace();
        }

    }
}
