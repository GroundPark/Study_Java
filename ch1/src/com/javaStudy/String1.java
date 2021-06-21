package com.javaStudy;
import java.util.*;

public class String1 {

	public static void main(String[] args) throws Exception{
		// TODO String 클래스.. 그리고 문자
		// 1. 생성된 String 인스턴스는 바꿀수 없다. 변경이 불가능하고 변경하는것처럼 새 문자열 인스턴스를 만드는것 뿐임
		// 2. 구현할때 동일한 내용의 문자열 리터럴은 재사용됨. 이게 싫으면 new String();으로  각각 새로 지정해야함
		// 3. 초기화로는 보통 String s = ""; // char c = ' '; (null 과 \u0000이 원조 기본값이나 보통 공백 초기화할때 이방법을씀)
		
		String animals = "cat,dog,bird";
		String [] arr = animals.split(",");
		
		System.out.println(String.join("--",arr));
		
		StringJoiner sj = new StringJoiner(">>","[","]");
		for(String s : arr)
			sj.add(s);
		System.out.println(sj.toString());
		//StringJoiner는 for-toString까지 한몸통처럼 씀
		
		// 아래는 문자 인코딩 간단 변환
		String han = "시";		
		byte [] utf8_str = han.getBytes("UTF-8");
		//문자열을 UTF-8로 변환(exception필요)
		String str = new String(utf8_str, "UTF-8");
		//byte배열을 문자열로 변환
	}

}
