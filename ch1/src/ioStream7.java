import java.io.*;
import java.util.Arrays;

public class ioStream7 {
	public static void main(String [] args) {
		ByteArrayOutputStream BoutputS = null;
		DataOutputStream DoutputS = null;
		byte [] result = null;
		
		try {
			BoutputS = new ByteArrayOutputStream();
			DoutputS = new DataOutputStream(BoutputS);
			
			DoutputS.writeInt(10);
			DoutputS.writeFloat(10.0f);
			DoutputS.writeBoolean(true);
			// [0, 0, 0, 10], [65, 32, 0, 0], [1]
			
			
			result = BoutputS.toByteArray();
			
			String [] hex = new String[result.length];
			
			for(int i=0;i<result.length;i++) {
				if(result[i] < 0) {
					hex[i] = String.format("%x", result[i]+256);
				  // 자바에서 자료형 부호있는 byte 범위는 -128~127이므로 +256하면 0~255가 됨
				}else {
					hex[i] = String.format("%x", result[i]);
				}
			}
			
			System.out.println("10 진수 : " +Arrays.toString(result));
			System.out.println("16 진수 : " +Arrays.toString(hex));
			
			DoutputS.close();
			
		}catch(IOException e) { e.printStackTrace(); }
	}

}
