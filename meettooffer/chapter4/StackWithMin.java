package meettooffer.chapter4;

import java.util.LinkedList;

public class StackWithMin {

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(2);
        stack.push(3);
        stack.push(1);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
    }
    
    static class MinStack {
        private LinkedList<Integer> minStack;
        private LinkedList<Integer> stack;
        public MinStack() {
            minStack = new LinkedList<>();
            stack = new LinkedList<>();
        }
        public void push(int e) {
            stack.push(e);
            if (minStack.isEmpty() || e < minStack.peekLast()) {
                minStack.push(e);
            } else {
                minStack.push(minStack.peek());
            }
        }
        public Integer pop() {
            minStack.pop();
            return stack.pop();
        }
        public Integer min() {
            return minStack.peek();
        }
    }
}
