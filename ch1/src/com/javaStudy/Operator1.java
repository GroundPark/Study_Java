package com.javaStudy;

public class Operator1 {

	public static void main(String[] args) {
		// TODO 연산자 기본 예제
		System.out.printf("10 == 10.0f > %b%n", 10==10.0f);	//int와 float 비교이므로 int를 float으로 자동 변환해 비교한다
		System.out.printf("'0' == 0 > %b%n", '0'==0);		//문자형 0와 정수형 0은 다르다
		System.out.printf("0.1 == 0.1f > %b%n", 0.1==0.1f);	//실수형f는 근사값으로 저장해서 오차가 생김
		
		float f = 0.1f;
		double d = 0.1;
		System.out.println();
		System.out.printf("float 0.1 == double 0.1 > %b%n", f == d);
		System.out.printf("float 0.1 == (float)double 0.1 > %b%n", f == (float)d);
		//정밀도 차이에 의해 float, double은 미세한 차이가 남. 제대로 비교하려면 큰거에서 작은걸로 변환후 해야함. (7자리까지 가능) 
		System.out.println();
		
		String str1 = "abc";
		String str2 = new String("abc");
		
		System.out.printf("str1==\"abc\" > %b%n", str1=="abc");
		System.out.printf("str2==\"abc\" > %b%n", str2=="abc");
		// 위에는 문자열 리터럴 "abc"의 [주소]가 str1에 저장되었고
		// 아래에는 String 인스턴스를 새롭게 생성한것이다. 아래는 "abc"와 비교하면 객체가 다르므로 false가 나옴
		System.out.println("-----");
		
		System.out.printf("str1.equals(\"abc\") > %b%n", str1.equals("abc"));
		System.out.printf("str2.equals(\"abc\") > %b%n", str2.equals("abc"));
		System.out.printf("str2.equalsIgnoreCase(\"ABC\") > %b%n", str2.equalsIgnoreCase("ABC"));
		// 문자열 내용 비교할때는 그냥 equals 사용 추천, 대소문자 구분없이하려면 equalsIgnoreCase
	}

}
