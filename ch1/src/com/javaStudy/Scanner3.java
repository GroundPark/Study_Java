package com.javaStudy;
import java.util.*;

public class Scanner3 {

	public static void main(String[] args) {
		// TODO Scanner 숫자 입력 및 조건 판별
		Scanner scanner = new Scanner(System.in);
		int input;
		
		System.out.println("숫자 입력");
		
		String tmp = scanner.nextLine();
		input = Integer.parseInt(tmp);
		
		if(input == 0)
			System.out.println("입력숫자는 0");
		
		if(input != 0) { //또는 else만 써도됨
			System.out.println("입력숫자는 0이 아님");
			System.out.printf("입력숫자는 %d임", input);
		}
			
		
	}

}
