import java.io.*;
import java.util.ArrayList;

class standardIO6 {
	static int totalFiles = 0;
	static int totalDirs = 0;

	public static void main(String[] args) {
		// TODO args에 지정한 디렉토리에 포함된 파일, 디렉토리 목록을 전부 출력하는 예제
		if(args.length != 1) {
			System.out.println("USAGE : java FileEx3 DIRECTORY");
			System.exit(0);
		}

		File dir = new File(args[0]);

		if(!dir.exists() || !dir.isDirectory()) {
			System.out.println("유효하지 않은 디렉토리입니다.");
			System.exit(0);
		} 

		printFileList(dir);

		System.out.println();
		System.out.println("총 " + totalFiles + "개의 파일");
		System.out.println("총 " + totalDirs + "개의 디렉토리");
	} 

	public static void printFileList(File dir) {
		System.out.println(dir.getAbsolutePath()+" 디렉토리");
		File[] files = dir.listFiles();
		// listFiles()에서 디렉토리의 파일,dir 목록을 File 배열로 반환

		ArrayList subDir = new ArrayList();

		for(int i=0; i < files.length; i++) {
			String filename = files[i].getName();
			
			if(files[i].isDirectory()) {
				filename = "디렉토리 >> [" + filename + "]";
				subDir.add(i+"");
				System.out.println(filename);
			}
			else if(!files[i].isDirectory()) {
				System.out.println("  파일    : "+filename);
			}
		}

		int dirNum  = subDir.size();
		int fileNum = files.length - dirNum;

		totalFiles += fileNum;
		totalDirs  += dirNum;

		System.out.println(fileNum + "개의 파일, " + dirNum + "개의 디렉토리");
		System.out.println();

		for(int i=0; i < subDir.size(); i++) {
			int index = Integer.parseInt((String)subDir.get(i));
			printFileList(files[index]);
			// 상위 파일, 디렉토리 목록을 출력 처리하고... subDir에 하위 디렉토리를 담고 각각에 대해 출력 처리를 재귀호출 함 
		}
	} 
}

