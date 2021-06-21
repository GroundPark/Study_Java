package com.javaStudy;
import java.util.*;

class StackandQueue {
	// TODO : 스택과 큐의 기본
	public static void main(String[]args) {
		Stack st = new Stack();
		Queue Que = new LinkedList(); 
		// stack은 push/pop 이용해서 LIFO, Queue는 offer/poll 이용해서 FIFO
		// Queue는 별도 클래스 없으므로 Queue 인터페이스를 구현한 클래스를 불러와서 쓰면 됨
		
		st.push("0");
		st.push("1");
		st.push("2");
		
		Que.offer("A");
		Que.offer("B");
		Que.offer("C");
		
		System.out.println("스택에 있는걸 순서대로");
		while(!st.empty()) {
			System.out.println(st.pop());
		}
			
		System.out.println("큐에 있는걸 순서대로");
		while(!Que.isEmpty()) {
			System.out.println(Que.poll());
		}
		// 스택 : 수식계산, 수식괄호검사, 워드 프로세서 undo/redo, 웹 브라우저 앞/뒤로
		// 큐    : 최근사용문서, 인쇄 대기목록, 버퍼...
	}
}
