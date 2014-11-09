package com.epam;

import java.util.Arrays;

public class MyArrayList<E> {

    private boolean isEmpty;
    private int sizeOfList;
    private E[] basicArray;

    public MyArrayList() {
        this(10);
    }

    public MyArrayList(int sizeOfList) {
        if (sizeOfList < 0) {
            throw new RuntimeException("Size of collection can't be negative");
        }
        basicArray = (E[]) new Object[sizeOfList];
    }

    public int sizeOfList() {
        return sizeOfList;
    }

    public boolean isEmpty() {
        return basicArray.length == 0;
    }

    public void add(E element) {
        if (isHasFreeCells(sizeOfList+1)) {
            int newSize = (sizeOfList * 3) / 2 + 1;
            basicArray = Arrays.copyOf(basicArray, newSize);
        } else {
        throw new IndexOutOfBoundsException("List is full. Impossible to add new element");
    }
        basicArray[sizeOfList++] = element;
    }

    public void add(E element, int index){
        if (isHasFreeCells(sizeOfList+1)) {
            System.arraycopy(basicArray, index, basicArray, index + 1,
                    sizeOfList - index);
            basicArray[index] = element;
            sizeOfList++;
        } else {
            throw new IndexOutOfBoundsException("List is full. Impossible to add new element");
        }
    }

    public boolean isHasFreeCells(int newSize){
        return true ? basicArray.length>=newSize : false;
    }

    public E getElement(int index) {
        return basicArray[index];
    }

    public int getIndex(E element) {
        int result = -1;
        for (int i = 0; i < basicArray.length; i++) {
            if (basicArray[i].equals(element)) {
                result = i;
            }
        }
        return result;
    }

    public void setElement(int index, E value) {
        basicArray[index] = value;
    }


    void remove(int index) {
        if (index > sizeOfList) {
            throw new RuntimeException("Index out of list's bounds");
        }
        int elemToCopy = sizeOfList - index - 1;
        if (elemToCopy > 0)
            System.arraycopy(basicArray, index+1, basicArray, index,
                    elemToCopy);
        basicArray[--sizeOfList] = null;
    }

    void clear() {
        for (int i = 0; i < sizeOfList; i++) {
            basicArray[i] = null;
        }
    }

}
