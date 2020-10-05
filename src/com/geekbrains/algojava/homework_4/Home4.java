package com.geekbrains.algojava.homework_4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.PriorityQueue;

public class Home4  {
    private final int initialCapacity = 5;
    private ArrayList<ArrayObj> list = initList(initialCapacity);


    public void subtask_1() {
        System.out.println("Задание 4.1\n" +
                " * На основе данных объектного списка из задания 3.4 реализуйте\n" +
                " * простой стек и его базовые методы.\n" +
                " * Оцените время выполнения операций с помощью базового метода\n" +
                " * System.nanoTime().");
        System.out.println("Default java.util.Stack");
        StackM<ArrayObj> stackM = new StackM<>(initialCapacity);
        list.forEach(el -> {
            stackM.push(el);
            System.out.println("Peek is started for " + stackM.peek().toString());
        });

        System.out.println("Pop element...");
        while (!stackM.isEmpty()) {
            stackM.pop();
        }

        if (stackM.isEmpty()) System.out.println("Stack is empty");
    }

    public void subtask_2() {
        System.out.println("Задание 4.2\n" +
                " * На основе данных объектного списка из задания 3.4 реализуйте\n" +
                " * простую очередь и его базовые методы.\n" +
                " * Реализуйте вспомогательные методы.\n" +
                " * Оцените время выполнения операций с помощью базового метода\n" +
                " * System.nanoTime().");
        QueueM<ArrayObj> queueM = new QueueM<>();
        queueM.insert(new ArrayObj(1));
        queueM.insert(new ArrayObj(2));
        queueM.insert(new ArrayObj(3));
        queueM.print();
        queueM.remove();
        System.out.println("After removing first: ");
        queueM.print();

    }

    public void subtasj_3() {
        System.out.println("Задание 4.3\n" +
                " * На основе данных объектного списка из задания 3.4 реализуйте\n" +
                " * простой дек и его базовые методы.\n" +
                " * Оцените время выполнения операций с помощью базового метода\n" +
                " * System.nanoTime().");
        Deque<ArrayObj> deque = new ArrayDeque<>();
        deque.add(new ArrayObj(1));
        deque.add(new ArrayObj(2));
        deque.add(new ArrayObj(3));

        for (ArrayObj arrayObj : deque) {
            System.out.println("Deque element:" + arrayObj);
        }
        System.out.println("\nOfferFirst");
        deque.offerFirst(new ArrayObj(5));
        for (ArrayObj arrayObj : deque) {
            System.out.println("Deque element:" + arrayObj);
        }
    }

    public void subtask_4() {
        System.out.println("Задание 4.4\n" +
                " * Реализуйте приоритетную очередь на основе ссылочных типов данных,\n" +
                " * например, integer.\n" +
                " * Оцените время выполнения операций с помощью базового метода\n" +
                " * System.nanoTime().");
        PriorityQueue<ArrayObj> priorityQueue = new PriorityQueue<>(new ArrayObjComparator());
        priorityQueue.add(new ArrayObj(1));
        priorityQueue.add(new ArrayObj(2));
        priorityQueue.add(new ArrayObj(3));
        for (ArrayObj arrayObj : priorityQueue) {
            System.out.println("Prior queue: " + arrayObj);
        }

        System.out.println("Offer new one");
        priorityQueue.offer(new ArrayObj(1));
        priorityQueue.remove();
        for (ArrayObj arrayObj : priorityQueue) {
            System.out.println("Prior queue: " + arrayObj);
        }
    }

    public void subtask_5() {
        System.out.println("Задание 4.5\n" +
                " * На основе данных из задания 4.1 и 4.2, реализуйте стек и очередь на\n" +
                " * базе связанного списка.\n" +
                " * Оцените время выполнения операций с помощью базового метода\n" +
                " * System.nanoTime().");
        // 4.2 изначально реализовала с помощью LinkedList
        StackLinkedList<ArrayObj> stackLinkedList = new StackLinkedList<>();
        stackLinkedList.push(new ArrayObj(1));
        stackLinkedList.push(new ArrayObj(2));
        stackLinkedList.push(new ArrayObj(3));
        System.out.println("Initial stack \n" + stackLinkedList.toString());

        stackLinkedList.pop();
        System.out.println("Stack after pop() \n" + stackLinkedList.toString());
    }

}
