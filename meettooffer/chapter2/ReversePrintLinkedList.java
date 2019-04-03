package meettooffer.chapter2;

import java.util.LinkedList;
import java.util.List;

import algorithm.Stack;

public class ReversePrintLinkedList {
    
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = generateList(10);
        for (Integer integer : list) {
            stack.push(integer);
        }
        System.out.println(stack.toString());
    }
    
    public static List<Integer> generateList(int n) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        return list;
    }
}
