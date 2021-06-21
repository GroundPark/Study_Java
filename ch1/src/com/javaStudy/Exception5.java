package com.javaStudy;

public class Exception5 {

	public static void main(String[] args) {
		// TODO 사용자 정의 Exception
		try {
			startInstall1();
		}catch(SpaceException se) {
			System.out.println("space예외");
		}catch(MemoryException me) {
			System.out.println("memory예외");
		}finally {
			//deleteTempFile();
		}
	}
	static void startInstall1() throws SpaceException, MemoryException{
		
	}
}

class SpaceException extends Exception{
	SpaceException(String msg){
		super(msg);
	}
}

class MemoryException extends Exception{
	MemoryException(String msg){
		super(msg);
	}
}