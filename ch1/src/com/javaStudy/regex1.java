package com.javaStudy;
import java.util.regex.*;
public class regex1 {

	public static void main(String[] args) {
		// TODO Regular-Expression 정규식 : 텍스트 데이터 중 원하는 패턴과 일치하는 문자열을 찾아내기 위함
		// 정규식 패턴이 많음 (p507)
		String [] data = {"cover", ".com", "combat", "disc", "lotto"};
		
		Pattern p = Pattern.compile("c[a-z]*"); //c로시작하는 소문자 
		
		for(int i=0;i<data.length;i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches())
				System.out.print(data[i] + ",");
		}
	}

}
