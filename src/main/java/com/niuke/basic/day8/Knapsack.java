package com.niuke.basic.day8;

public class Knapsack {

    public static int process1(int[] weights, int[] values, int i, int w, int v) {
        if (i == weights.length || w-weights[i]<0){
            return v;
        }
        int v1 = process1(weights,values,i+1,w,v);
        int v2 = process1(weights,values,i+1,w-weights[i],v+values[i]);
        return Math.max(v1,v2);
    }

    public static int process2(int[] weights, int[] values,int w){
        return 0;

    }



    public static void main(String[] args) {
        int[] weights = {1,1,1,1,5};
        int[] values = {1,1,1,1,5};
        System.out.println(process1(weights,values,0,6,0));
    }
}
