package com.company;

public class LinkedList<T> {
    private Node head;
    private Node tail;
    private int listCount;

    public LinkedList() {
        listCount = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node cur = head;
        int i = 0;
        while (cur != null) {
            if (i++ > 0) {
                sb.append(", ");
            }
            sb.append(cur.data);
            cur = cur.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public void add(T data) {
        if (tail == null) {
            // special case for first item
            head = new Node(data);
            tail = head;
        } else {
            tail.next = new Node(data);
            tail = tail.next;
        }
        listCount++;
    }

    public T get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        if (index >= size()) {
            throw new IndexOutOfBoundsException("index=" + index + ", size = " + size());
        }

        Node current = head;
        for (int i = 1; i < index; i++) {
            if (current.next == null) {
                return null;
            }
            current = current.next;
        }
        return current.data;
    }

    public int size() {
        return listCount;
    }

    public boolean remove(T a) {
        Node prev = null;
        Node victim = head;
//        Node tail =


        while (victim != null) {
            if (a.equals(victim.data)) {
                if (prev == null) {
                    //special case for a list containing exactly one item
                    head = null;
                    tail = null;
                } else {
                    prev.next = victim.next;
                    if (prev.next == null) {
                        // special case: we just removed the last item, so update tail
                        // TODO this needs a unit test
                        tail = prev;
                    }
                }
                listCount--;

                return true;
            }
            prev = victim;
            victim = victim.next;
        }

        return false;
    }

    public boolean contains(T a) {
        Node current = head;

        while (current != null) {
            if (a.equals(current.data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public T remove(int index) {
        // TODO update the tail reference

        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            Node temp = head;
            head = head.next;
            temp.next = null;
            listCount--;
            return temp.data;
        }

        if (index > 0) {
            Node prev = head;
            Node victim = head.next;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
                victim = victim.next;

                if (prev.next == null) {
                    // special case: we just removed the last item, so update tail
                    // TODO this needs a unit test
                    tail = prev;
                }
            }

        }
        return null;
    }

    public void clear() {
        head = null;
        tail = null;
        listCount = 0;
    }


    private class Node {
        Node next;
        T data;

        public Node(T dataValue) {
            next = null;
            data = dataValue;
        }
    }
}
