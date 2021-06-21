import java.io.*;
public class standardIO5 {

	public static void main(String[] args) throws IOException {
		// File : File 클래스를 통해 파일, 디렉토리를 다룰수 있음
		// ! OS 마다 구분자가 조금씩 다른것에 유의할것
	    // 유닉스, 리눅스 : File f1 = new File("D:/Study_Java/ch1/src/rafscore.dat");
	    //       윈도우 : File f1 = new File("D:\\Study_Java\\ch1\\src\\rafscore.dat");
		
		
		File f = new File("D:\\Study_Java\\ch1\\src\\standardIO5.dat");
  // 또는 File f = new File("D:\\Study_Java\\ch1\\src", "standardIO5.dat");
		f.createNewFile();		// 파일 '생성'
		String fileName = f.getName();
		
		System.out.println("파일 이름 : "+fileName);
		System.out.println("확장자 제외 이름 : "+fileName.substring(0, fileName.lastIndexOf(".")));
		
		System.out.println("경로 포함 파일이름 : "+f.getPath());
		System.out.println("파일이 위치한 폴더 : "+f.getParent());
		
		System.out.println("절대 경로 파일이름 : "+f.getAbsolutePath());
		System.out.println("정규 경로 파일이름 : "+f.getCanonicalPath());
		// 절대 경로 : root로부터 시작하는 파일의 전체 경로. 기호, 링크로 인해 표현방법에 따라 여러개의 절대경로가 존재할수 있음 
		// 정규 경로 : '하나'만 존재함		
		
		

	}

}
