package com.javaStudy;

public class initQ1 {

	public static void main(String[] args) {
		// TODO 파일 이름 지정/미지정하고 생성할때 이름 부분 처리 코드 (미지정할땐 제목없음+숫자 형식)
	
		Document1 d1 = new Document1();
		Document1 d2 = new Document1("p_2514.jpg");
		Document1 d3 = new Document1();
		Document1 d4 = new Document1();	
	}
}	
	
class Document1{
	
	static int count = 0;
	String name;
	
	Document1(){
		this("제목없음" + ++count);
		//매개변수가 없다면 미지정했을때
	}
	
	Document1(String name){
		this.name = name;
		System.out.println(this.name + "파일이 생성됨");
	}
}