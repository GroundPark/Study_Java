package com.javaStudy;
import java.util.*;

public class Scanner2 {

	public static void main(String[] args) {
		// TODO Scanner 문자 입력 및  숫자or문자 판별
		Scanner scanner = new Scanner(System.in);
		char ch = ' ';
		
		System.out.println("문자(숫자,영어)만 입력하세요");
		
		String input = scanner.nextLine();
		ch = input.charAt(0);
		// 입력 내용 input에 저장하고.. String 형이므로 char형으로 변환하고 첫번째(0)에 있는걸 넣음
				
		if('0'<=ch && ch <='9')
			System.out.println("입력문자는 숫자임");
		
		if(('a'<=ch && ch <='z') ||  ('A'<=ch && ch <='Z'))
			System.out.println("입력문자는 문자임");
	}

}
