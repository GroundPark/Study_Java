import java.io.*;
public class standardIO11 {

	public static void main(String[] args) {
		// TODO renameTo()를 이용해 파일명을 바꾸는 예제
		// ! 실행전 테스트 폴더에 적용하셈.  되돌림 못함에 주의
		
		if(args.length != 1) {
			System.out.println(" usage : args에 DIRECTORY");
			System.exit(0);
		}
		
		File dir = new File(args[0]);
		
		if( !dir.exists() || !dir.isDirectory() ) {
			System.out.println(" 유효하지 않은 디렉토리 ");
			System.exit(0);
		}
		
		File [] list = dir.listFiles();
		
		for(int i=0;i<list.length;i++) {
			String fileName = list[i].getName();
			String newfileName = "0000"+fileName;
				   newfileName = newfileName.substring(newfileName.length() - 7);
				   // 1.tmp > 00001.tmp >> substring('9'-7) : idx 2부터 읽음 >>> 001.tmp 
				   //10.tmp > 000010.tmp >> s('10'-7) : idx 3부터 읽음 >>> 010.tmp
				   //100.tmp > 0000100.tmp >>> 100.tmp
				   
				   //개선 사항 : (앞의 0 개수는 상관없고) 파일의 이름이 0~999까지는 괜찮은데... 1000넘기면 짤려서 000으로 돌아옴
				   //1000.tmp > 00001000.tmp >>> idx 5부터 읽음 >>> 000.tmp (!짤림)
			list[i].renameTo(new File(dir, newfileName));
			System.out.println(fileName +"에서 " +newfileName+"으로 이름 변환 완료");
		}
	}

}
