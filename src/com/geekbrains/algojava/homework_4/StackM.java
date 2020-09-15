package com.geekbrains.algojava.homework_4;

import java.util.ArrayList;

public class StackM<T> extends BaseClass {
    private final int maxSize;
    private final ArrayList<T> stack;
    private int top;
    final int initialValue = -1;

    public StackM(int maxSize) {
        this.maxSize = maxSize;
        this.top = initialValue;
        this.stack = new ArrayList<>();
    }

    public void push(T object) {
        startTime = System.nanoTime();
        this.stack.add(++this.top, object);
        endTime = System.nanoTime();
        printTimeExecution("StackM.push(): ", startTime, endTime);
    }

    public void pop() {
        startTime = System.nanoTime();
        this.stack.remove(this.top--);
        endTime = System.nanoTime();
        printTimeExecution("StackM.pop(): ", startTime, endTime);
    }

    public T peek() {
        startTime = System.nanoTime();
        T current = this.stack.get(this.top);
        endTime = System.nanoTime();
        printTimeExecution("StackM.peek(): ", startTime, endTime);
        return current;
    }

    public Boolean isEmpty() {
        return this.top == initialValue;
    }

    public Boolean isFull() {
        return this.maxSize == this.top;
    }

}
