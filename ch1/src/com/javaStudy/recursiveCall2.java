package com.javaStudy;

public class recursiveCall2 {

	public static void main(String[] args) {
		// TODO 재귀호출을 이용해 x^1부터 x^n까지 합을 구하는 예제
		int x = 2;
		int n = 5;
		long result = 0;
		
		for(int i=1;i<=n;i++)
			result += power(x, i);
			//1부터 ~ n까지 반복시킴
		System.out.println("result : " +result);
	}
	
	static long power(int x, int n) {
		if(n==1) return x;
		
		return x * power(x, n-1);
		//예를들어 f(2,5)에서 2 * f(2,4) > 2 * 2 * f(2,3) ... 2*2*2*2*2 에서 2^5값이 나옴 
	}
}
