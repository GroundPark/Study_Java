import java.io.*;
public class standardIO3 {

	public static void main(String[] args) {
		// RandomAccessFile : 파일에 대한 입출력을 모두 할수있게함. 
		// 위치를 옮길수있고 작업이 수행되는 파일 포인터를 사용해서 파일의 읽고쓰는 순서, 위치 등에 제약을 받지않음
		
		// TODO 데이터 파일의 각 라인에 [번호,국,영,수]을 넣고 .dat에 저장하고... readInt()로 읽어서 출력하는 예제
		
		int [] score = {1, 100, 50, 70,
						2, 80, 35, 20,
						3, 50, 0, 10,
						4, 20, 90, 80
		};
		
		try {
			RandomAccessFile raf = new RandomAccessFile("D:/Study_Java/ch1/src/rafscore.dat","rw");
			for(int i=0; i<score.length;i++)
				raf.writeInt(score[i]);
			
			raf.seek(0);
			// 파일 포인터가 writeInt()를 하면서 파일의 마지막 위치로 이동되었는데... 그 다음 readInt()하면 마지막에서 읽어서 EOF 예외가 남
			// 파일 포인터가 rw 따로따로가 아니므로 맨앞으로 위치 시켜줘야함 
			while(true) {
				System.out.println(raf.readInt());
			}
		}catch(EOFException eof) {}
		 catch(IOException e) {e.printStackTrace();}

	}

}
