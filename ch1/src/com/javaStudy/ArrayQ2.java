package com.javaStudy;

public class ArrayQ2 {

	public static void main(String[] args) {
		// TODO 배열에 저장된 값 중 최대,최소값 구하기
		
		int [] arr = {79,88,91,33,100,55,95};
		
		int min = arr[0];
		int max = arr[0];
		
		for(int i=1;i<arr.length;i++) {
			if(min>arr[i]) {
				min = arr[i];
			}else if(max<arr[i]) {
				max = arr[i];
			}
		}
		//min,max가 79,79로 초기화되고 > 79,88 > 79,91 > 33,91 > 33,100 순으로 정리됨
		System.out.printf("최대값 : %d, 최소값 : %d", max, min);
	}

}
