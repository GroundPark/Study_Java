package com.javaStudy;
import java.util.*;

public class Deque1 {

	public static void main(String[] args) {
		// TODO 한 방향으로 추가/삭제 가능한 Queue와 달리 Dequeue는 양 방향으로 추가/삭제가 가능하다
		 System.out.println("Stack!!");
	        Deque<String> stack = new ArrayDeque<>();
	        stack.addFirst("Element1");
	        stack.addFirst("Element2");
	        stack.addFirst("Element3");
	        System.out.println(stack.removeFirst());
	        System.out.println(stack.removeFirst());
	        System.out.println(stack.removeFirst());

	      
	        System.out.println("Queue!!");
	        Deque<String> queue = new ArrayDeque<>();
	        queue.addFirst("Element1");
	        queue.addFirst("Element2");
	        queue.addFirst("Element3");
	        System.out.println(queue.removeLast());
	        System.out.println(queue.removeLast());
	        System.out.println(queue.removeLast());
	}

}
