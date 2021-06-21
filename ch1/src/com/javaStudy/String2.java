package com.javaStudy;

public class String2 {

	public static void main(String[] args) {
		// TODO 기본형 숫자에 빈문자열 ""을 더하면 문자열이 된다. 또는 valueOf를 씀
		// String 문자열을 기본형으로 바꾸려면 valueOf(parseInt)를 씀  
		// 기본형, 문자열간 변환 (자세한 내용 p474)
		
		int i = 100;
		int j = 200;
		
		String str1 = String.valueOf(i);
		String str2 = j + "";
		// '정수' i,j는 숫자인 '문자열'이 됨
		
		int ii = Integer.parseInt(str1);
		int jj = Integer.parseInt(str2.trim());
		//parseInt같은 메서드는 공백,문자가 있으면 exception나므로 trim()을 자주 씀
		//다른 예로 Double.parseDouble(..) 처럼 씀
		
		String url = "www.google.com";
		
		int index = url.indexOf('.');    //3
		int indexLast = url.lastIndexOf('.');   //10
		String iconName = url.substring(index+1,indexLast); //substring은 이상,미만으로 기억하면 쉬움
		System.out.println(iconName);
	}

}
