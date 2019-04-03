package meettooffer.chapter4;

import java.util.LinkedList;

public class IsPopOrder {
    public static void main(String[] args) {
        int[] pushOrder = { 1, 2, 3, 4 };
        int[] popOrder = { 2, 3, 1, 4};
        boolean isPopOrder = isPopOrder(pushOrder, popOrder);
        System.out.println(isPopOrder);
    }

    private static boolean isPopOrder(int[] pushOrder, int[] popOrder) {
        int pushPoint = 0, popPoint = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        while (pushPoint < pushOrder.length) {
            
            if (stack.peek() == null || stack.peek() != popOrder[popPoint]) {
                stack.push(pushOrder[pushPoint++]);
            }
            
            if (stack.peek() != null && stack.peek() == popOrder[popPoint]) {
                stack.pop();
                popPoint++;
            }
        }
        return pushPoint == pushOrder.length && popPoint == popOrder.length;
    }
}
