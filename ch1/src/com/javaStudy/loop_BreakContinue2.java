package com.javaStudy;

public class loop_BreakContinue2 {

	public static void main(String[] args) {
		// TODO 반복문에 이름을 붙여서 반복시키는 예제 (실행전 각 경우에 따라 주석사용 할것)
		myLoop : for(int i=2;i<=9;i++) {
			for(int j=1;j<=9;j++) {
				if(j==5)
					//break myLoop;
					//myLoop if문에 break하므로 2단의 *4까지 나옴
					
					//break;
					//if조건에 break하므로 2~9단 각각 *5까지 나옴
					
					//continue myLoop;
					//myLoop if문에 continue하면서 줄바꾸는 println이 무시됨
				
					//continue;
					//if 조건에 나온 printf만 무시되므로 *5만 무시됨
				System.out.printf("%d * %d = %d%n", i,j,i*j);
			}
			System.out.println();
		}
	}

}
