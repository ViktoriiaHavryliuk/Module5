package com.epam;

import java.util.Iterator;

public interface MyList<T> {

    void addFirst(T element);
    void addLast(T element);
    void addAfter(T element, T newElement);
    void remove(T element);
    void clear();
    Iterator<T> iterator();

}
