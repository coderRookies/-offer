package meettooffer.chapter6;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.Value;

import java.lang.annotation.Target;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class KNodeOfTree {
    public static void main(String[] args) {
        Tree root = new Tree(3);
        root.left = new Tree(2);
        root.right = new Tree(4);
        root.left.left = new Tree(1);
        root.right.right = new Tree(5);
        AtomicInteger atomicInteger = new AtomicInteger(2);
        Tree node = getKthNode(root, atomicInteger);
        System.out.println(node);
    }

    private static Tree getKthNode(Tree root, AtomicInteger k) {
        Objects.requireNonNull(root);
        return getKthNodeCore(root, k);
    }

    private static Tree getKthNodeCore(Tree root, AtomicInteger k) {
        Tree node = null;
        if (root.left != null) {
            node = getKthNodeCore(root.left, k);
        }
        if (node == null) {
            if (k.get() == 1) {
                node = root;
            }
            k.decrementAndGet();
        }
        if (node == null && root.right != null) {
            node = getKthNodeCore(root.right, k);
        }
        return node;
    }

    @RequiredArgsConstructor
    @ToString(exclude = {"left", "right"})
    static class Tree {
        @NonNull Integer value;
        Tree left;
        Tree right;
    }
}
