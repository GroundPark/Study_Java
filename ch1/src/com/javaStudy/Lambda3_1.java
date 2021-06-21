package com.javaStudy;

import java.util.*;
import java.util.function.*;

public class Lambda3_1 {

	public static void main(String[] args) {
		// 함수형 인터페이스는 매개변수-반환값이 지네릭 타입이라 기본형 타입 값도 래퍼 클래스 사용함
		// 효율을 위해서 '기본형을 사용하는 함수형 인터페이스'가 제공됨
		IntSupplier s = () -> (int)(Math.random() * 100) + 1;  // 1~100까지 랜덤수  
		IntConsumer c = i -> System.out.print(i+" , ");		 // 공백과 쉼표 
		IntPredicate p = i -> i%2 == 0;						 // 짝수인지 아닌지
		IntUnaryOperator op = i -> i/10*10;  				 // 일의 자리 없앰
		// ! unary(단항), binary(이항), ternary(삼항)
		// UnaryOperator : Function에서 단지 매개변수, 반환값 타입을 일치시킨것 
		
		int [] arr = new int[10];
		makeRandomList(s, arr);
		System.out.println("랜덤값 list : " +Arrays.toString(arr));
		
		System.out.print("list에서 짝수 값 출력 : ");
		printEvenNum(p,c,arr);
		System.out.println();
		
		int [] newArr = onesFloor(op, arr);
		System.out.println("list의 각각의 값에서 일의 자리를 0으로 만듬 : "+Arrays.toString(newArr));
	}
	
	static void makeRandomList(IntSupplier s, int [] arr) {
		for(int i=0;i<arr.length;i++) {
			arr[i] = s.getAsInt();  
		}
	} // IntSupplier의 getAsInt() 사용. (get()뒤에 AsInt붙임)
	
	static void printEvenNum(IntPredicate p, IntConsumer c, int [] arr) {
		for(int i : arr) {
			if(p.test(i))
				c.accept(i);
		}
	} 
	
	static int[] onesFloor(IntUnaryOperator op, int [] arr){
		int [] newArr = new int[arr.length];
		
		for(int i=0;i<newArr.length;i++) {
			newArr[i] = op.applyAsInt(arr[i]);  //(apply()뒤에 AsInt붙임)
		}
		return newArr;
	} 
}

