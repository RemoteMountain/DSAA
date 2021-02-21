package com.niuke.day3;

/*数组实现栈*/
public class ArrayStack {
    private Integer[] arr;
    private Integer size;

    public ArrayStack(int initSize) {
        if (initSize < 0) {
            throw new RuntimeException("The init size is less than 0");
        }
        arr = new Integer[initSize];
        size = 0;
    }



    /*返回栈顶元素*/
    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return arr[size - 1];
    }

    public void push(int obj) {
        if (size == arr.length) {
            throw new ArrayIndexOutOfBoundsException("The stack is full");
        }
        arr[size++] = obj;

    }

    public Integer pop() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("The stack is empty");
        }
        return arr[--size];
    }

    public Boolean isEmpty(){
        return size == 0;
    }


}
