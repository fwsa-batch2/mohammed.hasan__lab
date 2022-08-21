package com.whatsapp;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Messaging message = new Messaging("Hi How are you ?",9876543210L,9876543211L);
//        message.send();
//        message.receive();
        // Creates a group
//        message.createGroup("Friends", new Long[]{9876543210L,8937589445L});
        // Adds new members to a group
//        message.addMemberInGroup("Friends",new Long[]{78271382345L,1234567890L});
    }
}

class Messaging extends Main{
    private long sender;
    private long receiver;
    private String message;
    protected LinkedList<Long> numbersInGroup = new LinkedList<Long>();
    Messaging(String message,long receiver,long sender ){
        this.receiver = receiver;
        this.sender = sender;
        this.message = message;
    }
    void createGroup(String groupName, Long[] numbers){
        System.out.println("Group Name : " + groupName);
        numbersInGroup.addAll(List.of(numbers));
        System.out.print("Numbers : ");
        numbersInGroup.forEach((n) -> System.out.print("\"" + n + "\"  "));
    }
    void addMemberInGroup(String groupName, Long[] numbers){
        System.out.println("Group Name : " + groupName);
        numbersInGroup.addAll(List.of(numbers));
        System.out.println(numbersInGroup);
    }
    void receive(){
        System.out.println("Message : " + message);
        System.out.println("Received from " + receiver);
    }
    void send(){
        System.out.println("Sent to " + sender);
    }
}
