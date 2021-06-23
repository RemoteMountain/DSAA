package com.niuke.practice.basic.day3;

import java.util.Stack;

public class RecurReverseStack {

    public static Integer getAndRemoveLastElemet(Stack<Integer> stack){
        if (stack.isEmpty()){
            return null;
        }
        Integer result = stack.pop();
        if (stack.isEmpty()){
            return result;
        }else {
            Integer last = getAndRemoveLastElemet(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }
        Integer i = getAndRemoveLastElemet(stack);
        reverse(stack);
        stack.push(i);
    }
}
