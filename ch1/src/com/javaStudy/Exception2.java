package com.javaStudy;

public class Exception2 {

	public static void main(String[] args) {
		// TODO 예외 발생시키기
		try {
			Exception e = new Exception("할말");
			throw e;
		  //throw new Exception("할말");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
			}		
		}
	}

// checked   예외 : 컴파일러가 예외처리를 확인하는 Exception 클래스;사용자의 실수 - 외적요인 (필수적)
// unchecked 예외 : 컴파일러가 예외처리를 '확인하지않는' RuntimeException 클래스;프로그래머의 프밍상의 실수