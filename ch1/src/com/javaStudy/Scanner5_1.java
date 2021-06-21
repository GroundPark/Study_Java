package com.javaStudy;
import java.util.*;

public class Scanner5_1 {

	public static void main(String[] args) {
		// TODO switch-입력을 이용한 가위바위보 예제
		System.out.println("가위1 바위2 보3 중 하나 입력");
		Scanner scanner = new Scanner(System.in);
		
		int user = scanner.nextInt();
		int com = (int)(Math.random() * 3) + 1;
		
		System.out.printf("당신은 %d 컴퓨터는 %d%n", user, com);
		
		switch(user-com) {
			case -2: case 1:
				System.out.println("이겼음");
				break;
			case 0:
				System.out.println("비겼음");
				break;
			case -1: case 2:
				System.out.println("졌음");
				break; //마지막이니까 break; 안써도됨
		}
		//이길때 : -2,1 
		//비길때 : 0
		//질때 : -1,2	
	}
}
