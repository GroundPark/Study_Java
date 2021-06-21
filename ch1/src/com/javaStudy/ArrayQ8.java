package com.javaStudy;
import java.util.*;
public class ArrayQ8 {

	public static void main(String[] args) {
		// TODO char, String 배열을 이용해 16진수를 2진수로 변환하는 예제
		
		char [] hex = {'C', 'A', '4', '5'};
		String [] binary = {"0000", "0001", "0010" ,"0011" 
							,"0100", "0101", "0110", "0111"
							,"1000", "1001", "1010", "1011"
							,"1100", "1101", "1110", "1111"};
		
		String result = "";
		
		for(int i=0; i<hex.length;i++) {
			if(hex[i] >='0' && hex[i] <='9') {
				result += binary[hex[i]-'0'];
			//16진수 0~9 처리 : 정수형 idx가 필요해서 -'0' 연산을 함
			}else {
				result += binary[hex[i]-'A'+10];
			}
			//16진수 A~F 처리 : A~F에서의 아스키코드 - A의 아스키코드 65 + 10(0~9)을 한다 
		}
		System.out.println("hex : " +Arrays.toString(hex));
		System.out.println("binary : " +result);
		
	}

}
