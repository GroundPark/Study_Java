package com.javaStudy;
import java.util.*;

public class HashSet1 {

	public static void main(String[] args) {
		// HashSet : Set 인터페이스 구현한 대표 컬렉션, 중복 요소 저장안함(add시도시 실패함)
		// LinkedHashSet : 중복 제거하면서 저장 순서 유지함
		Object [] objArr = {"1", new Integer(1), "2", "2", "3"};
		Set mySet = new HashSet();
		
		for(int i=0;i<objArr.length;i++) {
			mySet.add(objArr[i]);
		}
		// 1,"1"은 다른형이므로 다른 객체 취급함
		System.out.println(mySet);
		System.out.println();
		
		
		Set LottoSet = new HashSet();
		
		for(int i=0;LottoSet.size()<6;i++) {
			int num = (int)(Math.random() * 45) + 1;
			LottoSet.add(new Integer(num));
		}
		List LottoList = new LinkedList(LottoSet);
		Collections.sort(LottoList);
		//크기순 정렬을 위해... 컬렉션의 sort를 쓰기 위해 List 타입 필요함... HashSet에 저장된 객체들을 LinkedList에 담아 처리 
		System.out.println(LottoList);
		
	}

}
