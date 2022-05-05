package com.fwsa;

import java.util.Arrays;

// String Builder and Buffer
public class Practice_On_Teaching {
    public static void main(String[] args) {
        StringBuilder st = new StringBuilder("Hasan");
        System.out.println(st.capacity());

        String string = "Hello";
        String[] stArray = string.split("l");
        System.out.println(Arrays.toString(stArray));

    }
}
