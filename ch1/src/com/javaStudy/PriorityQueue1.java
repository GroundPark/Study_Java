package com.javaStudy;
import java.util.*;

public class PriorityQueue1 {

	public static void main(String[] args) {
		// TODO PriorityQueue는 Queue인터페이스 구현체로... 우선순위가 높은 것부터 꺼낸다 (!null 저장 못함)
		Queue myQue = new PriorityQueue();
		myQue.offer(3);
		myQue.offer(1);
		myQue.offer(5);
		myQue.offer(2);
		myQue.offer(4);
		
		System.out.println(myQue);
		//heap 자료구조에 의해 1 25 34 순으로 저장
		
		Object obj = null;
		
		while((obj = myQue.poll()) != null)
			System.out.println(obj);
		// PrioirtyQueue에 저장된 요소들을 priority에 맞춰 poll 함 (숫자가 작을수록 높은 우선순위) 
		
	}

}
