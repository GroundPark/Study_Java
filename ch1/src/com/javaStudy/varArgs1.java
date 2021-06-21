package com.javaStudy;

public class varArgs1 {

	public static void main(String[] args) {
		// TODO 가변인자 예제
		
		String [] arr = { "100", "eng", "한글" };
		
		System.out.println(concatenate("++", arr));
	}

	static String concatenate(String delim, String ... args) {
		String result = "";
		
		for(String str : args) {
			result += str + delim;
		}
		return result;
		//인자를 args 배열로 알아서 처리해준다
		//가변인자이므로 이 메서드는 오버로딩할수없음
	}
}
