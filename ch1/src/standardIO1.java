import java.io.*;
public class standardIO1 {

	public static void main(String[] args) {
		// 표준입출력 : 콘솔을 통한 데이터 입력/출력
		// System.in : 입력   <>  System.out/System.err : 출력
		
		// TODO 입력한 문자열의 char 보기
		System.err.println("err은 out 결과차이는 없음");		// redirection안되므로 출력결과가 다른 결과물(파일)등에 출력안됨
		try {
			int input = 0;
			while( (input=System.in.read()) != -1) {
				System.out.println("아스키코드 input : " +input +"  char input : "+(char)input);
			}
			
		}catch(IOException e) { e.printStackTrace(); }
	}
	// 아스키코드에 해당하는 char만 쓰고... 종료는 ctrl+z로 할것
	// enter, 종료전까지 블락킹 상태... enter시 입력대기상태에서 벗어나 입력 데이터 읽고 다읽으면 입력 대기상태... 종료시 -1 반환하여 while문 벗어남
}
