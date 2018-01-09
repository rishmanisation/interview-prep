import java.util.*;

/*
 * Helper class for Chapter 2 problems. 
 */

public class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode<T>(int data) {
        this.data = data;
    }

    public LinkedListNode<T> addToFront(LinkedListNode<T> head, T data) {
        if(head == null) {
            head.data = data;
            return head;
        }

        LinkedListNode<T> newNode = new LinkedListNode<T>();
        newNode.data = data;
        newNode.next = head;
        return newNode;
    }

    public LinkedListNode<T> addToEnd(LinkedListNode<T> head, T data) {
        if(head == null) {
            head.data = data;
            return head;
        }

        LinkedListNode<T> curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }

        LinkedListNode<T> newNode = new LinkedListNode<T>();
        newNode.data = data;
        newNode.next = null;
        curr.next = newNode;
        return head;
    }

    public LinkedListNode<T> deleteNode(LinkedListNode<T> head, T data) {
        if(head == null) {
            return head;
        }

        if(head.data == data) {
            return head.next;
        }

        LinkedListNode<T> curr = head;
        while(curr.next != null) {
            if(curr.next.data == data) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }

        return head;
    }
}