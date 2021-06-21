package com.javaStudy;

public class hashCode1 {

	public static void main(String[] args) {
		// TODO 해시함수를 구현한 hashCode 메서드 예제
		String str1 = new String("abc");
		String str2 = new String("abc");
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		//hashCode 메서드는 '값'으로 해시크도 생성해서 값같으면 같은 해시코드
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		//System.identityHashCode 는 '객체의 주소값'으로 해시코드를 생성해서 객체마다 항상 해시코드가 다름
	}

}
