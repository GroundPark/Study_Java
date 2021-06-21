package com.javaStudy;
import java.util.*;

class helloJava{
	public static void main(String [] args) {
		try {
			throw new Exception("고의 익셉션");
		}catch(Exception e){
			System.out.println("캐치문의 println!!");
			e.printStackTrace();
		}
	}
}
