package com.example.javasample;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 *
 * 快速排序
 *
 * @author YGX
 */

public class QuickSort2 {

    public static void main(String[] args) {
        Random r = new Random();
        final IntWrapper[] wrappers = new IntWrapper[1000 * 10000];
        for (int i = 0; i < 1000 * 10000; i++) {
            wrappers[i] = new IntWrapper(r.nextInt(1000 * 10000));
        }
        // String before = Arrays.toString(wrappers);
       //  System.out.println("before: "+before);
        long l = System.currentTimeMillis();
        /*sort(wrappers, 0, wrappers.length - 1, new Comparator<IntWrapper>() {
            @Override
            public int compare(IntWrapper w1, IntWrapper w2) {
                return w1.getValue() - w2.getValue();
            }
        });*/
        Arrays.sort(wrappers, Comparator.comparingInt(IntWrapper::getValue));
        // 100 * 10000, 534毫秒
        // 1000 * 10000, 5053毫秒
        long end = System.currentTimeMillis();
        System.out.println("millis: "+(end-l));
        // String after = Arrays.toString(wrappers);
        // System.out.println("after: "+after);
        // 使用Arrays.sort来排序, 1000w条数据, 耗时6956毫秒, 猜测是因为担心栈溢出的情况, 所以内部做了判断
    }

    private static<T> void sort(T[] array, int start, int end, Comparator<T> comparator){

        if(start >= end) return;

        // 查找基准点的索引
        int pivotPosition = findPivotPosition(array, start, end, comparator);
        sort(array, start, pivotPosition - 1, comparator);
        sort(array, pivotPosition + 1, end, comparator);
    }

    private static <T> int findPivotPosition(T[] array, int start, int end, Comparator<T> comparator) {

        int left = start;
        int right = end;
        int index = start;

        // 基准点一旦选中, 是不会变的
        final T pivot = array[left];

        while (right > left){
            while (right > left){

                if(comparator.compare(pivot, array[right]) > 0){
                    array[index] = array[right];
                    index = right;
                    left ++;
                    break;
                }

                right -- ;
            }

            while (right > left){
                if(comparator.compare(pivot, array[left]) < 0){
                    array[index] = array[left];
                    index = left;
                    right --;
                    break;
                }

                left ++;
            }
        }

        array[index] = pivot;

        return index;
    }

    static class IntWrapper{

        private final int value;

        public IntWrapper(int value){
            this.value = value;
        }

        public int getValue(){
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }
}
