import java.io.*;
public class ReaderWriter5 {

	public static void main(String[] args) {
		// TODO bufferedReader/Writer : 버퍼 이용해서 입출력 효율을 높임
		
		try {
			FileReader FReader = new FileReader("D:/Study_Java/ch1/src/ReaderWriter5.java");
			BufferedReader BReader = new BufferedReader(FReader);
			
			String line = "";
			for(int i=1; (line=BReader.readLine()) != null ;i++){
				if(line.indexOf(";") != -1)
					System.out.println(i+":"+line);
			}
			
			BReader.close();
		}catch(IOException e) { e.printStackTrace(); }
		
	}

}
