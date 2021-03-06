import java.net.*;
import java.io.*;
public class Network2 {

	public static void main(String[] args) throws Exception {         // URL에서 예외
		// TODO URL(Uniform Resource Locator) : 인터넷에 존재하는 서버들이 제공하는 자원에 접근할 수 있는 주소를 표현하기 위한 것
		// 프로토콜://호스트명(:포트번호)/경로명/파일명(?쿼리스트링)(#참조)      ! ()는 생략가능
		
		/*  예제 URL 에서... http://www.naver.com:80/sample/main.html?id=mine&page3#idx1
		 *  프로토콜 : 통신에 사용되는 통신 규약 (http)
		 *  호스트명 : 자원 제공 서버의 이름 (www.naver.com)      
		 *  포트번호 : 서버의 포트번호 (http에서 80을 써서 거의 생략함)
		 *   경로명 : 자원이 저장된 서버상 위치 (/sample/)
		 *   파일명 : 자원의 이름 (main.html)
		 *   쿼리    : ? 이후 (id=mine&page3)
		 *   참조    : # 이후.. anchor라 부름 (idx1)
		 */
		
		URL testURL = new URL("http://www.naver.com:80/sample/main.html?id=mine&page3#idx1");
		
		System.out.println("toExternalForm : " +testURL.toExternalForm());
		System.out.println("getProtocol : " +testURL.getProtocol());
		System.out.println("getHost : " +testURL.getHost());
		System.out.println("getPort : " +testURL.getPort());
		System.out.println("getPath : " +testURL.getPath());
		System.out.println("getFile : " +testURL.getFile());
		System.out.println("getQuery : " +testURL.getQuery());
		System.out.println("getRef : " +testURL.getRef());
		System.out.println("///////////////////////////");
		
		
		// TODO URL에 연결해서 내용(소스)을 읽어오는 예제
		URL url = null;
		BufferedReader input = null;
		String address = "http://oldmidi.pe.kr/";
		String line = "";
		
		try {
			url = new URL(address);
			input = new BufferedReader(new InputStreamReader(url.openStream()));
			// openStream에서 url의 inputStream을 얻음. 문자데이터를 읽으므로 bufferedReader 사용 
			
			while( (line=input.readLine()) != null ){
				System.out.println(line);
			}
			input.close();
		}catch(Exception e) {e.printStackTrace();}
	}

}
