package com.javaStudy;
import java.util.*;

public class Iterator2 {

	public static void main(String[] args) {
		// TODO Iterator의 remove는 next가 선행돼야함
		ArrayList myAL = new ArrayList(10);
		ArrayList copy1 = new ArrayList(10);
		ArrayList copy_tmp = new ArrayList(10);
		
		for(int i=0;i<10;i++)
			myAL.add(i+"");
		//myAL에 0~9 넣고 다른건 비어있음
				
		Iterator myIt = myAL.iterator();
		
		while(myIt.hasNext())
			copy1.add(myIt.next());
		System.out.println("원본 배열을 다른 배열에 복사함");
		System.out.println("원본 : " +myAL);
		System.out.println("복사 : " +copy1);
		System.out.println();
		
		myIt = myAL.iterator();
		// Iterator는 재사용 안됨, 다시 얻음
		
		while(myIt.hasNext()) {
			copy_tmp.add(myIt.next());
			myIt.remove();
			//배열을 이동 시킨다는건  '복사하고 >> 원본을 삭제' 했다는 의미
		}
		System.out.println("원본 배열을 다른 배열로 이동함");
		System.out.println("원본 : " +myAL);
		System.out.println("이동 : " +copy1);
	}
}
