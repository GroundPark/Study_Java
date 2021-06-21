package com.javaStudy;
import java.util.*;

public class TreeSet2 {
	public static void main(String [] args) {
		// TODO TreeSet에서의 검색
		TreeSet mySet = new TreeSet();
		String [] words = {"abc", "alien", "bat", "car","Car","dance","elbow","flower"};
		
		String from = "b";
		String to = "d";
		
		for(int i=0;i<words.length;i++) {
			mySet.add(words[i]);
		}
		
		System.out.println(mySet);
		//기본 정렬 규칙에 따르면 대문자가 먼저이므로... Car이 먼저 나옴... 대or소문자로 통일하고 저장한뒤에 사용해야 함 
		//!참고! 문자열 기본 정렬 규칙 : (오름차의 경우) 공백,숫자,대,소문자
		System.out.println("subSet 범위검색 (b~d) : " +mySet.subSet(from, to));
		System.out.println("------------");
		
		TreeSet mySet2 = new TreeSet();
		int [] nums = {80, 95, 11, 65, 43, 100};

		for(int i=0;i<nums.length;i++) {
			mySet2.add(new Integer(nums[i]));
		}
		
		System.out.println(mySet2);
		System.out.println("50보다 작은 값 : " +mySet2.headSet(new Integer(50)));
		System.out.println("50보다 큰 값 : " +mySet2.tailSet(new Integer(50)));
		// 이진 검색 트리를 직접 구현해보면 [50보다 작은값은 화살표의 head에 있고], [50보다 큰값은 화살표의 tail에 있다]는 식으로 이해하면 쉽다  
	}
}
