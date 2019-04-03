package meettooffer.chapter3;

import java.util.StringJoiner;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


public class ReverseAndPrintTail {
    public static void main(String[] args) {
        Node linkNode = new Node(0);
        int length = 10;
        generateLink(linkNode, length);
        System.out.println(toString(linkNode));
        Node node = reverseLink(linkNode);
        System.out.println(toString(node));
    }
    private static String toString(Node node) {
        StringJoiner sj = new StringJoiner(",", "[", "]");
        while (node != null) {
            sj.add(node.toString());
            node = node.next;
        }
        return sj.toString();
    }
    private static Node reverseLink(Node linkNode) {
        if (linkNode == null) {
            return null;
        }
        if (linkNode.next == null) {
            return linkNode;
        }
        Node p = null;
        Node n = linkNode.next;
        while (true) {
            linkNode.next = p;
            p = linkNode;
            linkNode = n;
            if (n == null) {
                break;
            }
            n = n.next;
        }
        return p;
    }

    private static Node generateLink(Node linkNode, int length) {
        Node p = linkNode;
        for (int i = 1; i < length; i++) {
            Node node = new Node(i);
            p.next = node;
            p = p.next;
        }
        return linkNode;
    }
    
    @RequiredArgsConstructor
    @ToString(exclude = {"next"})
    static class Node {
        @NonNull Integer value;
        Node next;
    }
}
