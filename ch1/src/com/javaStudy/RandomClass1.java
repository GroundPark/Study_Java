package com.javaStudy;
import java.util.*;

public class RandomClass1 {

	public static void main(String[] args) {
		Random rand1 = new Random(2313);
		//Random()에 seed를 넣을수도 있다. 기본값으로의 seed는 천분의 1초단위로 계속 바뀌면서 난수를 만듬
		//seed가 같은 난수는 항상 같은 값을 가짐
		
		System.out.println(rand1.nextInt(6));
		//nextInt는 0~n사이 정수 반환
		
		int num = (int)(Math.random() * 6) + 1;
		//1~6사이 난수
	}

}
