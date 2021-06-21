package com.javaStudy;

public class ArrayQ9 {

	public static void main(String[] args) {
		// TODO String을 이용해 모스 부호 변환 예제
		String source = "SOSHELP";
		String [] morse = {".-", "-...", "-.-.","-..", "."
				,"..-.", "--.", "....","..",".---"
				, "-.-", ".-..", "--", "-.", "---"
				, ".--.", "--.-",".-.","...","-"
				, "..-", "...-", ".--", "-..-","-.--"
				, "--.." };
		
		String result="";
		
		for(int i=0;i<source.length();i++) {
			result += morse[source.charAt(i)-'A']; // 영문자 - 'A' 만큼 모스코드 배열 idx를 가리킨다
		}
		System.out.println("source : " +source);
		System.out.println("result : " +result);
		
	}

}
