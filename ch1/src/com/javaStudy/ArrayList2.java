package com.javaStudy;
import java.util.*;

public class ArrayList2 {
	// TODO : 긴 문자열 데이터를 원하는 Limit만큼 잘라서 ArrayList에 담고 list를 출력하는 예제
	
	public static void main(String[] args) {
		String Src = "0123456789qwertyuiopasdfghjklzxcvbnm";
		final int Limit = 10;	//자르고 싶은 글자의 개수 
		int length = Src.length();
		
		List list = new ArrayList(length/Limit + 10);
		// ArrayList 고려사항중 하나로 항상 여유있게 크기를 지정해야한다.
		// 배열 이용한 자료구조는 [읽기, 순차적인 추가-역순 삭제]에 좋지만 
		// size변경이 불가능 : size 변경할때 새 배열로 복사 +기존 배열 삭제와 같은 큰 자원 소모
		// 비순차적 데이터의 추가 및 삭제에 긴 시간걸림
		
		for(int i=0;i<length;i+=Limit) {
			if(i+Limit < length) {
				list.add(Src.substring(i,i+Limit));
			}
			// limit 마다 자름... 여기선 10 ex) 0,10 > 10, 20 > 20, 30 ...
			else
				list.add(Src.substring(i));
			//String.substring(i) 문자열  i위치부터 끝까지 문자열 자르기
			// 예제의 Src길이는 36 ... i=30 + Limit=10 해서 40인데 length가 36이므로 else로 처리(~36) 및 빠져나옴
		}
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		// 4개(size)의 list에  arraylist 배열이 담겨있다 
		
	}

}
