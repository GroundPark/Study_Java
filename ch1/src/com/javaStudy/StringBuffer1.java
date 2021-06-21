package com.javaStudy;

public class StringBuffer1 {

	public static void main(String[] args) {
		// TODO StringBuffer는 내부적으로 문자열 편집을 위한 버퍼가 있고, 크기(기본값 16)를 조절할수있다.
		// StringBuffer의 equals엔 문자간 비교 구현을 안해놔서... String으로 변환하고 equals로 비교해야함
		
		// 멀티쓰레드-safe하게 동기화되어있음. 이 동기화는 멀티쓰레드 프로그램이 아닌곳에선 성능을 떨어뜨림
		// >> StringBuilder는 동기화만 뺌
		
		StringBuffer sb1 = new StringBuffer("!010");
		StringBuffer sb2 = sb1.append(3138).append(7133);
		//하나의 StringBuffer를 가르키기때문에... append()를 하고난뒤의 sb1, sb2의 내용은 같다 
		
		System.out.println(sb1);
		System.out.println(sb2);
		
		System.out.println(sb1.deleteCharAt(0));
		System.out.println(sb1.delete(3,7));
		System.out.println(sb1.insert(3,"2711"));
		System.out.println(sb1.replace(7,sb1.length(),"6133"));
		
	}

}
