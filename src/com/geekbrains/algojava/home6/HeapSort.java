package com.geekbrains.algojava.home6;

public class HeapSort {

    private static int heapSize;

    public void sort(int[] a) {
        buildHeap(a);
        while (heapSize > 1) {
            swap(a, 0, heapSize - 1);
            heapSize--;
            heapify(a, 0);
        }
    }

    private static void buildHeap(int[] a) {
        heapSize = a.length;
        for (int i = a.length / 2; i >=0; i--) {
            heapify(a, i);
        }
    }

    private static void heapify(int[] a, int index) {
        int l = left(index);
        int r = right(index);
        int largest = index;
        if (l < heapSize && a[largest] < a[l]) {
            largest = l;
        }
        if (r < heapSize && a[largest] < a[r]) {
            largest = r;
        }
        if (index != largest) {
            swap(a, index, largest);
            heapify(a, largest);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static int left(int i) {
        return i * 2 + 1;
    }

    private static int right(int i) {
        return i * 2 + 2;
    }
}
