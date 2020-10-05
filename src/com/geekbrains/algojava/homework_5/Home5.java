package com.geekbrains.algojava.homework_5;

import com.geekbrains.algojava.homework_4.BaseClass;

public class Home5 extends BaseClass {
    /*
     * Задание 5.1
     * Приведите пример использования рекурсии: используется по большей части в математичке.
     * Примеры:
     *  - расчет факторила
     *  - числа Фибоначчи
     */

    private int infinityCountUp(int n) {
        System.out.println(n);
        return infinityCountUp(n);
    }

    private int fixedCountUp(int n) {
        System.out.println(n);
        return n == 0 ? 0 : fixedCountUp(n);
    }

    public void subtask_2() {
        System.out.println("Задание 5.2\n" +
                " * Реализуйте простой пример бесконечной рекурсии и обычной рекурсии\n" +
                " * с условием для выхода.");
        infinityCountUp(10);
        fixedCountUp(10);
    }

    public void subtask_3() {
        System.out.println("Задание 5.3\n" +
                " * Приведите пример изображающий стек вызова и стек вызова с\n" +
                " * рекурсией.\n" +
                " ");
    }

    private int exponentiation(int initValue, int expon) {
        initValue = initValue * initValue;
        expon--;
        return (expon != 0) ? exponentiation(initValue, expon) : initValue;
    }

    public void subtask_4() {
        System.out.println("Задание 5.4\n" +
                " * Реализуйте простой алгоритм использующий цикл и простой алгоритм\n" +
                " * использующий рекурсию.\n" +
                " * Оцените два алгоритма с помощью базового метода System.nanoTime().");
        // цикл - влзведение в степень
        startTime = System.nanoTime();
        int exponentiation = 3;
        int initValue = 2;
        int multi = initValue;
        for (int i = 1; i < exponentiation; i++) {
            multi = multi * initValue;
        }
        endTime = System.nanoTime();
        printTimeExecution("Возведение в степень через цикл за ", startTime, endTime);

        //рекурсия
        startTime = System.nanoTime();
        System.out.println("Результат через рекурсию: " + exponentiation(initValue, exponentiation));
        endTime = System.nanoTime();
        printTimeExecution("Возведение в степень через рекурсию за ", startTime, endTime);
    }

    public void subtask_5() {
        System.out.println("Задание 5.5\n" +
                " * Реализуйте алгоритм двоичного рекурсивного поиска на основе\n" +
                " * массива из задания 2.1.\n" +
                " * Оцените алгоритм двоичного рекурсивного поиска с помощью\n" +
                " * базового метода System.nanoTime() и сравните с обычным двоичным\n" +
                " * поиском.");
        Task2 task2 = new Task2();
        int[] arr = task2.getArrayOfRandomIntegers(5);
        Arrays.sort(arr);
        System.out.println("Отсортированный массив: " + Arrays.toString(arr));
        startTime = System.nanoTime();
        int foundIndex = recBinarySearch(3, 0, arr.length, arr);
        endTime = System.nanoTime();
        System.out.println("Найденный индекс: " + foundIndex);
        printTimeExecution("алгоритм двоичного рекурсивного поиска: ", startTime, endTime);
    }

    public int recBinarySearch(int searchValue, int low, int max, int[] arr) {
        if (low > max) return arr.length;

        int mid = (low + max) / 2;

        if (arr[mid] == searchValue) return mid;

        return (searchValue > arr[mid])
                ? recBinarySearch(searchValue, mid, max - 1, arr)
                : recBinarySearch(searchValue, low + 1, mid, arr);
    }

    public void subtask_6() {
        System.out.println("Задание 5.6\n" +
                " * На основе массива из задания 2.1 реализуйте алгоритм сортировки\n" +
                " * слиянием.\n" +
                " * Оцените алгоритм сортировки слиянием с помощью базового метода\n" +
                " * System.nanoTime() и сравните с сортировкой методом sort().");
        Task2 task2 = new Task2();
        int[] arr = task2.getArrayOfRandomIntegers(5);
        System.out.println("Первоначальный массив: " + Arrays.toString(arr));
        startTime = System.nanoTime();
        int[] sortedArr = sortMerge(arr);
        endTime = System.nanoTime();
        System.out.println("Отсортированный массив: " + Arrays.toString(sortedArr));
        printTimeExecution("Сортировка слиянием: ", startTime, endTime);
    }

    public static int[] sortMerge(int[] arr) {
        final int length = arr.length;
        if (length < 2) return arr;
        int mid = length / 2;
        final int[] a = Arrays.copyOfRange(arr, 0, mid);
        final int[] b = Arrays.copyOfRange(arr, mid, length);
        return merge(sortMerge(a), sortMerge(b));
    }

    public static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;

        for (int i = 0; i < result.length; i++) {
            result[i] = a[aIndex] < b[bIndex] ? a[aIndex++] : b[bIndex++];
            if (aIndex == a.length) {
                System.arraycopy(b, bIndex, result, ++i, b.length - bIndex);
                break;
            }
            if (bIndex == b.length) {
                System.arraycopy(a, aIndex, result, ++i, a.length - aIndex);
                break;
            }
        }

        return result;
    }

}
