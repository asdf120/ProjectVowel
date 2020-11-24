package bstack.array;
import java.util.EmptyStackException;
public class ArrayStack<E> {
	private E   s[];      // 스택을 위한 배열
	private int top;      // 스택의 top 항목의 배열 원소 인덱스
	public ArrayStack() { // 스택 생성자
		s = (E[]) new Object[1];  // 초기에 크기가 1인 배열 생성      //peek(), push(), pop(), resize() 메소드 선언
		top = -1;
	}	
	public int     size()    { return top+1;}           // 스택에 있는 항목의 수를 리턴
	public boolean isEmpty() { return (top == -1);}     // 스택이 empty이면 true 리턴
	
	public E peek() {  // 스택 top 항목의 내용만을 리턴
		if (isEmpty()) throw new EmptyStackException(); // underflow시 프로그램 정지
		return s[top];         
	}	
	
	/**  push 연산 */
	public void push(E newItem) { 
		// 1. 스택의 크기가 꽉 차면 스택을 2배의 크기로 확장
		// 2. top을 하나 늘리고 새 항목을 top번째 저장 
		
	}
	
	/** pop 연산 */
	public E pop() {  
		if (isEmpty()) throw new EmptyStackException(); // underflow시 프로그램 정지
		//  top번째 요소를 얻어와서 삭제될 데이타를 알려주기 위해 리턴한다.
		E item = s[top];
		
		// 1. top번째 요소에 null을 지정하고 top 값을 하나 뺀다.
		// 2. 스택의 크기가 전체의 1/4이면 스택 크기를 1/2만큼 축소한다

		return item;
	}	
	
	
	private void resize(int newSize) { // 배열 크기 조절
		Object[] t = new Object[newSize];  // newSize 크기의 새로운 배열 t 생성
		for (int i = 0; i < size(); i++)
			t[i] = s[i];                   // 배열 s를 배열 t로 복사 
		s = (E[]) t;                      // 배열 t를 배열 s로 
	}	
	
	
	public void print() { // 스택의 항목들을 아래에서 위로 출력
		if (isEmpty()) System.out.print("스택이 비어있음.");      
		else for(int i = 0; i < size(); i++)	System.out.print(s[i]+"\t ");
		System.out.println();
	}
}
