package meettooffer.chapter4;

import java.util.Objects;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public class IsSymmetrical {
    public static void main(String[] args) {
        Tree t1 = new Tree(1);
        Tree t2 = new Tree(1);
        t1.left = new Tree(1);
        t2.right = new Tree(1);
        boolean isStmmetrical = isSymmetrical(t1, t2);
        System.out.println(isStmmetrical);
    }
    private static boolean isSymmetrical(Tree t1, Tree t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (Objects.equals(t1.value, t2.value)) {
            return false;
        }
        return isSymmetrical(t1.left, t2.right) && isSymmetrical(t1.right, t2.left);
    }
    @RequiredArgsConstructor
    static class Tree {
        @NonNull Integer value;
        Tree left;
        Tree right;
    }
}
