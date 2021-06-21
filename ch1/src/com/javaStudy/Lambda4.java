package com.javaStudy;
import java.util.*;

public class Lambda4 {

	public static void main(String[] args) {
		// TODO Collection 프레임워크 > 디폴트 메서드 중 일부는 함수형 인터페이스를 사용함
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0;i<10;i++)
			list.add(i);
		
		list.forEach(i -> System.out.print(i+", "));	//forEach - Consumer : 공백, 쉼표
		System.out.println();
		
		list.removeIf(x -> x%2 == 0 || x%3 == 0);	//removeIf - Predicate : list에 2,3배수 제거
		System.out.println(list);
		
		list.replaceAll(i -> i * 10);	//BiFunction - apply : list 요소에 10을 곱함
		System.out.println(list);
		
		Map<String, String> map = new HashMap<>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
		
		map.forEach((k,v) -> System.out.print("["+k+","+v+"]"));  //BiConsumer - apply : map의 모든 요소를 [k,v]형식으로 출력
	}

}
