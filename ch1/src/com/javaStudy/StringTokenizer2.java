package com.javaStudy;
import java.util.*; 

class StringTokenizer2 { 
	public static void main(String args[]) { 
		// TODO StringTokenizer 기본 예제
		String source = "1,전공,90,80,55|2,교양,48,92,83|";
		StringTokenizer st = new StringTokenizer(source,"|");
		
		while(st.hasMoreTokens()) {
			String token2 = st.nextToken();
			
			StringTokenizer st2 = new StringTokenizer(token2,",");
			while(st2.hasMoreTokens()) {
				System.out.println(st2.nextToken());
			}
		}
		//StringTokenizer을 2번써서 |과 ,을 처리함
		System.out.println("///////////////////////");
		
		String data = "100,,,200,300";
		String [] result = data.split(",");
		StringTokenizer st3 = new StringTokenizer(data,",");
		
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i]+"!");
		}
		System.out.println("토큰 개수 : " +result.length);
		// split은  100, , ,200,300 에서 공백도 토큰으로 취급
		
		int i =0;
		for(;st3.hasMoreTokens();i++) {
			System.out.print(st3.nextToken() + "!");
		}
		System.out.println("토큰 개수 : " +i);
		// StringTokenizer는 공백은 토큰 취급 안함
	}		
	
} 
