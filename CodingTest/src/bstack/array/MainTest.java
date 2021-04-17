package bstack.array;
public class MainTest {
	public static void main(String[] args) {
		ArrayStack<String> stack = new ArrayStack<String>();
		//baekjoon.stack.peek();
		stack.push("apple");
		stack.push("orange");
		stack.push("cherry");
		System.out.println(stack.peek());	// 스택 top 항목의 내용만을 리턴
		System.out.println("--------------------------");
		
//		baekjoon.stack.push("pear");
//		baekjoon.stack.print();
//		System.out.println("--------------------------");
		
//		baekjoon.stack.pop();
//		System.out.println(baekjoon.stack.peek());
//		baekjoon.stack.push("grape");
//		baekjoon.stack.print();
	}
}
