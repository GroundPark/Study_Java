package com.javaStudy;
import java.util.*; 

class StringTokenizer3 { 
	public static void main(String args[]) { 
		// TODO 한글로 된 수를 숫자로 바꾸는 예제
	
		String input = "육천오백사십이만사천이백육십오"; 
		System.out.println(input); 
		System.out.println(hangulToNum(input)); 
	} 
	
	public static long hangulToNum(String input) { 	
		long result = 0;     // 최종 결과
		long tmpResult = 0;  // 십백천 단위의 값을 저장하기 위한 임시변수
		long num = 0;  //십백천이 안붙는 자리 (일의자리)

		final String NUMBER = "영일이삼사오육칠팔구"; 
		final String UNIT   = "십백천만억조"; 
		final long[] UNIT_NUM  = {10,100,1000,10000,(long)1e8,(long)1e12}; 

		StringTokenizer st = new StringTokenizer(input, UNIT, true); 

		while(st.hasMoreTokens()) { 
			String token = st.nextToken(); 
			// ex) 육 천 만 팔 백
			int check = NUMBER.indexOf(token);	
            //  check = NUMBER.indexOf(육);   : 육을 NUMBER에서 찾고 인덱스 위치를 check에 저장	
			// 숫자인지, 단위(UNIT)인지 확인한다. ex) '육'천만팔백 >> '천'만팔백 
						
			if(check==-1) { // 첫자리에 숫자가 없다면...  ex) ''십만팔백, ''천백이십
				if("만억조".indexOf(token)==-1) { //만억조가 아니면...
					tmpResult += ( num != 0 ? num : 1) * UNIT_NUM[UNIT.indexOf(token)]; 
					// ex) 십만팔백의 경우 숫자없이 단위로 시작하므로 num값이 0이고 이는 단위값 곱해도 0이다.
					//     num이 0이 아니면 num, 0이면 1을 넣게하고 곱하기 해주면 됨
				} else {	//만억조가 있으면
					tmpResult += num; 
					result += (tmpResult != 0 ? tmpResult : 1) * UNIT_NUM[UNIT.indexOf(token)];
					tmpResult = 0; 
				} 
				num = 0; // 초기화
			} else {  // 숫자인 경우 ex) '육'천만팔백, '육'백
				num = check; 
			} 
		} 
		
		//ex) 육천오백사십이만사천이백육십오
		// result = 65420000       육천오백사십이만
		// tmpResult = 4260         사천이백육십오 
		// num = 5
		// result + tmpResult + num = 65424265 
		return result + tmpResult + num; 
	} 
} 
