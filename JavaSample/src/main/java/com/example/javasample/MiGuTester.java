package com.example.javasample;

import java.util.Arrays;

public class MiGuTester {

    public static void main(String[] args) {

        // 申明一个栈数组, 用于保存每次打靶的靶数
        int[] stack = new int[10];

        // 最佳靶数
        int max_value = 10;
        int min_value = 0;

        int time = 0;

        int score = 90;
        long start  = System.currentTimeMillis();
        int count = calc_fun(score, stack,max_value,min_value,time);
        System.out.println("count: "+count + " // time: "+(System.currentTimeMillis() - start));
        // 184756 // time: 2329
    }


    private static int calc_fun(int score, int[] stack, int max_v, int min_v, int time){
        final int stack_max_index = stack.length - 1;
        int count = 0;
        for (int i = 0; i <= max_v - min_v; i++) {
            stack[time] = min_v + i;
            if(time == stack_max_index){
                int sum = calcSumValue(stack);
                if(sum >= score){
                    System.out.println(sum + " // " + Arrays.toString(stack));
                    count ++;
                }
            }else {
                int sum = calcPrefectValue(stack,time,max_v);
                if(sum >= score){
                    count += calc_fun(score, stack, max_v, min_v,  time + 1);
                }
            }
        }
        return count;
    }

    private static int calcPrefectValue(int[] stack, int curIndex, int max_v){
        int sum = 0;
        for (int i = 0; i <= curIndex; i++) {
            sum += stack[i];
        }
        sum += (stack.length - 1 - curIndex) * max_v;
        return sum;
    }

    private static int calcSumValue(int[] stack){
        int sum = 0;
        for (int i = 0; i <= stack.length - 1; i++) {
            sum += stack[i];
        }
        return sum;
    }
}
