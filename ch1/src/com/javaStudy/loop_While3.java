package com.javaStudy;
import java.util.*;

public class loop_While3 {

	public static void main(String[] args) {
		// TODO 반복해서 숫자 입력받은걸로 합계를 내는 예제, 반복은 0 입력시 종료됨
		int num;
		int sum = 0;
		boolean flag = true;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("합계를 구할 숫자 입력, 0입력시 종료");
		
		while(flag) {
			String tmp = scanner.nextLine();
			num = Integer.parseInt(tmp);
			
			if(num!=0) {
				sum += num;
			}
			else {
				flag = false;
			}
		}
		System.out.println("합계 : " +sum);
	}

}
