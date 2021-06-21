package com.javaStudy;
import java.util.*;

public class RandomClass2 {

	public static void main(String[] args) {
		// TODO 0~9사이의 난수를 100개 만들고... 각 숫자의 빈도수 계산한뒤... 그래프를 그리는 예제
		Random rand = new Random();
		int [] num = new int[100];
		int [] counter = new int[10];
		
		for(int i=0;i<num.length;i++) {			
			System.out.print(num[i]=rand.nextInt(10));
		  //System.out.print(num[i]=(int)(Math.random() * 10));
		}
		System.out.println();
		
		for(int i=0;i<num.length;i++)
			counter[num[i]]++;
		//예를들어 5번째 자리 숫자1을 센다 : count[ num[4]=1 ]에서... count[?]의 기본값은 0이므로  후위++을하면 count하듯 구현할수 있다
		
		for(int i=0;i<counter.length;i++)
			System.out.println(i+"의 개수 : "+counter[i] +"개 " +printGraph('#',counter[i]));

	}
	public static String printGraph(char ch, int value) {
		char [] bar = new char[value];
		//bar 배열의 크기 = # 그리는 개수
		
		for(int i=0;i<bar.length;i++)
			bar[i] = ch;
		// 예를들어 counter[4]에서... 0~4까지의 배열에 #을 순서대로 반복해 넣는다...
		return new String(bar);
		// char 배열을 string 변환함으로써 연속된 #이 나옴
	}
}

