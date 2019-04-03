package meettooffer.chapter4;

import java.util.LinkedList;
import java.util.StringJoiner;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public class TopToBottomPrintBinaryTree {
    public static void main(String[] args) {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.right = new Tree(5);
        root.right.left = new Tree(4);
        root.left.right.left = new Tree(6);
        root.right.left.right = new Tree(7);
        printBinaryLinear(root);
        printBinaryHierarchical(root);
        printBinaryReverse(root);
    }

    private static void printBinaryReverse(Tree root) {
        if (root == null) {
            return;
        }
        @SuppressWarnings("unchecked")
        LinkedList<Tree>[] queue = new LinkedList[2];
        queue[0] = new LinkedList<>();
        queue[1] = new LinkedList<>();
        int level = 1;
        queue[level].add(root);
        queue[level].add(null);
        StringJoiner sj = new StringJoiner(" ");
        while (queue[0].size() > 1 || queue[1].size() > 1) {
            Tree tree = queue[level].pop();
            if (tree == null) {
                sj.add("\n");
                level = (++level) % 2;
                queue[level].add(null);
                continue;
            }
            sj.add(Integer.toString(tree.value));
            if (level % 2 == 0) {
                if (tree.right != null) {
                    queue[(level + 1) % 2].push(tree.right);
                }
                if (tree.left != null) {
                    queue[(level + 1) % 2].push(tree.left);
                }
            } else {
                if (tree.left != null) {
                    queue[(level + 1) % 2].push(tree.left);
                }
                if (tree.right != null) {
                    queue[(level + 1) % 2].push(tree.right);
                }
            }
        }
        System.out.println(sj.toString());
    }

    private static void printBinaryHierarchical(Tree root) {
        if (root == null) {
            return;
        }
        LinkedList<Tree> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        StringJoiner sj = new StringJoiner(" ", "[", "]");
        while (queue.size() > 1) {
            Tree tree = queue.remove();
            if (tree == null) {
                sj.add("\n");
                queue.add(null);
                continue;
            }
            sj.add(Integer.toString(tree.value));
            if (tree.left != null) {
                queue.add(tree.left);
            }
            if (tree.right != null) {
                queue.add(tree.right);
            }
        }
        System.out.println(sj.toString());
    }

    private static void printBinaryLinear(Tree root) {
        if (root == null) {
            return;
        }
        LinkedList<Tree> queue = new LinkedList<>();
        queue.add(root);
        StringJoiner sj = new StringJoiner(" ", "[", "]");
        while (!queue.isEmpty()) {
            Tree tree = queue.remove();
            sj.add(Integer.toString(tree.value));
            if (tree.left != null) {
                queue.add(tree.left);
            }
            if (tree.right != null) {
                queue.add(tree.right);
            }
        }
        System.out.println(sj.toString());
    }

    @RequiredArgsConstructor
    static class Tree {
        @NonNull
        Integer value;
        Tree left;
        Tree right;
    }
}
