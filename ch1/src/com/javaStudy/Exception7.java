package com.javaStudy;

class Exception7 {
	public static void main(String args[]) {
		// TODO chained Exception(연결된 예외) : initCause 메서드를 이용해 예외를 연결시키듯이 만듬
		// 여러가지 예외를 하나의 큰 예외로 묶어서 다루기 위해서... 또는 checked를 unchecked로 바꾸기 위해서
		try {
			install();
		} catch(InstallException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();		
		}
	} 

	static void install() throws InstallException {
		try {
			startInstall();		
			copyFiles();		
		} catch (SpaceException1 e)	{
			InstallException ie = new InstallException("설치중 예외발생");
			ie.initCause(e);	//InstallException의 원인 예외를 spaceException으로 지정
			throw ie;			//InstallException 발생
			
		} catch (MemoryException1 me) {
			InstallException ie = new InstallException("설치중 예외발생");
			ie.initCause(me);
			throw ie;
		} finally {
			deleteTempFiles();	
		} 
	}

static void startInstall() throws SpaceException1, MemoryException1 { 
	if(!enoughSpace()) { 		// 충분한 설치 공간이 없으면...
		throw new SpaceException1("설치할 공간이 부족합니다.");
	}

	if (!enoughMemory()) {		// 충분한 메모리가 없으면...
		//throw new MemoryException("메모리가 부족합니다.");
		throw new RuntimeException(new MemoryException1("메모리가 부족합니다."));
	}
} 

   static void copyFiles() { /* 파일들을 복사 코드 */ }
   static void deleteTempFiles() { /* 파일들을 삭제하는 코드*/}
   
   static boolean enoughSpace()   {
		// 공간이 있는지 확인하는 코드
		return false;
   }
   static boolean enoughMemory() {
		// 메모리공간이 있는지 확인하는 코드
		return true;
   }
} 

class InstallException extends Exception {
	InstallException(String msg) {
	   super(msg);	
   }
} 

class SpaceException1 extends Exception {
	SpaceException1(String msg) {
	   super(msg);	
   }
} 

class MemoryException1 extends Exception {
	MemoryException1(String msg) {
	   super(msg);	
   }
}