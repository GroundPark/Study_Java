package com.javaStudy;
import java.util.*;

public class Comparable_Comparator1 {

	public static void main(String[] args) {
		// Comparable : 기본 정렬 기준 구현(오름차순)
		// Comparator : 다른 정렬 기준 구현 
		String [] strArr = {"cat", "Dog", "tiger", "lion"};
		
		Arrays.sort(strArr);
		System.out.println(Arrays.toString(strArr));
		// 기본 Comparable 사용한 sort
		
		Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);
		System.out.println(Arrays.toString(strArr));
		// 대소문자 구분안하는 상수 형태의 Comparator 사용한 sort
		
		Arrays.sort(strArr, new Descending1());
		System.out.println(Arrays.toString(strArr));
		// Comparator를 오버라이딩하여 역순 클래스를 만들어 사용
	}
}

class Descending1 implements Comparator{
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable) o1;
			Comparable c2 = (Comparable) o2;
			return c1.compareTo(c2) * -1;
			// 기본 정렬에 -1을 곱하면 -1부터 -N순으로 맨앞의 값이 맨뒤로가므로 역순임
		}
		return -1;
	}	
}
