import java.io.*;
public class ReaderWriter6 {

	public static void main(String[] args) {
		// InputStreamReader, OutputStreamWriter : 바이트기반 스트림을 문자기반 스트림으로 연결해줌, 바이트기반 스트림 데이터를 지정된 인코딩의 문자데이터로 변환함
		// 인코딩 지정안하고 파일을 read,write할때 OS의 기본값을 따르므로 원치않는 인코딩이 나올수 있음
		// TODO OS 인코딩을 기반으로 입력, 출력하는 예제 (사실 Scanner쓰면 됨)
		String line = "";
		
		try {
			InputStreamReader isReader = new InputStreamReader(System.in);
			BufferedReader bReader = new BufferedReader(isReader);
			
			System.out.println("OS의 인코딩 : "+isReader.getEncoding());
			
			do {
				System.out.println("문장을 입력, 종료는 q");
				line = bReader.readLine();
				System.out.println("입력 문장 : "+line);
			}while(!line.equalsIgnoreCase("q"));
		}catch(IOException e) { e.printStackTrace(); }
	}

}
