package com.javaStudy;

public class Variable1 {
	public static void main(String[] args) {
		// TODO 변수 기본 예제
		
		System.out.println(""+7+7); 	
		System.out.println(7+7+""); 	
		// 빈문자열 "" 을 더하면 문자열이 된다. 
		// 연산 여부는 왼>오 순이므로 빈문자열""을 기준으로 왼쪽에 있으면 연산하고 String, 오른쪽에 있으면 String 끼리있으므로 연산 안함
		
		System.out.println("-----------");
		
		byte b = 1;
		short s = 2;
		char c = 'A';
		int i = 10;
		long l = 100000000000L;
		long hex = 0xFFFF_FFFF_FFFF_FFFFL;
		
		int octNum = 010;	//8진수 10, 10진수 변환시 8
		int hexNum = 0x10;	//16진수 10, 10진수 변환시 16
		int binNum = 0b10;	//2진수 10, 10진수 변환시 2
		
		System.out.printf("b=%d%n", b);
		System.out.printf("s=%d%n", s);
		System.out.printf("c=%c, int c=%d%n", c, (int)c); // 문자형 A는 정수형으론 아스키코드 65임
		System.out.printf("l=%d%n", l);
		System.out.printf("hex=%#x%n", hex);	//#은 접두사 (여기선 0x)
		System.out.printf("octNum 010 > 8진수=%o > 10진수=%d%n", octNum, octNum);
		System.out.printf("hexNum 0x10 > 16진수=%x > 10진수=%d%n", hexNum, hexNum);
		System.out.printf("binNum 0b10 > 2진수=%s >  10진수=%d%n", Integer.toBinaryString(binNum), binNum); 
		// binNum은 2진수인데 지시자가 없어서 표현법이 toBinaryString으로 String형 표현밖에 할수없음
		
	}

}
