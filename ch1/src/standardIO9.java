import java.io.*;
public class standardIO9 {

	public static void main(String[] args) throws Exception {
		// TODO FilenameFilter(안에 accept)를 구현하여 지정 [pattern]에 맞는 파일의 목록을 출력하는 예제
		
		if(args.length != 1) {
			System.out.println(" usage : args에 [패턴]");
			System.exit(0);
		}
		
		String currentDir = System.getProperty("user.dir");
		File dir = new File(currentDir);
		final String pattern = args[0];
		
		String [] files = dir.list(new FilenameFilter() {
									@Override
									public boolean accept(File dir, String name) {
										return name.indexOf(pattern) != -1;
										// 조건을 거쳐 true를 return하는 파일만 필터링됨
										// 예제에선 패턴이 파일이름에 있는지 찾고 -1(일치하는 패턴이 없음)이 아닌것만 true 리턴함. 즉, 일치하는 패턴이 있는것만 나옴
										}
									}
								  );
		
		for(int i=0;i<files.length;i++) {
			System.out.println(files[i]);
		}
	}
}
