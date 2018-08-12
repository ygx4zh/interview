package com.example.javasample;

import java.util.Arrays;
import java.util.Random;



public class QuickSort {
    public static void quickSort(int[] array, int startIndex, int endIndex){
        if(startIndex >= endIndex) return;

        int pivotIndex = partition(array,startIndex,endIndex);
        quickSort(array, startIndex, pivotIndex-1);
        quickSort(array, pivotIndex+1, endIndex);
    }

    private static int partition(int[] array, int startIndex, int endIndex) {
        int pivot = array[startIndex];
        int left = startIndex;
        int right = endIndex;

        // 坑
        int index = startIndex;

        while(right >= left){
            while (right >= left){
                if(array[right] < pivot){
                    array[left] = array[right];
                    index = right;
                    left++;
                    break;
                }
                right--;
            }
            while (right >= left){
                if(array[left] > pivot){
                    array[right] = array[left];
                    index = left;
                    right--;
                    break;
                }
                left++;
            }
        }
        array[index] = pivot;
        return index;
    }

    public static void main(String[] args) {
        int[] array = new int[5];
        // int[] array = {28, 57, 62, 46, 43};
        Random r = new Random();
        for(int i = 0;i < array.length;i++){
            array[i] = r.nextInt(100);
        }

        System.err.println("before: "+ Arrays.toString(array));
        quickSort(array,0,array.length - 1);
        System.err.println("after: "+Arrays.toString(array));
    }

}
