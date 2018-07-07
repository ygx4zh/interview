package com.example.javasample;



public class SortUtil {

    /**
     * 冒泡排序:
     *
     * 相邻的元素进行比较, 每次比对出来的最值排在最大索引
     *
     * @param array 数组
     */
    public static void bubbleSort(int[] array){
        if (array == null) {
            return;
        }

        int len = array.length;
        for (int i = len - 1; i > 2; i--) {
            for (int j = 0; j < i; j++) {
                if(array[j] > array[j + 1]){
                    swap(array, j + 1, j);
                }
            }
        }
    }

    /**
     * 选择排序:
     *
     * 第i个元素和第j个元素比对, 最小的元素保存到i位置
     *
     * @param array 数组
     */
    public static void selectSort(int[] array){
        if(array == null){
            return;
        }

        int len = array.length;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len; j++) {
                if(array[i] > array[j]){
                    swap(array, i, j);
                }
            }
        }
    }

    private static void swap(int[] array, int i1, int i2){
        int tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
    }
}
