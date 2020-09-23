package com.geekbrains.algojava.home6;

public class Task6 extends BaseClass {

    public void subtack_1() {
        System.out.println("Задания 6.1\n" +
                "    * Приведите пример использования древовидной структуры.\n" +
                "    * Родословная, структура HTML (DOM)\n");
    }

    public void subtask_2_3_4_5() {
        System.out.println("\nЗадание 6.2...6.5\n" +
                " * Реализуйте класс узла дерева и базовый шаблон дерева с базовыми\n" +
                " * методами.");
        Tree tree = new Tree();
        tree.insert(new Person(1, "Ivan"));
        tree.insert(new Person(4, "Victor"));
        tree.insert(new Person(3, "Alex"));
        tree.insert(new Person(5, "Alex"));

        tree.min().display();
        tree.max().display();

        tree.displayTree();
        tree.find(3).display();
        tree.find(1).display();

        tree.delete(2);

        tree.displayTree();
    }


    public void subtask_6() {
        int[] arr = initArray(10);
        System.out.println("Initial array: " + Arrays.toString(arr));

        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr);
        System.out.println("Heap sorted array: " + Arrays.toString(arr));
    }

    public void subtask_7() {
        System.out.println("\nЗадание 6.7\n" +
                " * Приведите пример сбалансированного дерева и его применения.\n" +
                " * Реализации для ассоциативных массивов в java, c++\n" +
                " * Используются, когда нужен быстрый поиск: " +
                " например, если необходим поиск по паттерну, в дереве можно хранить справчник паттернов.\n");

        Map<Integer, String> dictionary = new TreeMap<>();
        dictionary.put(7, "ru");
        dictionary.put(86, "сhina");
        dictionary.put(1, "usa");
        dictionary.put(52, "mexica");

        dictionary.entrySet().forEach(System.out::println);
    }

    public static void main(String[] args) {
        Task6 task6 = new Task6();
        task6.subtack_1();
        task6.subtask_2_3_4_5();
        task6.subtask_6();
        task6.subtask_7();
    }

}