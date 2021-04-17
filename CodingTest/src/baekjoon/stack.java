package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class stack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();

        int x = input.nextInt();
        stack.push(x);
        stack.push(1);
        stack.push(2);
        System.out.println(stack.peek());
        System.out.println(stack.size());
        if (stack.empty()) {
            System.out.println(1);
        }else{
            System.out.println(0);
        }
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.size());
        if (stack.empty()) {
            System.out.println(1);
        }else{
            System.out.println(0);
        }
        if(stack.pop() == null){
            System.out.println();
        }
    }
}
