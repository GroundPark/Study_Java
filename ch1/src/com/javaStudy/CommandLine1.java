package com.javaStudy;

public class CommandLine1 {

	public static void main(String[] args) {
		// TODO 커맨드 라인을 통해 입력넣는 예제. 사칙연산 
		if(args.length != 3) {
			System.out.println("terminated : num op num 형식으로 쓰십시오. 예: 1 + 1 ");
			System.exit(0);
		}
		
		int num1 = Integer.parseInt(args[0]);
		char op =  args[1].charAt(0);
		int num2 = Integer.parseInt(args[2]);
		int result = 0;
		
		switch(op) {
			case '+' : 
				result = num1 + num2;
				break;
			case '-' :
				result = num1 - num2;
				break;
			case '*' :
				result = num1 * num2;
				break;
			case '/' :
				result = num1 / num2;
				break;
			default :
				System.out.println("지원하지 않는 연산인듯");
		}
		System.out.printf("%d %c %d = %d", num1, op, num2, result);
	}
}


