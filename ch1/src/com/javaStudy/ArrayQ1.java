package com.javaStudy;

public class ArrayQ1 {

	public static void main(String[] args) {
		// TODO 배열에 저장된 값의 총점과 평균(~소수점첫째)을 구하라
		int sum = 0;
		float avg = 0.0f;
		
		int [] score = {10, 20, 50, 80, 60};
		
		for(int i=0;i<score.length;i++) {
			sum += score[i];
		}
		
		avg = sum / (float)score.length;
		//score.length는 int니까 캐스팅 해줘야함
		
		System.out.println("총점" +sum +"  평균:" +avg);
	}

}
