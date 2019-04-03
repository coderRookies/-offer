package meettooffer.chapter3;

import java.util.Objects;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

public class MeetingNode {
    public static void main(String[] args) {
        Node linkNode = new Node(0);
        generateLoop(linkNode, 10, 2);
        Node entry = meetingNode(linkNode);
        System.out.println(Objects.toString(entry, "null"));
    }

    private static void generateLoop(Node linkNode, int length, int entry) {
        if (length < entry) {
            return;
        }
        Node entryNode = null, tail = linkNode;
        for (int i = 1; i < length; i++) {
            Node node = new Node(i);
            tail.next = node;
            tail = tail.next;
            if (i == entry) {
                entryNode = node;
            }
        }
        tail.next = entryNode;
    }

    private static Node meetingNode(Node linkNode) {
        if (linkNode == null) {
            return null;
        }
        Node f = linkNode, s = linkNode;
        int count = 1;
        while (true) {
            if (f.next == null || f.next.next == null) {
                return null;
            }
            s = s.next;
            f = f.next.next;
            count ++;
            if (f == s) {
                break;
            }
        }
        return findNode(linkNode, count);
    }
    
    private static Node findNode(Node linkNode, int count) {
        Node node = linkNode;
        for (int i = 0; i < count - 1; i++) {
            node = node.next;
        }
        Node point = linkNode;
        while (node != point) {
            point = point.next;
            node = node.next;
        }
        return point;
    }

    @RequiredArgsConstructor
    @ToString(exclude = {"next"})
    static class Node {
        @NonNull Integer value;
        Node next;
    }
}