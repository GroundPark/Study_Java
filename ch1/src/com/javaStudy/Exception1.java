package com.javaStudy;

public class Exception1 {

	public static void main(String[] args) {
		// TODO 예외처리 예제
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/0);
			System.out.println(4); //실행안됨
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("catch에서 받음 >> " +e.getMessage());
			//예외처리 메세지를 출력하는 주요 2개 메서드
		}
	}

}
