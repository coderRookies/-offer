package meettooffer.chapter4;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public class MirrorTree {
    public static void main(String[] args) {
        Tree root = new Tree(1d);
        root.left = new Tree(2d);
        root.right = new Tree(3d);
        root.left.left = new Tree(4d);
        print(root);
        mirrorTree(root);
        print(root);
    }
    private static void mirrorTree(Tree root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        swap(root);
        if (root.left != null) {
            mirrorTree(root.left);
        }
        if (root.right != null) {
            mirrorTree(root.right);
        }
    }
    private static void swap(Tree root) {
        Tree temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
    private static void print(Tree root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            print(root.left);
        }
        System.out.println(root.value);
        if (root.right != null) {
            print(root.right);
        }
    }
    @RequiredArgsConstructor
    static class Tree {
        @NonNull Double value;
        Tree left;
        Tree right;
    }
}
