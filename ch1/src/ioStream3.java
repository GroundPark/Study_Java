import java.io.*;

public class ioStream3 {
	
	public static void main(String [] args) throws IOException {
		// TODO File(I/O)Stream : 파일에 입출력 하기 위한 스트림
		// 커맨드라인으로 입력받은 파일의 내용을 읽어 출력함
		FileInputStream FInputS= new FileInputStream(args[0]);
		int data = 0;
		
		while( (data = FInputS.read()) != -1) {
			char c = (char) data;		
			// read 반환에서 int(4byte)지만... -1,0~255 (1byte) 정수값만 있어서... char(2byte)로 캐스팅해도 문제없음
			System.out.print(c);
		}
	}
}
