import java.io.*;
public class standardIO12_1 {

	public static void main(String[] args) {
		// TODO 나눈 파일을 다시 합치는 예제
		if(args.length != 1) {
			System.out.println(" usage : filename ");
			System.exit(0);
		}
		
		String mergeFilename = args[0];
		// 이 예제에서 D:\Study_Java\ch1\testArea\tmpdata.dat
		
		try {
			File tmpFile = File.createTempFile("tempOnly_merge", ".tmp");
			// 경로는 지정안하면 기본값 시스템 속성 java.io.tmpdir에 임시파일이 생성됨 (C:\Users\ADMINI~1\AppData\Local\Temp\) 
			tmpFile.deleteOnExit();
			// 임시로 작업하고 프로그램 종료하면 임시파일은 삭제되어야함 (임시파일 생성 남용 막음)
			// 또, 프로그램 실행도중 어떤 이유에서든 중단되어 불완전한 파일이 생성되는것을 막기 위함
			
			FileOutputStream FoutputS = new FileOutputStream(tmpFile);
			BufferedOutputStream BoutputS = new BufferedOutputStream(FoutputS);
			
			BufferedInputStream BinputS = null;
			
			int num = 1;
			File f = new File(mergeFilename + "_" + num);
			
			while(f.exists()) {
				f.setReadOnly();		// 작업중 변경못하게 읽기전용 해야함!
				BinputS = new BufferedInputStream(new FileInputStream(f));
				
				int data = 0;
				while( (data=BinputS.read()) != -1){
					BoutputS.write(data);
				}
				BinputS.close();
				
				f = new File(mergeFilename + "_" + ++num);
			}
			
			BoutputS.close();
			
			File oldFile = new File(mergeFilename);
			if(oldFile.exists()) {
				oldFile.delete();
				System.out.println(mergeFilename +" 파일의 임시파일이 삭제됨");
			}
			tmpFile.renameTo(oldFile);
			System.out.println("임시파일 이름을 기존 파일 이름으로 변경하였음");
		}catch(IOException e) { e.printStackTrace(); }
	}
}
