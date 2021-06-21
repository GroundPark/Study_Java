package com.javaStudy;

public class Wrapper1 {

	public static void main(String[] args) {
		// Wrapper클래스를 통해 기본형 값을 객체로 다룬다. 기본형 변수를 객체로 변환하여 필요/요구 상황에 대응하기 위함
		// equals, toString 오버라이딩 되어있음
		// char > Character , int > Integer 말고는 맨앞글자가 대문자라는것만 알면 됨(long > Long)	
		
		int intI = 100;
		
		Integer i = new Integer(100);
		int ii = Integer.parseInt("100");
		Integer iii = Integer.valueOf("100");
		
		int iiii = Integer.parseInt("100",2); 
		// 100을 2진법으로 표현함
		
		
		
		// 오토박싱 : 기본형값을 래퍼 클래스의 객체로 자동 변환
		// 언박싱 : 객체를 기본형 값으로 변환
		
		int sum = intI + i; 
		// 기본형 + 객체형을 연산하여 기본형에 저장해야하므로... 객체형을 기본형으로 바꾸는 작업이 필요함
		// 업뎃 이후 오토박싱/언박싱이 컴파일러에서 자동수행되므로 할 필요없음 
	  //int sum = intI + i.intValue(); <<오토박싱 후 
	}

}
