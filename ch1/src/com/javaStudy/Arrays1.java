package com.javaStudy;
import java.util.*;

public class Arrays1 {

	public static void main(String[] args) {
		// TODO Arrays 클래스 : 배열을 다루는 메서드들이 정의되어 있음
		int [] arr = {4,7,2,3,5};
		int [][] arr2D = {{10,20,30},{100,200,300}};
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.deepToString(arr2D));
		System.out.println("ㄴ 출력");
		
		int [] arr2 = Arrays.copyOf(arr, arr.length);
		int [][] arr2D2 = Arrays.copyOf(arr2D, arr2D.length);
		int [] arr3 = Arrays.copyOf(arr, 7);		   //지정안된곳은 기본값 0 
		int [] arr4 = Arrays.copyOfRange(arr, 1, 4);   //이상, 미만
		
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));
		System.out.println(Arrays.toString(arr4));
		System.out.println("ㄴ 복사");
		
		System.out.println("equals = " +Arrays.equals(arr, arr2));
		System.out.println("deepEquals = " +Arrays.deepEquals(arr2D, arr2D2));
		System.out.println("ㄴ 비교");
		
		int [] arr5 = new int [5];
		Arrays.fill(arr5, 77);
		System.out.println(Arrays.toString(arr5));
		
		Arrays.setAll(arr5, i -> (int)(Math.random() * 5 ));
		System.out.println(Arrays.toString(arr5));
		System.out.println("ㄴ 지정 수로 채우기, 람다식(ex;랜덤)으로 채우기");
		
		Arrays.sort(arr);
		int i = Arrays.binarySearch(arr,4);
		System.out.println("arr sort 후 : " +Arrays.toString(arr));
		System.out.println("> 2를 정렬된 arr에서 이진검색한 idx값 " +i);
		// 이진검색은 sort가 선행되어야함!
		
		List list = Arrays.asList(1,2,3,4,5);
		// 배열을 List에 담아서 반환, 크기내의 값은 변경가능하지만 크기변경, 추가, 삭제 불가
	}

}
