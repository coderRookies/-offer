package meettooffer.chapter3;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public class HasSubtree {
    public static void main(String[] args) {
        Tree root = new Tree(1d);
        root.left = new Tree(2d);
        root.right = new Tree(3d);
        root.left.left = new Tree(4d);
        root.left.right = new Tree(5d);
        
        Tree sub = new Tree(2d);
        sub.left = new Tree(4d);
        sub.right = new Tree(5d);
        boolean isHas = hasSubtree(root, sub);
        System.out.println(isHas);
    }
    private static boolean hasSubtree(Tree root, Tree sub) {
        boolean result = false;
        
        if (root != null && sub != null) {
            if (equal(root.value, sub.value)) {
                result = doesTree1HaveTree2(root, sub);
            }
            if (!result) {
                result = hasSubtree(root.left, sub);
            }
            if (!result) {
                result = hasSubtree(root.right, sub);
            }
        }
        
        return result;
    }
    private static boolean doesTree1HaveTree2(Tree root, Tree sub) {
        if (sub == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (!equal(root.value, sub.value)) {
            return false;
        }
        return doesTree1HaveTree2(root.left, sub.left) && doesTree1HaveTree2(root.right, sub.right);
    }
    private static boolean equal(double value, double value2) {
        boolean result = false;
        if (value - value2 > -0.00000001 && value - value2 < 0.00000001) {
            result = true;
        }
        return result;
    }
    @RequiredArgsConstructor
    static class Tree {
        @NonNull Double value;
        Tree left;
        Tree right;
    }
}
