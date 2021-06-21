package com.javaStudy;

public class ArrayQ15 {

	public static void main(String[] args) {
		// TODO 객체 배열 생성 간단 예제
		
		Tv [] tvArr = new Tv[3];
			// Tv 객체 배열 생성
		
		for(int i=0;i<tvArr.length;i++) {
			tvArr[i] = new Tv();
			tvArr[i].channel = i+10;
			// Tv객체를 new하고 .. Tv 객체 배열에 넣고.. 채널 지정
		}
		
		for(int i=0;i<tvArr.length;i++) {
			tvArr[i].channelUp();
			System.out.printf("tvArr[%d]=%d%n",i,tvArr[i].channel);
		}
	}
}

class Tv{
	int channel;
	static String madeBy = "Korea";
	
	void channelUp() {	
			String SP = "Skt";
			++channel;	
		}
}