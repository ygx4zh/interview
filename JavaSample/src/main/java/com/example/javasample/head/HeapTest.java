package com.example.javasample.head;

import java.util.Comparator;

/**
 * test heap
 *
 * @author YGX
 */

public class HeapTest {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{7, 1, 3, 10, 5, 2, 8, 9, 6};

        IHeap<Integer> heap =
                new MinHeapWrapper<>(array);

        heap.build();
        String s = heap.toHeapString();
        /*
         1
        5 2
        6 7 3 8
        9 10
         */
        System.out.println(s);
        heap.append(1);
        String s2 = heap.toHeapString();
        /*
         1
        1 2
        6 5 3 8
        9 10 7
         */
        System.out.println(s2);
        heap.delete(1);
        String s3 = heap.toHeapString();

        /*
         1
        5 2
        6 7 3 8
        9 10
         */
        System.out.println(s3);
    }
}
