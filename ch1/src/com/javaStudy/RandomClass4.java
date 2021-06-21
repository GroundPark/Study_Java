package com.javaStudy;
import java.util.*;

public class RandomClass4 {
	final static int RECORD_COUNT = 10;
	final static String TABLE_NAME = "TEST_ONLY_TABLE";
	final static String [] COL1 = {"010", "031", "02"};
	final static String [] COL2 = {"남", "여"};
	final static String [] COL3 = {"미성년", "성인", "노인"};

	public static void main(String[] args) {
		// TODO Random을 이용한 DB에 넣을 테스트용-랜덤-데이터 생성 예제
		for(int i=0;i<RECORD_COUNT;i++) {
			System.out.println("INSERT INTO " +TABLE_NAME+" VALUES"+"("
								+"'" +getRandArr(COL1) + "'"
								+", '" +getRandArr(COL2) + "'"
								+", '" +getRandArr(COL3) + "'"
								+", "  +getRand1(100000,200000) +");"
								);
		}
	}
	
	public static int getRand1(int from, int to) {
		return (int)(Math.random() * (Math.abs(to-from) + 1) + (Math.min(from,to)) );
		//from이상 to이하 범위의 랜덤값 메서드
	}
	
	public static int getRand1(int n) {
		return getRand1(0,n);
		// 배열 index용... 0~n의 랜덤값
	}
	
	public static String getRandArr (String [] arr) {
		return arr[getRand1(arr.length-1)];
		//index이므로 length-1을 해야함. 배열에 저장된 값중 하나 반환
	}
}
