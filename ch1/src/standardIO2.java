import java.io.*;
public class standardIO2 {

	public static void main(String[] args) {
		// setIn(), setOut(), setErr()을 사용해 입출력을 콘솔 이외에 다른 입출력 대상으로 변경함
		// TODO setOut()으로  출력 대상 변경 및 System.out/err의 차이
		
		PrintStream PStream = null;
		FileOutputStream FoutputS = null;
		
		try {
			FoutputS = new FileOutputStream("D:/Study_Java/ch1/src/Sysout_to_txtFile.txt");
			PStream = new PrintStream(FoutputS);
			System.setOut(PStream);
		}catch(FileNotFoundException e) { 
			System.err.println(" File not Found ");
		}
		
		System.out.println("System.out에서의 출력");
		System.err.println("System.err에서의 출력");
	}

}

// 또는 커맨드라인에서 System.out 출력을 설정할수도있음.
// java standardIO2 < input.txt 
// java standardIO2 > output.txt
// java standardIO2 >> output.txt (기존 내용에 추가)


 