import java.io.*;
public class standardIO8 {
	static int foundCnt = 0;
	public static void main(String[] args) {
		// TODO args[0]에 지정한 디렉토리와 그 이하 디렉토리의 모든 파일 중 확장자가 [java, txt, bak]인 파일들을 모두 읽고... args[1]에 지정된 키워드가 포함된 라인을 출력하는 예제  
		if(args.length != 2) {
			System.out.println(" need 2 args : DIRECTORY KEYWORD");
			System.exit(0);
		}
		
		File dir = new File(args[0]);
		String dirStr = args[0];
		String keyword = args[1];
		
		if( !dir.exists() || !dir.isDirectory() ) {
			System.out.println("디렉토리가 유효하지 않음");
			System.exit(0);
		}
		
		try {
			findLineInFiles(dir, keyword);
		}catch(IOException e) { e.printStackTrace(); }
		
		System.out.println("==============");
		System.out.println(dirStr +" 디렉토리 이하의 파일 내용중 " +foundCnt+"개의 라인에서 키워드 ["+keyword+"] 찾음");
	}
	
	public static void findLineInFiles(File dir, String keyword) throws IOException {   //FileReader에서 예외 있음
		File [] files = dir.listFiles();
		
		for(int i=0;i<files.length;i++) {
			if(files[i].isDirectory()) {
				findLineInFiles(files[i], keyword);
			}else {
				String filename = files[i].getName();
				String extension = filename.substring(filename.lastIndexOf(".")+1);		// .[java]
					   extension = "," + extension + ",";								// ,java,
				if(",java,txt,bak,".indexOf(extension) == -1) continue;					// 예를들어 ava찾으면 찾아지긴하니까 ,ava,처럼 제약걸고 못찾게함
				
				filename = dir.getAbsolutePath() + File.separator + filename;
				
				FileReader FReader = new FileReader(files[i]);
				BufferedReader BReader = new BufferedReader(FReader);
				
				String data = "";
				int lineNum = 0;
				
				while( (data=BReader.readLine()) != null){
					lineNum++;
					
					if(data.indexOf(keyword) != -1) {
						foundCnt++;
						System.out.println("["+filename +"]의 라인 "+lineNum +"번째 줄에서 " +keyword+"찾음 "+data);
					}
				}
				BReader.close();
			}
		}
	}
}
