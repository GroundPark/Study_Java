package com.javaStudy;

public class polymorphism1 {
	public static void main(String[] args) {
		// 다형성 : 여러가지 형태를 가질 수 있는 능력
		// 자바에선 [조상클래스 타입의 참조변수로 자손클래스의 인스턴스를 참조할 수 있도록함]
		 
		testTv myTv = new protoTv(); 
		//상속 관계에있는 두 클래스는 다형성 적용이 가능하다 (부모  <= 자식)
		//반대의 경우는 에러남
		
		testTv tTv = null;
		protoTv pTv = new protoTv();
		protoTv pTv2 = new protoTv();
		
		pTv.channelUp();
		tTv = pTv;			// tTv = (tTv)pTv; 자손이 부모로 업 캐스팅을 함 (생략되어있다)
		//tTv.channelUp();  // 부모에선 '자손만의 내용'이 없으므로 안됨
		pTv2 = (protoTv)tTv;// 부모가 자손으로 다운 캐스팅함
		pTv2.channelUp();
	}

}

class testTv{
	String tvShow;
	
	void showTv() {	}
}

class protoTv extends testTv{
	int channel;
	
	void channelUp() { 
		++channel;  
		System.out.println(channel);
	}
}