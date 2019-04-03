package meettooffer.chapter4;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public class ComplexListCopy {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        head.sibling = third;
        second.sibling = fifth;
        fourth.sibling = second;
        Node result = complexListCopy(head);
        System.out.println("-------------");
        print(result);
    }
    private static Node complexListCopy(Node head) {
        Node point = head;
        if (point == null) {
            return null;
        }
        while (point != null) {
            Node newNode = new Node(point.value);
            newNode.next = point.next;
            point.next = newNode;
            point = newNode.next;
        }
        print(head);
        return splitList(head);
    }
    private static void print(Node head) {
        while (head != null) {
            System.out.println(head.value + " --- " + (head.sibling == null ? " " : head.sibling.value));
            head = head.next;
        }
    }
    private static Node splitList(Node head) {
        Node point = head, newPoint = head.next, newHead = head.next;
        while (true) {
            if (point.sibling != null) {
                newPoint.sibling = point.sibling.next;
            }
            point = point.next.next;
            if (newPoint.next != null) {
                newPoint.next = newPoint.next.next;
                newPoint = newPoint.next;
            } else {
                break;
            }
        }
        return newHead;
    }
    @RequiredArgsConstructor
    static class Node {
        @NonNull Integer value;
        Node next;
        Node sibling;
    }
}
