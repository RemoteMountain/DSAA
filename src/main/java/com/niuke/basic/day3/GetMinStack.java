package com.niuke.basic.day3;

public class GetMinStack {
    private ArrayStack data;
    private ArrayStack min;

    public GetMinStack(int initSize) {
        data = new ArrayStack(initSize);
        min = new ArrayStack(initSize);
    }

    public void push(int num) {
        if (min.isEmpty()) {
            min.push(num);
        } else if (num <= this.getMin()) {
            min.push(num);
        } else {
            min.push(this.getMin());
        }
        this.data.push(num);
    }

    public Integer pop() {
        if (min.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        this.min.pop();
        return this.data.pop();
    }

    public Integer getMin() {
        if (min.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        return min.peek();
    }
}
