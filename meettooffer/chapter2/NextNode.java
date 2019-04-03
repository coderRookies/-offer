package meettooffer.chapter2;

import java.util.Arrays;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

public class NextNode {
    public static void main(String[] args) {
        Character[] middle = { 'd', 'b', 'h', 'e', 'i', 'a', 'f', 'c', 'g' };
        Character[] pre = { 'a', 'b', 'd', 'e', 'h', 'i', 'c', 'f', 'g' };
        Node<Character> tree = rebuild(middle, pre);
        findNext(tree, tree.getLeft().getRight());

    }

    public static <T> void findNext(Node<T> root, Node<T> node) {
        if (node.getRight() != null) {
            Node<T> e = node.getRight();
            while (e.getLeft() != null) {
                e = e.getLeft();
            }
//            System.out.println(e.getValue());
            System.out.println(e);
            return;
        }
        Node<T> p = node;
        while (p.getParent() != null && p.getParent().getRight() == p) {
            p = p.getParent();
        }
        if (p.getParent() == null) {
            System.out.println("null");
        } else {
//            System.out.println(p.getParent().getValue());
            System.out.println(p.getParent());
        }
    }

    public static <T> Node<T> rebuild(T[] middleOrder, T[] preOrder) {
        if (middleOrder.length == 0) {
            return null;
        }
        if (middleOrder.length == 1) {
            return new Node<T>(middleOrder[0]);
        }
        int index = 0;
        for (int i = 0; i < preOrder.length; i++) {
            if (preOrder[0] == middleOrder[i]) {
                index = i;
                break;
            }
        }
        Node<T> resultNode = new Node<T>(preOrder[0]);
        resultNode.setLeft(
                rebuild(Arrays.copyOfRange(middleOrder, 0, index), Arrays.copyOfRange(preOrder, 1, index + 1)));
        if (resultNode.getLeft() != null) {
            resultNode.getLeft().setParent(resultNode);
        }
        resultNode.setRight(rebuild(Arrays.copyOfRange(middleOrder, index + 1, middleOrder.length),
                Arrays.copyOfRange(preOrder, index + 1, preOrder.length)));
        if (resultNode.getRight() != null) {
            resultNode.getRight().setParent(resultNode);
        }
        return resultNode;
    }

    @Data
    @NoArgsConstructor
    @RequiredArgsConstructor
    @EqualsAndHashCode
    @ToString(exclude = {"left", "right", "parent"})
    private static class Node<T> {
        @NonNull
        private T value;
        private Node<T> left;
        private Node<T> right;
        private Node<T> parent;
//        @Override
//        public String toString() {
//            StringJoiner sj = new StringJoiner(", ", "[", "]");
//            if (value != null) {
//                sj.add("value: " + value.toString());
//            }
//            return sj.toString();
//        }
    }
}
