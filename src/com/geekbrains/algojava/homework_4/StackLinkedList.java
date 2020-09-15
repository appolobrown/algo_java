package com.geekbrains.algojava.homework_4;

import java.util.Iterator;
import java.util.LinkedList;

public class StackLinkedList<T> extends BaseClass {
    private final LinkedList<T> stack;

    public Iterator<T> iterator() {
        return this.stack.iterator();
    }

    public StackLinkedList() {
        this.stack = new LinkedList<>();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(T object: stack) {
            str.append(object.toString()).append("\n");
        }
        return str.toString();
    }

    public void push(T object) {
        startTime = System.nanoTime();
        this.stack.add(object);
        endTime = System.nanoTime();
        printTimeExecution("StackM.push(): ", startTime, endTime);
    }

    public void pop() {
        startTime = System.nanoTime();
        this.stack.remove();
        endTime = System.nanoTime();
        printTimeExecution("StackM.pop(): ", startTime, endTime);
    }

    public T peek() {
        startTime = System.nanoTime();
        T current = this.stack.peek();
        endTime = System.nanoTime();
        printTimeExecution("StackM.peek(): ", startTime, endTime);
        return current;
    }

    public Boolean isEmpty() {
        return this.stack.size() == 0;
    }

}

