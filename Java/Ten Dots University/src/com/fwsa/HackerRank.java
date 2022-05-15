package com.fwsa;

import java.util.Scanner;

public class HackerRank {
    public static void main(String[] args) {
        typeCounter("386 hasan is 834.876");
    }
    public static void typeCounter(String sentence) {
        int dbl = 0;
        int str = 0;
        int integer =0;
        String[] arr = String.valueOf(sentence).split("\\s");
        for(int i=0; i < arr.length;i++ ){
            try {
                   Integer.parseInt(arr[i]);
                    integer++;

                }catch (Exception e){
                try{
                    Double.parseDouble(arr[i]);
                    dbl++;
                }catch (Exception err){
                    str++;
                }
            }
//            if(arr[i].matches("[0-9]+")){
//                ++integer;
//             }
//           else if(arr[i].matches("[a-zA-Z]+")){
//                ++str;
//            }
//            else{
//                ++dbl;
//            }
        }
        System.out.println("Integers " + integer);
        System.out.println("Strings " + str);
        System.out.println("Double " + dbl);
    }
     static void seriesOfPattern() {
            System.out.println("Enter number of pairs of inputs");
            Scanner in = new Scanner(System.in);
            System.out.println("Enter 3 values a,b and n for a series of pattern to print: ");
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int output = 0;
            for(int j=0;j<n;j++){
                output +=((int)Math.pow(2,j) * b);
                System.out.print(output+a + " ");
            }
            System.out.println();
            output = 0;
            in.close();
    }
}
