import java.io.*;
public class ReaderWriter2 {

	public static void main(String[] args) {
		// TODO 파일의 공백을 없애는 예제. 파일을 read > 데이터를 조건에 맞춰 write
		try {
			FileReader FReader = new FileReader(args[0]);
			FileWriter FWriter = new FileWriter(args[1]);
			
			int data = 0;
			while( (data=FReader.read()) != -1) {
				if( data != ' ' && data != '\n' && data != '\r' && data != '\t'  )       
					FWriter.write(data);
				// 공백, 줄바꿈 r/n, 탭 빼고 write
			}
			
			FReader.close();
			FWriter.close();
		}catch(IOException e) { e.printStackTrace(); }
	}

}
