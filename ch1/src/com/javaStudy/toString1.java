package com.javaStudy;

public class toString1 {

	public static void main(String[] args) {
		// TODO toString 메서드는 인스턴스에 대한 정보를 문자열으로 제공할 목적으로 정의함
		String str1 = new String("KOREA");
		ASDF str2 = new ASDF("KOREA");
		zxcv str3 = new zxcv("KOREA");
		
		System.out.println(str1.toString());
		System.out.println(str2.toString());
		//특별히 toString을 건들지않아 Object의 기본 toString이 사용돼 주소값이 나옴
		System.out.println(str3.toString());
	}
}

class ASDF{
	String asdf = "";

	ASDF(String asdf){
		this.asdf = asdf;
	}
}

class zxcv{
	String zxcv = "";

	zxcv(String zxcv){
		this.zxcv = zxcv;
	}
	public String toString() {
		return "zxcv의 string : " +zxcv;  
	}
	//기본적인 class에서 toString을 오버라이딩하는 예
}