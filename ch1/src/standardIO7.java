import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class standardIO7 {

	public static void main(String[] args) {
		// TODO 시간, 파일크기(length), 이름을 오름차나 내림차로 정렬하는 기능 중 선택하여 파일의 속성을 출력하는 예제
		
		if(args.length != 1 || args[0].length() != 1 || "tTlLnN".indexOf(args[0]) == -1) {
			// args에 옵션을 한글자만 쓸거니까... 하나의 args인지, 문자열 args 길이가 1 인지, args가 tTlLnN 중 하나를 가졌는지 검사하고... 충족하지않으면 사용법 출력
			System.out.println(" usage : java standardIO7 SORT_OPTION");
			System.out.println(" t : 시간 오름차 정렬");
			System.out.println(" T : 시간 내림차 정렬");
			System.out.println(" l : 크기 오름차 정렬");
			System.out.println(" L : 크기 내림차 정렬");
			System.out.println(" n : 이름 오름차 정렬");
			System.out.println(" N : 이름 내림차 정렬");
			System.exit(0);
		}
		
		final char option = args[0].charAt(0);
		
	    String currentDir = System.getProperty("user.dir"); //현재 디렉토리 >> D:\Study_Java\ch1
		File dir = new File(currentDir);
	  // 현재 디렉토리에 대해 불러옴. 그냥 디렉토리쓰고 싶으면 윗줄 빼고 File에 경로 쓰셈	
		File [] files = dir.listFiles();
		
		Comparator myComp = new Comparator() {
			public int compare(Object o1, Object o2) {
				long time1 = ((File)o1).lastModified();
				long time2 = ((File)o2).lastModified();
				
				long length1 = ((File)o1).length();
				long length2 = ((File)o2).length();
				
				String name1 = ((File)o1).getName().toLowerCase();
				String name2 = ((File)o2).getName().toLowerCase();
				// 영문 파일명은 대소문자가 있기때문에 둘중하나로 통일해야함
				int result = 0;
				
				switch(option) {
				// 오름차에 필요한 리턴 : -1(o1<o2), 0(==), 1(o1>o2)   ...내림차는 -1,1 바꿔주면 됨 (! 수식은 o1-o2<0 이나 o1<o2나 같음 )  
					case 't' :
							 if(time1 - time2 > 0)	result = 1;
						else if(time1 - time2 == 0) result = 0;
						else if(time1 - time2 < 0)  result = -1;
						break;
					case 'T' :
							 if(time1 - time2 > 0)	result = -1;
						else if(time1 - time2 == 0) result = 0;
						else if(time1 - time2 < 0)  result = 1;
						break;
					case 'l' :
							 if(length1 - length2 > 0)	result = 1;
						else if(length1 - length2 == 0) result = 0;
						else if(length1 - length2 < 0)  result = -1;
						break;
					case 'L' :
							 if(length1 - length2 > 0)	result = -1;
						else if(length1 - length2 == 0) result = 0;
						else if(length1 - length2 < 0)  result = 1;
						break;
					case 'n' :
						result = name1.compareTo(name2);
						break;
					case 'N' :
						result = name2.compareTo(name1);
						break;
						
				}
				return result;
			}
		};
		
		Arrays.sort(files, myComp);
		// comparator 구현한것을 이용해 sort함
		
		for(int i=0;i<files.length;i++) {
			File f = files[i];
			String name = f.getName();
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm");
			String attribute = "";
			String size = "";
			
			if(files[i].isDirectory()) {
				attribute = "디렉토리";
			}else {
				size = "["+f.length()+"byte]";
				attribute = f.canRead() ? "파일R" : " ";
				attribute += f.canWrite() ? "W" : " ";
				attribute += f.isHidden() ? "H" : " ";
			}
			System.out.printf("%s %s %5s %s%n", sdf.format(new Date(f.lastModified())),attribute,name,size);
		}
	}
}
