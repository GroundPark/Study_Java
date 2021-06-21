import java.io.*;

public class ioStream5 {

	public static void main(String[] args) {
		// TODO 바이트기반의 보조 스트림
		// 계층도 : I/OputStream -> FilterI/OStream(보조) -> 모든 보조 스트림
		
		// BufferedI/OStream : 버퍼(바이트배열)를 사용하는 보조스트림. 한 바이트씩 IO하는것보다 버퍼라는 바구니로 IO하는게 빠름
		// BufferedInputStream  : 읽기위한 버퍼 크기는 보통 소스가 파일인 경우 8K 크기로 함. 
		// BufferedOutputStream : 쓰기위한 버퍼는 '가득차야' 출력 소스에 출력함
		
		try {
			FileOutputStream FoutputS = new FileOutputStream("D:/Study_Java/ch1/src/FileoutputStreamTest.txt");
			BufferedOutputStream BoutputS = new BufferedOutputStream(FoutputS, 5);
			
			for(int i='1';i<'9';i++) {
				BoutputS.write(i);
				// 1byte 기반 I/O(바이트 스트림)을 지원하는데 아스키코드 기반 데이터를 사용 (이를 기반으로 문자기반 스트림을 만듬)
				// write()에서 아스키코드 49를 파일에 write하므로 각종 응용프로그램에서 아스키코드 49의 char인 1 이 보임
				// 만약 문자나 아스키코드를 생각안하고 그냥 int 1을 write한다치면... 아스키코드 1의 char인 [SOH] 제어명령이 출력
			}
			BoutputS.close();
			// close() : flush() 호출하여 버퍼의 모든 내용을 출력하고 버퍼를 비우고... 해당 스트림 인스턴스가 사용하던 모든 자원 반환 
			// BoutputS 닫기전에 FoutputS.close(); 을 써서 바로 기반스트림을 닫으면... 보조 스트림의 버퍼에 있는 값은 출력되지않음 
		}catch(IOException e) { e.printStackTrace(); }
	}

}
