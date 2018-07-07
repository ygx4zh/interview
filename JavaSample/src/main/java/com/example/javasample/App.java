package com.example.javasample;

import java.util.Arrays;

public class App {
    public static void main(String[] args){
       /* double sqrt = Math.sqrt(100);
        System.out.println(sqrt);*/
       int[] array = {12, 65, 78,2,45,33, 90,2,100};
       // SortUtil.bubbleSort(array);
       SortUtil.selectSort(array);
       System.out.println(Arrays.toString(array));
    }
}
