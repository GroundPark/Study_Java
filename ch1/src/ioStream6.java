import java.io.*;

public class ioStream6 {

	public static void main(String[] args) {
		// TODO DataI/OStream : 데이터 읽고 쓰는데 8가지 기본 자료형을 씀
		
		FileOutputStream FoutputS = null;
		DataOutputStream DoutputS = null;
		
		try {
			FoutputS = new FileOutputStream("D:/Study_Java/ch1/src/testData.dat");
			DoutputS = new DataOutputStream(FoutputS);
			
			DoutputS.writeInt(10);
			DoutputS.writeFloat(10.0f);
			DoutputS.writeBoolean(true);
			// 각 자료형을 16진수로 표현함 (binary data). 문자 data가 아니므로 일반 문서 편집기가 아닌 hex-viewer가 필요함
		}catch(IOException e) { e.printStackTrace(); }
	}

}
