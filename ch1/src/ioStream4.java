import java.io.*;

public class ioStream4 {

	public static void main(String[] args) {
		// TODO 커맨드라인 args 0 파일의 내용을 그대로 1 파일로 복사하는 예제
		try {
			FileInputStream  FinputS = new FileInputStream(args[0]);
			FileOutputStream FoutputS = new FileOutputStream(args[1]);
			
			int data = 0;
			
			while( (data = FinputS.read()) != -1) {
				FoutputS.write(data);
			}
			
			FinputS.close();
			FoutputS.close();
			
		}catch(IOException e) { e.printStackTrace(); }
		
	}

}

// IDE에서 args 입력 >> D:\Study_Java\ch1\src\ioStream4.java D:\Study_Java\ch1\src\FileCopyEx.bak