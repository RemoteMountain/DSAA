package com.niuke.practice.basic.day3;

/**
 * 数组实现栈和队列
 */
public class Array_To_Stack_Queue {

    public class ArrayStack {
        private Integer[] arr;
        private Integer size;

        public ArrayStack(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            size = 0;
        }

        /**
         * 入栈
         *
         * @param value
         */
        public void push(int value) {

        }

        /**
         * 出栈
         *
         * @return
         */
        public Integer pop() {
            return null;
        }

        /**
         * 仅返回栈顶
         *
         * @return
         */
        public Integer peek() {
            return null;
        }
    }

    public class ArrayQueue {
        private Integer[] arr;
        private Integer size;
        private Integer first;
        private Integer last;

        public ArrayQueue(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            size = 0;
            first = 0;
            last = 0;
        }

        /**
         * 入队
         *
         * @param value
         */
        public void push(int value) {

        }

        /**
         * 出队
         *
         * @return
         */
        public Integer poll() {
            return null;
        }

        public Integer peek() {
            return null;
        }
    }
}
