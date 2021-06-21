package com.javaStudy;
import java.util.*;

public class RandomClass3 {

	public static void main(String[] args) {
		// TODO Random을 이용한 각종 메서드 구현
		for(int i=0;i<10;i++)
			System.out.print(getRand(0,9)+", ");
		System.out.println("  <- 0~9 랜덤값");
		
		int [] result1 = fillRandRange(new int[10], 2, 6);
		System.out.println("2~6 랜덤값  " +Arrays.toString(result1));
		
		int [] result2 = fillRandData(new int[10], new int [] {2,3,5,8});
		System.out.println("2,3,5,8중 랜덤값  " +Arrays.toString(result2));		
	}
	
	public static int [] fillRandRange(int [] arr, int from, int to) {
		for(int i=0;i<arr.length;i++) 
			arr[i]=getRand(from,to);
		//배열에 from~to 범위의 랜덤값 넣음
			return arr;
	}
	
	
	public static int [] fillRandData(int [] arr, int [] data) {
		for(int i=0;i<arr.length;i++) 
			arr[i]=data[getRand(0,data.length-1)];
		//배열에 data배열에 있는 값으로만 랜덤값 넣음
		//data배열의 랜덤한 'index'를 뽑아야하므로 getRand에 0~data.length-1을 해야함
			return arr;
	}
	
	public static int getRand(int from, int to) {
		return (int)(Math.random() * (Math.abs(to-from) + 1) + (Math.min(from,to)) );
		//from이상 to이하 범위의 랜덤값 메서드
		//Math.random은 0~1미만이므로... 예를들어 1이상 4이하를 위해서는 1~5미만을 만들면 됨... ( 랜덤 * to-from+1) 에서 0~4미만... +from 에서 1~5미만
	}
}

