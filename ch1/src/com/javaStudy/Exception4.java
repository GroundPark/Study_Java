package com.javaStudy;

public class Exception4 {

	public static void main(String[] args) {
		// TODO finally블럭에선 무조건 실행되어야할 코드를 씀 (try-catch에서 return있어도 무조건 실행됨)
		// 예외가 있으면 try>catch>finally......예외가 없으면 try>finally
		
		try {
			startInstall();
			copyFile();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			deleteTempFile();
		}
	}
	static void startInstall() {}
	static void copyFile() {}
	static void deleteTempFile() {}
	
}

