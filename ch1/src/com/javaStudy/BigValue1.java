package com.javaStudy;
import java.math.*;
public class BigValue1 {

	public static void main(String[] args) {
		// TODO 정수 표현에 long타입 이상의 큰값을 다룰때 BigInteger를 씀
		// 2의보수형, 불변, 10의 60억제곱까지 가능
		BigInteger BI = new BigInteger("123456789000000000000");
		BigInteger BI2 = BigInteger.valueOf(1234567890L);
		// 비트연산으로 자주 처리됨
		
		// TODO 실수 표현에 double타입은 정밀도 문제가 있으므로 BigDecimal를 씀
		BigDecimal BD = new BigDecimal("123.45678");
		BigDecimal BD2 = BigDecimal.valueOf(123.45678);
		// 12.345은 12345*10^-3 이므로... intVal=12345 / scale=3 / precision=5
		
		// 단, 기본적 사칙연산에도 클래스의 메서드... 예를들자면b1.add(b2)와 같이 사용해야하고, 속도가 느림
	}

}
