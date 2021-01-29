package LinkedList;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.addLast(12);
        l1.addLast(13);
        l1.addLast(14);
        l1.addLast(15);
        l1.addLast(16);
        l1.addLast(17);
//        System.out.println(l1.size);
        l1.displayLinkedList();
    }

    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        void displayLinkedList(){
            Node temp = head;
            while(temp!=  null){
                System.out.println(temp.data);
                temp=temp.next;
            }
            System.out.println("Size of the LL = "+size);
        }

        void addLast(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;
            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp; //jodna
                tail = temp;// tail update karna
            }
            size++;

        }
    }
}
