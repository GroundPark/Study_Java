import java.io.*;
public class ReaderWriter1 {

	public static void main(String[] args) {
		// java에서 한 문자 char형이 2byte이므로 바이트 기반 스트림에서 문자를 처리할때 1byte씩 처리하는데 무리가 있음
		// 문자기반 스트림 : 문자 데이터 입출력할때 사용
		// Reader로 특정 인코딩을 자바에서 사용하는 유니코드(UTF-16)으로... Writer로 유니코드를 특정 인코딩으로 변환함 
		
		// TODO 바이트기반 스트림과 문자기반 스트림의 차이
		try {
			String charFile = "D:/Study_Java/ch1/src/testCharData.txt";		// 여기서 .txt는 기본값 ANSI에서 UTF-8로 저장된 상태임
			FileInputStream FinputS = new FileInputStream(charFile);
			FileReader FReader = new FileReader(charFile);
			
			int data = 0;
			while( (data=FinputS.read()) != -1 ) {
				System.out.print((char)data);
			}
			System.out.println();
			FinputS.close();
			
			while( (data=FReader.read()) != -1) {
				System.out.print((char)data);
			}
			System.out.println();
			FReader.close();
			
		}catch(IOException e) { e.printStackTrace(); }
	}

}
