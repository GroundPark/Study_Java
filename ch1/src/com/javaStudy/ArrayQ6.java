package com.javaStudy;

public class ArrayQ6 {

	public static void main(String[] args) {
		// TODO Array로 버블 정렬 구현
		
		int [] Arr = new int[10];
		
		System.out.print("버블 정렬 할 랜덤수 : ");
		for(int i=0;i<Arr.length;i++) {
			System.out.print(Arr[i] = (int)(Math.random() * 10));
		}
		System.out.println();
		// 랜덤수를 배열로 만든다
		
		for(int i=0;i<Arr.length-1;i++) {
			boolean isChanged = false;
			
			for(int j=0;j<Arr.length-1-i;j++) {
				if(Arr[j] > Arr[j+1]) { // 오른쪽값이 작으면 서로 바꿈
					int temp = Arr[j];
					Arr[j] = Arr[j+1];
					Arr[j+1] = temp;
					isChanged = true; //자리바꾸는 if문을 거쳤으면 T하고 반복, 안거쳤으면 F 유지 상태에서 빠져나감
				}
			}
			if(isChanged == false) //자리바꿈 없으면 끝냄
				break;
			
			for(int k=0;k<Arr.length;k++)
				System.out.print(Arr[k]);
			System.out.println();
		}
	}
}
