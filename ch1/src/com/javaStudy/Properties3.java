package com.javaStudy;
import java.util.*;
import java.io.*;
public class Properties3 {

	public static void main(String[] args) {
		// TODO Properties와 반대로 저장된 data를... storeToXML() >> .xml 저장 또는 store() >> .txt로 저장함
		Properties p = new Properties();
		
		p.setProperty("timeout","20");
		p.setProperty("capacity","10");
		p.setProperty("size","65536");
		p.setProperty("language","EUC-KR");
		
		try {
			p.store(new FileOutputStream("pDataExport.txt"),"Data Exported");
			p.storeToXML(new FileOutputStream("pDataExport.xml"),"Data Exported");
			// 지정안하여 기본값인 프로젝트 폴더 D:\Study_Java\ch1에 저장됨
		}catch(IOException e) {};
		
		// 아래는 시스템 속성을 가져오는 예
		Properties sysP = System.getProperties();
		System.out.println("java.version : " +sysP.getProperty("java.version"));
		System.out.println("user.language : " +sysP.getProperty("user.language"));
		sysP.list(System.out);
	}

}
