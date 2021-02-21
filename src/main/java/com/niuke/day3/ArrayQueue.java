package com.niuke.day3;

public class ArrayQueue {
    private Integer[] arr;
    private Integer size;
    private Integer start;
    private Integer end;

    public ArrayQueue(Integer initSize) {
        if (initSize < 0) {
            throw new RuntimeException("The init size is less than 0");
        }
        arr = new Integer[initSize];
        start = 0;
        end = 0;
        size = 0;
    }

    public Integer peek(){
        if (size == 0){
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        return arr[start];
    }

    public void push(Integer num) {
        if (size == arr.length) {
            throw new ArrayIndexOutOfBoundsException("The queue is full");
        }
        size++;
        arr[end] = num;
        end = end == arr.length - 1 ? 0 : end + 1;
    }

    public Integer poll(){
        if (size == 0){
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        size--;
        int tmp = start;
        start = start == arr.length - 1 ? 0 : start + 1;
        return arr[tmp];
    }
}
