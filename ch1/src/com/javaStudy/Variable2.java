package com.javaStudy;

public class Variable2 {

	public static void main(String[] args) {
		// TODO 변수 기본 예제
		
		String s = "정렬 예제";
		
		float f1 = .10f;	// 0.10 , 1.0e-1
		float f2 = 1e1f;	// 10.0 , 1.0e1, 1.0e+1
		float f3 = 3.14e3f;
		double d = 0.12345678;
		
		System.out.printf(".10f의 표현 > %%f:%f, %%e:%e, %%g:%g%n", f1, f1, f1);
		System.out.printf("1e1f의 표현 > %%f:%f, %%e:%e, %%g:%g%n", f2, f2, f2);
		System.out.printf("3.14e3f의 표현 > %%f:%f, %%e:%e, %%g:%g%n", f3, f3, f3);
		// 실수형 값 출력에 주로 %f, 지수형태로 %e, 간략한 형태로 %g를 씀
		System.out.println();
		
		System.out.printf("0.12345678의 표현 > %%f:%f%n",d);
		System.out.printf("0.12345678의 소수점 표현 > %%14.10f : %14.10f%n",d);
		// %f는 소수점 아래 6자리까지만 출력하므로 7자리에서 반올림 (정밀도 7이라서)
		// %전체자리수.소수점아래자리로 자리수 지정가능 (단, 소수점 아래자리수 빈자리는 0으로 채우고 남는건 앞부분에 공백으로 채움)
		System.out.println();
		
		System.out.printf("[%s]%n",s);
		System.out.printf("[%10s]%n",s);	//10글자 만큼 출력공간 확보 및 우측 정렬
		System.out.printf("[%-10s]%n",s);	//10글자 만큼 출력공간 확보 및 좌측 정렬
		System.out.printf("[%.2s]%n",s);	//왼쪽에서 2글자 출력
		
	}

}
