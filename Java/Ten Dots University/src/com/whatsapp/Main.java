package com.whatsapp;

public class Main {
    public static void main(String[] args) {
        SendTo ob = new SendTo(9876543210L);
        ob.send();
    }
}

class SendTo{
    private static long number;
    SendTo(long number){
        this.number = number;
    }
    static void send(){
        System.out.println("Sent to " + number);
    }
}