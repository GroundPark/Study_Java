import java.io.*;
public class standartIO10 {
	static int delCnt = 0;
	public static void main(String[] args) {
		// TODO user.dir 이하의 파일 중 [지정 확장자]를 가진 파일을 삭제하는 예제
		// !! 실행 전에 삭제할 예제 파일 만들고 하기. 완전삭제이므로 사용에 주의
		if(args.length != 1) {
			System.out.println(" usage : args에 Extension");
			System.exit(0);
		}
		
		String currentDir = System.getProperty("user.dir");
		
		File dir = new File(currentDir);
		String extension = "."+args[0];
		
		deleteEx(dir, extension); 
		System.out.println(delCnt+"개의 파일이 삭제됨");	
	}
	
	public static void deleteEx(File dir, String extension) {
		File [] files = dir.listFiles();
		
		for(int i=0;i<files.length;i++) {
			if(files[i].isDirectory()) {
				deleteEx(files[i], extension);
			}else {
				String filename = files[i].getAbsolutePath();
				
				if(filename.endsWith(extension)) {
					System.out.println(filename);
					if(files[i].delete()) {
						System.out.println(" delete success ");
						delCnt++;
					}else {
						System.out.println(" delete fail ");
					}
				}
			}
		}
	}
}
