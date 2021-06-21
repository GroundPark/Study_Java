package com.javaStudy;
import java.util.*;

public class ArrayQ5 {

	public static void main(String[] args) {
		// TODO 주어진 불연속적 값으로 배열 채우기
		
		int [] Arr = { -4, -1, 3, 6, 11};
		int [] myArr = new int[10];
		
		for(int i=0; i<myArr.length;i++) {
			int tmp = (int)(Math.random() * Arr.length);
			myArr[i] = Arr[tmp];
		}
		// myArr 길이만큼 랜덤 값을 만들어 주어진 배열의 idx의 값으로 채운다
		
		System.out.println(Arrays.toString(myArr));
	}

}
