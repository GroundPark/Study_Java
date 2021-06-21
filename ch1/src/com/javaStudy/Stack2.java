package com.javaStudy;
import java.util.*;
public class Stack2 {
	//TODO : Stack을 이용해 입력한 수식의 괄호가 올바른지 체크한다
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Usage : 커맨드 라인에 java Stack2 \"EXPRESSION\" 을 칩니다");
			System.out.println("example : java Stack2 ((2+3)*2 ");
			System.exit(0);
		}
		
		Stack mySt = new Stack();
		String expression = args[0];
		
		System.out.println("expression:"+expression);
		
		try {
			for(int i=0; i<expression.length();i++) {
				char ch = expression.charAt(i);
				
				if(ch=='(') {
					mySt.push(ch+"");
				}else if(ch==')') {
					mySt.pop();
				}
				//  '(' 면 스택에 push ')' 면 pop
			}
				if(mySt.isEmpty()) {
					System.out.println("괄호가 일치함 : stack is empty");
					// 정상적이라면 push 와 pop에 의해 mySt가 비어져있으므로 일치함  ex :(2+3)*2
				}else {
					System.out.println("괄호가 일치하지않음 : stack is existed");
					// push가 많고 pop이 적어서 stack이 비어있지않는 경우 ex:((2+3)*2
				}
			}catch(EmptyStackException e) {
				System.out.println("괄호가 일치하지 않음 : no stack for push");
				// pop을 해야되지만 push가 없어서 안되는 경우(!exception) ex:(2+3)*2)
		}	
	}
}