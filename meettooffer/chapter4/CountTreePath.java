package meettooffer.chapter4;

import java.util.LinkedList;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public class CountTreePath {
    public static void main(String[] args) {
        Tree root = new Tree(10);
        root.left = new Tree(5);
        root.right = new Tree(12);
        root.left.left = new Tree(4);
        root.left.right = new Tree(7);
        int expect = 22;
        countTreePath(root, expect);
    }
    private static void countTreePath(Tree root, int expect) {
        if (root == null) {
            return;
        }
        LinkedList<Integer> list = new LinkedList<>();
        int currentSum = 0;
        countTreePath(root, expect, list, currentSum);
    }
    private static void countTreePath(Tree root, int expect, LinkedList<Integer> list, int currentSum) {
        currentSum += root.value;
        list.push(root.value);
        boolean isLeaf = root.left == null && root.right == null;
        if (currentSum == expect && isLeaf) {
            System.out.print("is found: ");
            System.out.println(list);
        }
        
        if (root.left != null) {
            countTreePath(root.left, expect, list, currentSum);
        }
        if (root.right != null) {
            countTreePath(root.right, expect, list, currentSum);
        }
        list.pop();
    }
    @RequiredArgsConstructor
    static class Tree {
        @NonNull
        Integer value;
        Tree left;
        Tree right;
    }
}
