package meettooffer.chapter3;

import java.util.StringJoiner;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

public class MergeLink {
    public static void main(String[] args) {
        int step = 2;
        Node link1 = generateLink(1, step, 7);
        Node link2 = generateLink(2, step, 3);
        Node resultNode = mergeLink(link1, link2);
        System.out.println(toString(resultNode));
        
    }
    
    private static String toString(Node resultNode) {
        StringJoiner sjJoiner = new StringJoiner(",", "[", "]");
        while (resultNode != null) {
            sjJoiner.add(resultNode.toString());
            resultNode = resultNode.next;
        }
        return sjJoiner.toString();
    }

    private static Node mergeLink(Node link1, Node link2) {
        if (link1 == null) {
            return link2;
        } 
        if (link2 == null) {
            return link1;
        }
        Node result;
        if (link1.value <= link2.value) {
            result = link1;
            link1 = link1.next;
        } else {
            result = link2;
            link2 = link2.next;
        }
        result.next = mergeLink(link1, link2);
        return result;
    }

    private static Node generateLink(int s, int step, int length) {
        Node node = new Node(s);
        Node p = node;
        for (int i = 1; i <= length; i++) {
            p.next = new Node(s + step * i);
            p = p.next;
        }
        return node;
    }

    @RequiredArgsConstructor
    @ToString(exclude = {"next"})
    static class Node {
        @NonNull Integer value;
        Node next;
    }
}
