package com.javaStudy;

public class getClass1 {

	public static void main(String[] args) throws Exception {
		// TODO getClass() 메서드는 Class 객체를 반환한다
		// .class 파일을 읽어서 사용하기 편한 형태로 저장해놓음
		
		Card3 c1 = new Card3("heart", 6);
		Card3 c2 = Card3.class.newInstance();
		//Class객체를 통해 객체 생성 (Exception 처리해야함)
		
		Class cObj = c1.getClass();			//객체로부터 얻음
	  //Class cObj = c1.class;				//클래스 리터럴로 얻음
	  //Class cObj = Class.forName("c1");	//클래스 이름으로 얻음
		
		System.out.println(c2);
		System.out.println(cObj.getName());
	}
}

class Card3{
	String kind;
	int num;
	
	Card3(){
		this("defalut", 0);
	}
	
	Card3(String kind, int num){
		this.kind = kind;
		this.num = num;
	}
	
	public String toString(){
		return "카드는 "+kind+"숫자는 "+num;
	}
}