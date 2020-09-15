package com.geekbrains.algojava.homework_4;

import java.util.Comparator;

public class ArrayObjComparator implements Comparator<ArrayObj> {
    @Override
    public int compare(ArrayObj o1, ArrayObj o2) {
        return o1.getEl() > o2.getEl() ? 0 : 1;
    }
}
