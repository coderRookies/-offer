package meettooffer.chapter4;

import java.util.Deque;
import java.util.LinkedList;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

public class BinaryToList {
    private static Deque<Tree> deque = new LinkedList<>();
    
    public static void main(String[] args) {
        Tree root = new Tree(10);
        root.left = new Tree(6);
        root.right = new Tree(14);
        root.left.left = new Tree(4);
        root.left.right = new Tree(8);
        root.right.left = new Tree(12);
        root.right.right = new Tree(16);
        binaryToList(root);
        print(deque);
    }
    
    private static <T> void print(Deque<T> deque) {
        for (T t : deque) {
            System.out.println(t);
        }
    }

    private static void binaryToList(Tree root) {
        traversal(root);
    }

    private static void traversal(Tree tree) {
        if (tree == null) {
            return;
        }
        if (tree.left != null) {
            traversal(tree.left);
        }
        deque.add(tree);
        if (tree.right != null) {
            traversal(tree.right);
        }
    }


    @RequiredArgsConstructor
    @ToString(exclude = {"left", "right"})
    static class Tree {
        @NonNull
        Integer value;
        Tree left;
        Tree right;
    }
}