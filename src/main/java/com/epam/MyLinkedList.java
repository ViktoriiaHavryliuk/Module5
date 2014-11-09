package com.epam;

public class MyLinkedList<E> {

    private E[] basicArray;


    public Node generateLinkedList(E... value) {
        Node tail = null;
        for (int i = basicArray.length-1; i>=0;i--) {
            tail = new Node(basicArray[i], tail);
        }
        return tail;
    }

    public Node addLast(Node tail, E element){
        if (tail != null){
            return new Node(element,tail);
        }
        return tail;
    }

    public Node insert(Node tail, int index, E value){
        return new Node (value, tail);
    }

    public Node removeLast(Node tail){
        while (tail != null){
            tail = tail.next;
            //if ()
        }
      return /*new Node(value, tail)*/null;
    }
    class Node{
        public E value;
        public Node next;

        Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }

    }


}
