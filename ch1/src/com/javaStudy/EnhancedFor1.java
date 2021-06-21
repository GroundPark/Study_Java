package com.javaStudy;

public class EnhancedFor1 {

	public static void main(String[] args) {
		// TODO 향상된 for 문으로 문장이 간결하나 읽는 용도정도라 범용성 좀 떨어짐
		int [] arr = {10, 20, 30, 40};
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		System.out.println();
		
		
		for(int tmp : arr) {
			System.out.println(tmp);
		}
	}

}
