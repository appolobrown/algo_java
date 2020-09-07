package com.geekbrains.algojava;

import java.util.Arrays;
import java.util.Random;

/**
 * Задание 2.1
 * На основе программного кода из домашнего задания №1 реализуйте массив на основе существующих примитивных или ссылочных типов данных.
 * Выполните обращение к массиву и базовые операции класса Arrays.
 * Оценить выполненные методы с помощью базового класса System.nanoTime().
 * Задание 2.2
 * На основе написанного кода в задании 2.1 реализуйте линейный и двоичный поиск.
 * Оценить алгоритмы линейного и двоичного поиска с помощью базового класса System.nanoTime(), при необходимости расширьте уже существующий массив данных.
 * Задание 2.3
 * <p>
 * Создайте массив размером 400 элементов.
 * Выполните сортировку с помощью метода sort().
 * Оцените сортировку с помощью базового класса System.nanoTime().
 * Задание 2.4
 * На основе существующего массива данных из задания 2.3 реализуйте алгоритм сортировки пузырьком.
 * Оцените сортировку с помощью базового класса System.nanoTime().
 * Сравните время выполнения алгоритмы сортировки методом sort() из задания 2.1 и сортировку пузырьком.
 * Задание 2.5
 * На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом выбора.
 * Оцените сортировку с помощью базового класса System.nanoTime().
 * Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3 и 2.4.
 * Задание 2.6
 * На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом вставки.
 * Оцените сортировку с помощью базового класса System.nanoTime().
 * Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3, 2.4 и 2.5.
 */

public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 2, 3, 58, 0, 6};
        task1(arr);
        task2(arr);
        int[] array = getInts(400);
        task3(array);
        task4(getInts(400));
        task5(getInts(400));
        task6(getInts(400));
    }

    private static void task1(int[] primitiveArray) {
        System.out.println(primitiveArray.length);
        long before = System.nanoTime();
        int[] copy = Arrays.copyOf(primitiveArray, primitiveArray.length);
        long after = System.nanoTime();
        System.out.println("copy of array " + (after - before) + " nanos");
        before = System.nanoTime();
        Arrays.sort(copy);
        after = System.nanoTime();
        System.out.println("sort array " + (after - before) + " nanos");

    }

    private static void task2(int[] array) {
        Arrays.sort(array);

        long before = System.nanoTime();
        int foundIndex = linearSearch(5, array);
        long after = System.nanoTime();
        System.out.println("linear search " + (after - before) + " nanos");
        System.out.println(foundIndex);

        before = System.nanoTime();
        int foundIndex2 = binarySearch(5, array);
        after = System.nanoTime();
        System.out.println("binary search " + (after - before) + " nanos");
        System.out.println(foundIndex2);
    }

    private static int linearSearch(int whatFind, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == whatFind) return i;
        }
        return -1;
    }

    private static int binarySearch(int whatFind, int[] array) {
        int resultIndex = -1;
        int first = 0;
        int last = array.length - 1;
        int mid = (last + first) / 2;
        while (first <= last) {
            if (array[mid] < whatFind) {
                first = mid + 1;
            } else if (array[mid] == whatFind) {
                resultIndex = mid;
                break;
            } else {
                last = mid - 1;
            }
            mid = (first + last) / 2;

        }
        return resultIndex;
    }

    private static void task3(int[] array) {
        long before = System.nanoTime();
        Arrays.sort(array);
        long after = System.nanoTime();
        System.out.println("sort of 400  " + (after - before) + " nanos");
    }

    private static int[] getInts(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    private static void task4(int[] array) {
        long before = System.nanoTime();
        int n = array.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
        long after = System.nanoTime();
        System.out.println("bubble sort of 400  " + (after - before) + " nanos");
    }

    private static void task5(int[] arr) {
        long before = System.nanoTime();
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;//searching for lowest index
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        long after = System.nanoTime();
        System.out.println("select sort of 400  " + (after - before) + " nanos");
    }

    private static void task6(int[] array) {
        long before = System.nanoTime();
        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j - 1;
            while ((i > -1) && (array[i] > key)) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
        long after = System.nanoTime();
        System.out.println("insert sort of 400  " + (after - before) + " nanos");
    }
}
