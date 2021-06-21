package com.javaStudy;
import java.util.*;

public class Stack1 {
	// TODO : Stack을 이용한 뒤로가기, 앞으로가기 예제 
	// Stack에서 push는 저장, pop은 추출, LIFO 구조
	public static Stack back = new Stack();
	public static Stack forward = new Stack();
		
	public static void main(String [] args) {
		goURL("1. 네이버");
		goURL("2. 카카오");
		goURL("3. 구글");
		goURL("4. 유튜브");
		
		printstatus();
		
		goBack();
		System.out.println("뒤로가기를 눌렀습니다");
		printstatus();
		
		goBack();
		System.out.println("뒤로가기를 눌렀습니다");
		printstatus();
		
		goForward();
		System.out.println("앞으로가기를 눌렀습니다");
		printstatus();
		
		goURL("N. 나무위키");
		System.out.println("나무위키 URL 클릭");
		printstatus();
		
	}
	
	public static void goURL(String URL) {
		back.push(URL);
		if(!forward.empty())
			forward.clear();
		//새로운게 push하면 앞으로가기는 없어야함
		// 개체가 있어야 활성화, 비어있을때는 비활성하는 if문으로 제한을 둠
	}
	
	public static void goBack() {
		if(!back.empty())
			forward.push(back.pop());
		//뒤로가기 누르면 뒤로가기에 있던게 pop 되고 앞으로가기의 push로 이동
	}
	
	public static void goForward() {
		if(!forward.empty())
			back.push(forward.pop());
		//앞으로가기 누르면 앞으로가기에 있던게 pop 되고 뒤로가기의 push로 이동
	}
	
	public static void printstatus() {
		System.out.println("뒤로가기" +back);
		System.out.println("앞으로가기" +forward);
		System.out.println("현재화면은 " +back.peek() +"입니다");
		System.out.println();
	}
}
