import java.io.BufferedReader;
import java.io.*;
import java.net.URL;

public class Network2_1 {
	public static void main(String[] args) {
		// TODO 이진 데이터를 읽어 파일에 저장함 (파일은 경로 설정 안했으므로 D:\Study_Java\ch1 에 있음)
		URL url = null;
		InputStream inputS = null;
		FileOutputStream FoutputS = null;
		String address = "https://upload3.inven.co.kr/upload/2020/07/26/bbs/i15179302937.png";
		int ch = 0;
		
		try {
			url = new URL(address);
			inputS = url.openStream();	
			FoutputS = new FileOutputStream("i15179302937.png");
			
			
			while( (ch=inputS.read()) != -1 ){
				FoutputS.write(ch);
			}
			inputS.close();
			FoutputS.close();
		}catch(Exception e) {e.printStackTrace();}

	}

}
