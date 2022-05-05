package com.fwsa;

public class HackerRank {
    public static void main(String[] args) {
        Result.typeCounter("386 hasan is 834.876");
    }
}

class Result {
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
}