package com.geekbrains.algojava.hash;

class Item {
    private final int data;

    public Item(int data) {
        this.data = data;
    }

    public int getKey() {
        return this.data;
    }
}
