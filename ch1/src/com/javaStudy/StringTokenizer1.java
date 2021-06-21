package com.javaStudy;
import java.util.*; 

class StringTokenizer1 { 
	public static void main(String args[]) { 
		// TODO StringTokenizer : 문자열을 지정된 하나의 구분자를 기준으로 토큰이라는 여러개의 문자열로 잘라내는데 사용
		// "100,200,300"에서 [구분자: ,] [토큰 : 100  200  300]
		// [하나의 구분자]로 나눈다. 복잡한 구분자 또는 2개이상의 구분자의 경우 regex를 쓴다던가 split을 써야함
		String source = "100,200,300,400";
		StringTokenizer st = new StringTokenizer(source, ",");
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		System.out.println("///////////////////");
		
		String expression = "x=100*(200+300)/2";
		StringTokenizer st2 = new StringTokenizer(expression, "+-*/=()", true);
		//StringTokenizer(string,delim,구분자의 토큰화 가능 여부 T/F);
		while(st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}
	}		
	
} 
