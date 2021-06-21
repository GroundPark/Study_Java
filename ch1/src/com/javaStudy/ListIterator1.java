package com.javaStudy;
import java.util.*;

public class ListIterator1 {

	public static void main(String[] args) {
		//TODO ListIterator 기본 예제
		// (Iterator는 단방향이지만) 양방향으로 이동하기에 자유로우나 이동 전 각각의 경우에 hasNext(), hasPrevious() 선행 필요
				ArrayList myAL = new ArrayList();
				
				myAL.add("1");
				myAL.add("2");
				myAL.add("3");
				myAL.add("4");
				myAL.add("5");
				
				ListIterator myLit = myAL.listIterator();
				
				while(myLit.hasNext()) {
					System.out.print(myLit.next());	
				}
				// 정방향
				
				System.out.println();	
				
				while(myLit.hasPrevious()) {
					System.out.print(myLit.previous());
				}
				// 역방향
	}
}
