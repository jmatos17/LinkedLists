package org.academiadecodigo.bootcamp.containers;

public class LinkedList <T>{

    private T t;

    public void set(T t) {this.t = t; }

    public T getT() {
        return t;
    }

    private Node head;
    private int length = 0;

    public LinkedList() {
        this.head = new Node(null);
    }

    public int size() {
        return length;
    }

    /**
     * Adds an element to the end of the list
     *
     * @param data the element to add
     */
    public void add(T data) {

        Node node = new Node(data);
        Node iterator = head;

        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
        }

        iterator.setNext(node);
        length++;

    }

    /**
     * Obtains an element by index
     *
     * @param index the index of the element
     * @return the element
     */
    public T get(int index) {
        Node iterator = head;
        int indexIterator = -1;

        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
            indexIterator++;

            if (indexIterator == index) {
                return (T) iterator.getData();
            }
        }
        return null;
    }

    /**
     * Returns the index of the element in the list
     *
     * @param data element to search for
     * @return the index of the element, or -1 if the list does not contain element
     */
    public int indexOf(T data) {
        Node iterator = head;
        int index = -1;
        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
            index++;
            if (iterator.getData() == data) {
                return index;
            }
        }
        return -1;
    }


    /**
     * Removes an element from the list
     *
     * @param data the element to remove
     * @return true if element was removed
     */
    public boolean remove(T data) {

        Node iteratorOne = head;
        Node iteratorTwo = head.getNext();

        while (iteratorOne.getNext() != null) {

            if (iteratorTwo.getData() == data) {
                iteratorOne.setNext(iteratorTwo.getNext());
                length--;
                return true;
            }
            iteratorOne = iteratorOne.getNext();
            iteratorTwo = iteratorTwo.getNext();
        }
        return false;
    }

    private class Node<T> {

        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            next = null;
        }

        public T getData() {
            return data;
        }

        public void setData (T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
