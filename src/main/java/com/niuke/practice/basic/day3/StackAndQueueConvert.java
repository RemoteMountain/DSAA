package com.niuke.practice.basic.day3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueueConvert {

    public static class TwoStackQueue {
        private Stack<Integer> pushStack;
        private Stack<Integer> popStack;

        public TwoStackQueue() {
            pushStack = new Stack<Integer>();
            popStack = new Stack<Integer>();
        }

        public void push(int value) {
            pushStack.push(value);
        }

        public Integer pop() {
            return 0;
        }

        public Integer peek() {
            return 0;
        }

    }

    public static class TwoQueueStack {
        private Queue<Integer> dataQueue;
        private Queue<Integer> helpQueue;

        public TwoQueueStack() {
            dataQueue = new LinkedList<Integer>();
            helpQueue = new LinkedList<Integer>();
        }

        public void push(int value) {
            dataQueue.add(value);
        }

        public Integer pop() {
            return 0;
        }

        public Integer peek() {
            return 0;
        }

        private void swap() {
            Queue<Integer> tmpQueue = helpQueue;
            helpQueue = dataQueue;
            dataQueue = tmpQueue;
        }

    }
}
