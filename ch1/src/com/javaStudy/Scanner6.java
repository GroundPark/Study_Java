package com.javaStudy;
import java.util.*;
public class Scanner6 {

	public static void main(String[] args) {
		// TODO 라인단위로 입력받은 내용을 공백을 구분자로 나눠 출력하는 예제
		
		Scanner s = new Scanner(System.in);
		String [] argArr = null;
		
		while(true) {
			String prompt = ">>";
			System.out.print(prompt);
			
			String input = s.nextLine(); // 라인 단위로 입력
			
			input = input.trim();  // 앞뒤 공백 제거
			argArr = input.split(" +"); //문자열 안쪽의 " +"[하나 이상의 공백을]을 구분자로 자른다
			
			String command = argArr[0].trim(); // 공백제거

			if("".equals(command)) continue; // 아무것도 안쳤을때 계속됨
			
			command = command.toLowerCase(); //명령어를 소문자로 바꿈
			if(command.equals("q")) { //q누르면 종료, 대문자 Q를 써도 종료됨
				System.exit(0);
			}else {
				for(int i=0;i<argArr.length;i++) 
					System.out.println(argArr[i]);
			}
		}
	}
}