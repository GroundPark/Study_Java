package com.javaStudy;
import java.util.regex.*;

public class regex2 {

	public static void main(String[] args) {
		// TODO 정규식 예제
		String source = "전번:010-3138-7133, 비상전번:02-271-6133";
		String pattern = "(0\\d{1,2})-(\\d{3,4})-(\\d{4})";
		
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(source);
		
		int i=0;
		while(m.find()) {
			System.out.println(++i +"번째 " +m.group() +"/" +m.group(1) +"/" +m.group(2) +"/" +m.group(3));
		}
		//find() 일치하는 패턴 있으면 T/없으면F
		//일치부분 찾고... 다시 호출하면 일치부분 다음부터 다시 매칭 시작
		
		//m.group(0)은 전체, m.group(1)은 첫번째 매칭, m.group(2)는 두번째 매칭... 순서
	}

}
