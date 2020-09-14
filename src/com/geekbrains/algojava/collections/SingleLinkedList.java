package com.geekbrains.algojava.collections;

public class SingleLinkedList<T> {
    private Link<T> first;

    public SingleLinkedList() {
        first = null;
    }

    public Boolean isEmpty() {
        return first == null;
    }

    public void insert(T link) {
        Link<T> l = new Link<>(link);
        l.setNext(first);
        first = l;
    }

    public Link<T> delete() {
        Link<T> temp = first;
        first = first.getNext();
        return temp;
    }

    public void print() {
        Link<T> current = first;
        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }

    public Link<T> find(T searchValue) {
        Link<T> findNode = new Link<>(searchValue);
        Link<T> current = first;
        while (current != null) {
            if (current.getValue().equals(findNode.getValue())) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }


    class Link<T> {
        private final T value;
        private Link<T> next;

        public Link(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public Link<T> getNext() {
            return next;
        }

        public void setNext(Link<T> next) {
            this.next = next;
        }
    }
}
