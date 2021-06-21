package com.javaStudy;
import java.util.regex.*;
public class regex3 {

	public static void main(String[] args) {
		// TODO 정규식 이용해 문자열 소스 바꾸기
		
		String source = "새로 온 사람은 박형식, 2층의 박형식은 4층으로 오세요";
		String pattern = "박형식"; // 바꾸고 싶은 패턴
		StringBuffer sb = new StringBuffer();
		
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(source);
		System.out.println("소스 문자열 : "+source);
		
		int i=0;
		
		while(m.find()) {
			System.out.println(++i +"번째 매칭 : " +m.start() +"부터 " +m.end() +"까지");
			m.appendReplacement(sb, "박지상"); // 바꿀 내용
		}
		
		m.appendTail(sb);
		//맨 마지막 치환 이후 부분을 sb에 append함
		System.out.println("바꾼 횟수 : " +i +"번");
		System.out.println("바꾼 문자열 : " +sb.toString());
	}
}
