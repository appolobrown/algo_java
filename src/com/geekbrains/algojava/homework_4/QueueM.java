package com.geekbrains.algojava.homework_4;

import java.util.LinkedList;

public class QueueM<T> extends BaseClass {
    private LinkedList<T> queue;

    public QueueM() {
        this.queue = new LinkedList<>();
    }

    public void insert(T object) {
        if (queue.size() == 0) {
            queue.addFirst(object);
        } else {
            queue.add(object);
        }
    }

    public T remove() {
        T temp = this.queue.getFirst();
        this.queue.removeFirst();
        return temp;
    }

    public T peek() {
        return this.queue.getFirst();
    }

    public Boolean isEmpty() {
        return this.queue.size() == 0;
    }

    public int size() {
        return this.queue.size();
    }

    public void print() {
        for (T t : this.queue) {
            System.out.println("Element in queue: " + t);
        }
    }

}
