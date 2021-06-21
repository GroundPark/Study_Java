package com.javaStudy;

public class loop_While {

	public static void main(String[] args) {
		// TODO 숫자중 3배수가 있으면 그 개수만큼 박수치는 369게임
		for(int i=1;i<=39;i++) {
			System.out.printf("i=%d : ", i);
		
		int tmp = i;
		
		do {
			if(tmp%10%3==0 && tmp%10!=0)
			//tmp%10이 끝자리가 3의 배수인지 확인 && 0이 아님			
				System.out.print("짝");
		}while((tmp/=10)!=0);
			//while로 마지막 자리수일때 제한을 검 : 10보다 작은수라면 tmp/10이 0이 됨
			//예를들어 39면 do에서 짝, while에서 한번 더 돌고 9에서 짝으로 : 짝짝 
		System.out.println();
		}
	}

}
