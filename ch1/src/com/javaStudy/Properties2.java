package com.javaStudy;
import java.util.*;
import java.io.*;

public class Properties2 {

	public static void main(String[] args) {
		// TODO 외부파일 (PropertiesData.txt)로부터 데이터 입력받아서 계산, 결과를 보여주는 예제
		// 해당 파일엔 name=    , data=1,2,3   형태로 있으므로
		if(args.length != 1) {
			System.out.println("! No commandLine");
			System.exit(0);
		}
		
		Properties p = new Properties();
		String inputFile = args[0];
		
		try {
			p.load(new FileInputStream(inputFile));
		}catch(IOException e) {
			System.out.println("! Data file Not found");
			System.exit(0);
		}
		
		String name = p.getProperty("name");
		try {
			name = new String(name.getBytes("8859_1"), "EUC-KR");
		}catch(Exception e) {}
		// 인코딩 문제로 추가한 try-catch문... 기술적 코드이므로 넘겨도됨
		
		String [] data = p.getProperty("data").split(",");
		int max = 0, min = 0, sum = 0;
		
		for(int i=0;i<data.length;i++) {
			int intValue = Integer.parseInt(data[i]);
			if(i==0) { max = min = intValue; }
			if(max < intValue)
				max = intValue;
			else if (min > intValue)
				min = intValue;
			// 처음엔 0인 최대, 최소값을 비교함(0은 그냥 0처리) ... 처음엔 max 비교하고... else는 min이므로 min 비교함		
			sum += intValue;	
		}
		System.out.println("이름 : " +name);
		System.out.println("max : " +max);
		System.out.println("min : " +min);
		System.out.println("sum : " +sum);
		System.out.println("avg : " + (sum * 100.0 / data.length) / 100);
	}

}
