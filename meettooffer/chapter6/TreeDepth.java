package meettooffer.chapter6;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

public class TreeDepth {
    public static void main(String[] args) {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.right = new Tree(4);

        int depth = computeTreeDepth(root);
        System.out.println(depth);
    }

    private static int computeTreeDepth(Tree root) {
        if (root == null) {
            return 0;
        }
        int left = computeTreeDepth(root.left);
        int right = computeTreeDepth(root.right);

        return (left > right) ? (left + 1) : (right + 1);
    }

    @RequiredArgsConstructor
    @ToString(exclude = {"left", "right"})
    static class Tree {
        @NonNull Integer value;
        Tree left;
        Tree right;
    }
}
