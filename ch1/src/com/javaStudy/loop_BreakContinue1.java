package com.javaStudy;

public class loop_BreakContinue1 {

	public static void main(String[] args) {
			    // TODO 1~i까지 더할때 누적 합계가 100을 넘을때의 처음 i값은?
				int sum2 = 0, i2 = 0;
				
				while(true) {
					if(sum2 > 100)
						break;
					 
					++i2;
					sum2 += i2; 
				}
				System.out.printf("1부터 %d 까지 누적합계가 %d 이므로 100을 처음 넘음%n", i2, sum2);
				System.out.println("-----------");
				
				// TODO 1~10까지 숫자중 3의 배수는 제외해 출력
				
				for(int i=0;i<=10;i++) {
					if(i%3==0)
						continue;
					System.out.println(+i);
				} // 3의배수라면.. continue에 의해 println이 무시되고 다시 반복함
	}

}
