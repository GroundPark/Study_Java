package com.javaStudy;
import java.util.*;

public class Scanner1 {

	public static void main(String[] args) {
		// TODO Scanner 숫자만 입력 및 출력
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("숫자만 입력하세요");
		
		String input = scanner.nextLine();
		int num = Integer.parseInt(input);
		// 입력 내용 input에 저장하고.. String 형이므로 정수형으로 변환함
				
		System.out.println("입력내용 : " +input);
		System.out.println("num : " +num);
	}

}
