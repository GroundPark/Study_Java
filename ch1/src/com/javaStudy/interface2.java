package com.javaStudy;

public class interface2 {

	public static void main(String[] args) {
		// TODO 인터페이스를 이용한 다중상속 예제

	}

}

class Tv2{
	protected boolean power;
	
	public void power()	{ power = !power;	}
}

class VideoTv2{
	protected int counter;
	
	public void play() {
		//재생 구현
	}
}

// Tv와 VideoTv 두 클래스로 부터 상속을 받아 enhancedTv를 구현하고싶으나 자바에선 다중상속이 안됨
// 이럴땐 한쪽만 선택해 상속하고.. 다른 한쪽은 클래스 내에 포함 시키고.. 내부적으로 인스턴스를 생성해 사용해야함

interface tempTv2{
	public void play();
}

class enhancedTv2 extends Tv2 implements tempTv2{
	VideoTv2 myVTv2 = new VideoTv2();
	public void play() {
		myVTv2.play();
	}
}