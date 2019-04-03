package meettooffer.chapter2;

import java.util.Arrays;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public class ConstructBinaryTree {
    public static void main(String[] args) {
        int[] middle = { 4, 7, 2, 1, 5, 3, 8, 6 };
        int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
        Node root = rebuild(middle, pre);
        prePrint(root);
        System.out.println();
        middlePrint(root);
        System.out.println();
        postPrint(root);
    }

    public static void prePrint(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getValue() + " ");
        if (node.getLeft() != null) {
            prePrint(node.getLeft());
        }
        if (node.getRight() != null) {
            prePrint(node.getRight());
        }
    }
    
    public static void middlePrint(Node node) {
        if (node == null) {
            return;
        }
        if (node.getLeft() != null) {
            middlePrint(node.getLeft());
        }
        System.out.print(node.getValue() + " ");
        if (node.getRight() != null) {
            middlePrint(node.getRight());
        }
    }
    public static void postPrint(Node node) {
        if (node == null) {
            return;
        }
        if (node.getLeft() != null) {
            postPrint(node.getLeft());
        }
        if (node.getRight() != null) {
            postPrint(node.getRight());
        }
        System.out.print(node.getValue() + " ");
    }
    
    public static Node rebuild(int[] middleOrder, int[] preOrder) {
        if (middleOrder.length == 0) {
            return null;
        }
        if (middleOrder.length == 1) {
            return new Node(middleOrder[0]);
        }
        int index = 0;
        for (int i = 0; i < preOrder.length; i++) {
            if (preOrder[0] == middleOrder[i]) {
                index = i;
                break;
            }
        }
        Node resultNode = new Node(preOrder[0]);
        resultNode.setLeft(rebuild(Arrays.copyOfRange(middleOrder, 0, index),
                Arrays.copyOfRange(preOrder, 1, index + 1)));
        resultNode.setRight(rebuild(Arrays.copyOfRange(middleOrder, index + 1, middleOrder.length),
                Arrays.copyOfRange(preOrder, index + 1, preOrder.length)));
        return resultNode;
    }
    
    @Data
    @RequiredArgsConstructor
    static class Node {
        @NonNull private Integer value;
        private Node left;
        private Node right;
    }
}


