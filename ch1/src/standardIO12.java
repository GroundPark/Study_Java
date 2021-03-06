import java.io.*;
public class standardIO12 {

	public static void main(String[] args) {
		// TODO args의 [파일]을 [지정크기 (KB)]로 잘라 나누는 예제
		
		if(args.length != 2) {
			System.out.println(" usage : FILE SIZE(KB)");
			System.exit(0);
		}
		
		final int VOLUME = Integer.parseInt(args[1]) * 1000;
		// 1KB = 약 1000 byte
		
		try {
			String filename = args[0];
			
			FileInputStream FinputS = new FileInputStream(filename);
			BufferedInputStream BinputS = new BufferedInputStream(FinputS);
			
			FileOutputStream FoutputS = null;
			BufferedOutputStream BoutputS = null;
			
			int data = 0;
			int i = 0;
			int splitCnt = 0;
			
			while( (data=BinputS.read()) != -1) {
				if( i % VOLUME == 0) {
					if( i != 0) {
						BoutputS.close();
						System.out.println("다음");
					}
					FoutputS = new FileOutputStream(filename + "_" + ++splitCnt);
					// 지정한 파일의 내용을 new하여 새로운 파일에 나눠서 저장함
					BoutputS = new BufferedOutputStream(FoutputS);
					System.out.println("파일을 " +splitCnt +"번 split 함");
					
				}
				BoutputS.write(data);
				i++;
			}
			
			System.out.println("종료");
			BinputS.close();
			BoutputS.close();
		}catch(IOException e) { e.printStackTrace();}
		
		
	}

}
