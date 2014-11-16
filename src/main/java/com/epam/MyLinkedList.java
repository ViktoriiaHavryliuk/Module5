package com.epam;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements MyList<T> {

    private Node<T> first = null;
    private Node<T> last = null;

    public MyLinkedList() {
        first.next = first.prev = first;
    }

    @Override
    public void addFirst(T element) {
        Node newNode = new Node<T>(element, null, null);
        if (first == null) {
            first = last = newNode;
        } else {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
    }

    @Override
    public void addLast(T element) {
        Node newNode = new Node<T>(element, null, null);
        if (first == null) {
            addFirst(element);
        } else {
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        }
    }

    @Override
    public void addAfter(T element, T newElement) {
        Node current = first;
        while (current.value != element) {
            current = current.next;
            if (current == null) {
                throw new NoSuchElementException();
            }
        }
        Node newNode = new Node<T>(newElement, null, null);
        if (current == last) {
            addLast(newElement);
        } else {
            newNode.next = current.next;
            current.next.prev = newNode;
        }
        newNode.prev = current;
        current.next = newNode;
    }

    @Override
    public void remove(T element) {
        Node current = first;
        while (current.value != element) {
            current = current.next;
            if (current == null) {
                throw new NoSuchElementException();
            }
        }
        if (current == first) {
            first = current.next;
        } else {
            current.prev.next = current.next;
        }
        if (current == last) {
            last = current.prev;
        } else {
            current.next.prev = current.prev;
        }
    }

    @Override
    public void clear() {
        Node current = first;
        while (current != null) {
            current.prev = null;
            current.next = null;
            current.value = null;
            current = current.next;
        }
        first = last = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return last != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = last.value;
                last = last.next;
                return value;
            }

            @Override
            public void remove() {

            }
        };
    }
    class Node<T> {
        public T value;
        public Node<T> next;
        public Node<T> prev;

        Node(T value, Node<T> prev, Node<T> next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
