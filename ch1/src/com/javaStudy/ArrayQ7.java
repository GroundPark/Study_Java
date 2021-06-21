package com.javaStudy;

public class ArrayQ7 {

	public static void main(String[] args) {
		// TODO 배열에 저장된 0~9의 숫자가 각각 몇 번 반복해서 나타나는지 출력
		
		int [] Arr = new int [10];
		int [] counter = new int [10];
		
		System.out.print("랜덤 수 : ");
		for(int i=0;i<Arr.length;i++) {
			Arr[i] = (int)(Math.random() * 10);
			System.out.print(Arr[i]);
		}
		System.out.println();
		// 랜덤 0~9숫자로 배열을 채움
		
		for(int i=0;i<Arr.length;i++) {
			counter[Arr[i]]++;
		}
		// counter의 idx에서 ++(1씩증가)를 해서 Arr의 각 자리 숫자의 개수를 구한다 
		
		for(int i=0;i<Arr.length;i++) {
			System.out.println(i +"의 개수 : " +counter[i]);
		}
		

	}

}
