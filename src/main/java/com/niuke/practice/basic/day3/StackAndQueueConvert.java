package com.niuke.practice.basic.day3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueueConvert {

    public static class TwoStackQueue {
        private Stack<Integer> push;
        private Stack<Integer> pop;

        public TwoStackQueue() {
            push = new Stack<Integer>();
            pop = new Stack<Integer>();
        }

        public void push(int value){

        }

        public Integer pop(){
            return null;
        }

        public Integer peek(){
            return null;
        }

    }

    public static class TwoQueueStack {
        private Queue<Integer> data;
        private Queue<Integer> help;

        public TwoQueueStack() {
            data = new LinkedList<Integer>();
            help = new LinkedList<Integer>();
        }

        public void push(int value) {
        }

        public Integer pop() {
            return null;
        }

        public Integer peek() {
            return null;
        }

        private void swap() {
            Queue<Integer> tmp = help;
            help = data;
            data = tmp;
        }

    }
}
