package meettooffer.chapter3;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

public class FindKthToTail {
    public static void main(String[] args) {
        int k = 2;
        int length = 10;
        Node nodeList = generateNode(length);
        Node n = findKthToTail(nodeList, k);
        if (n != null) {
            System.out.println(n.toString());
        } else {
            System.out.println("null");
        }
    }

    private static Node generateNode(int length) {
        Node nodeList = new Node(0);
        Node p = nodeList;
        for (int i = 1; i < length; i++) {
            Node node = new Node(i);
            p.next = node;
            p = p.next;
        }
        return nodeList;
    }

    public static Node findKthToTail(Node nodeList, int k) {
        if (nodeList == null) {
            return null;
        }
        Node node = nodeList;
        for (int i = 0; i < k - 1; i++) {
            if (node.next == null) {
                return null;
            } else {
                node = node.next;
            }
        }
        if (node == null) {
            return null;
        }
        Node point = nodeList;
        while (node.next != null) {
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

