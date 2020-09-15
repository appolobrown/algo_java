package com.geekbrains.algojava.homework_4;

public class ArrayObj {
    private final int el;

    public int getEl() {
        return el;
    }

    @Override
    public String toString() {
        return "ArrayObj{" +
                "el=" + el +
                '}';
    }

    public ArrayObj(int el) {
        this.el = el;
    }
}
