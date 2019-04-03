package meettooffer.chapter6;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.right = new Tree(4);
        root.left.right.right = new Tree(5);
        boolean isBalanced = isBalanced(root);
        System.out.println(isBalanced);
    }

    private static boolean isBalanced(Tree root) {
        AtomicInteger depth = new AtomicInteger(0);
        return isBalanced(root, depth);
    }

    private static boolean isBalanced(Tree root, AtomicInteger depth) {
        if (root == null) {
            depth.set(0);
            return true;
        }
        AtomicInteger left = new AtomicInteger(0), right = new AtomicInteger(0);
        if (isBalanced(root.left, left) && isBalanced(root.right, right)) {
            int diff = left.get() - right.get();
            if (diff <= 1 && diff >= -1) {
                depth.set(1 + (left.get() > right.get() ? left.get() : right.get()));
                return  true;
            }
        }
        return  false;
    }

    @RequiredArgsConstructor
    @ToString(exclude = {"left", "right"})
    static class Tree {
        @NonNull Integer value;
        Tree left;
        Tree right;
    }
}
