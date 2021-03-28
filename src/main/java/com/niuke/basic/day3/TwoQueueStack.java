package com.niuke.basic.day3;

import java.util.Queue;

public class TwoQueueStack {
    private Queue<Integer> data;
    private Queue<Integer> help;

    public Integer peek(){
        if (data.size() == 0){
            throw new RuntimeException("Stack is empty!");
        }
        while (data.size() > 1){
            help.add(data.poll());
        }
        Integer res = data.poll();
        help.add(res);
        swap();
        return res;
    }

    public void push(int num){
        data.add(num);
    }

    public Integer pop(){
        if (data.size() == 0){
            throw new RuntimeException("Stack is empty!");
        }
        while (data.size() > 1){
            help.add(data.poll());
        }
        Integer res = data.poll();
        swap();
        return res;
    }

    public void swap(){
        Queue<Integer> tmp = data;
        data = help;
        help = tmp;
    }
 }
