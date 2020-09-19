package com.geekbrains.algojava.collections;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    public LinkedList() {
        first = null;
    }

    public int size() {
        return size;
    }

    public Boolean isEmpty() {
        return first == null;
    }

    public void add(T link) {
        Node<T> l = last;
        Node<T> newNode = new Node<>(link, null, last);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.setNext(newNode);
        }
        size++;
    }

    public void remove() {
        last = last.getPrev();
    }

    public void print() {
        Node<T> current = first;
        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }

    public Boolean contains(T searchValue) {
        Node<T> current = first;
        while (current != null) {
            if (current.getValue().equals(searchValue)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void addFirst(T node) {
        Node<T> f = first;
        Node<T> l = last;
        Node<T> newNode = new Node(node, f, null);
        first = newNode;
        f.setPrev(newNode);
        last = f;
    }

    public Node<T> peekLast() {
        return last;
    }

    public Node<T> pollLast() {
        Node<T> l = last;
        remove();
        return l;
    }


    class Node<T> {
        private final T value;
        private Node<T> next;
        private Node<T> prev;

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public Node(T value, Node<T> next, Node<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

    }

    public ListIterator<T> listIterator() {
        return new ListItr();
    }

    class ListItr implements ListIterator<T> {
        private Node<T> lastReturned;
        private Node<T> next;
        private int nextIndex;

        public ListItr() {
            next = null;
            nextIndex = 0;
        }

        public boolean hasNext() {
            return nextIndex < size;
        }

        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        public T next() {
            //todo: need debug
            if (!hasNext())
                throw new NoSuchElementException();

            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.value;
        }

        public T previous() {
            //todo: need debug
            if (!hasPrevious()) throw new NoSuchElementException();

            lastReturned = next = (next == null) ? last : next.prev;
            nextIndex--;
            return lastReturned.value;
        }

        public int nextIndex() {
            if (hasNext()) nextIndex++;
            return nextIndex;
        }

        public int previousIndex() {
            if (hasPrevious()) nextIndex--;
            return nextIndex;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(T t) {

        }

        @Override
        public void add(T t) {

        }
    }
}
