package com.example.javasample.head;


import java.util.List;

public class Heaps {

    public static void printfArray(int[] array) {

        int c = 0, num = 0;
        for (int i = 0; i < array.length; i++) {

            System.out.print(array[i] + " ");

            if (num == 0) {
                num = (int) (Math.pow(2, c++));
            }

            if (--num == 0) System.out.println();
        }
        System.out.println();
    }

    public static<T> void printfArray(List<T> list) {

        int c = 0, num = 0;
        int size = list.size();
        for (int i = 0; i < size; i++) {

            System.out.print(list.get(i) + " ");

            if (num == 0) {
                num = (int) (Math.pow(2, c++));
            }

            if (--num == 0) System.out.println();
        }
        System.out.println();
    }

    public static<T> void printfArray(T[] array) {

        int size = array.length;
        int c = 0, num = 0;
        for (int i = 0; i < size; i++) {

            System.out.print(array[i] + " ");

            if (num == 0) {
                num = (int) (Math.pow(2, c++));
            }

            if (--num == 0) System.out.println();
        }
        System.out.println();
    }
}
