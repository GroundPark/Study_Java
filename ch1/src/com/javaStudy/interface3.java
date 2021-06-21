package com.javaStudy;

public class interface3 {

	public static void main(String[] args) {
		// TODO 인터페이스를 이용한 다형성
		// 리턴타입이 인터페이스 : 메서드가 해당 interface를 구현한 클래스의 인스턴스 반환함
		Parseable parser = ParseManager.getParser("XML");
		parser.parse("work1.xml");
		parser = ParseManager.getParser("HTML");
		parser.parse("work2.html");
		
	}

}

interface Parseable{
	public abstract void parse(String fileName);
}

class ParseManager{
	public static Parseable getParser(String type) {
		// 메서드의 리턴타입이 interface
		if(type.equals("XML")) {
			return new XMLparser();
		}else {
			Parseable p = new HTMLparser(); 
			return p; 
			//return new HTMLparser();와 같음... 이런 방법도 있다..
		}
	}
}
	//return에서 해당 인스턴스를 반환하므로.. '새로운 클래스'를 넣고싶다면.. 클래스 추가 후.. 'return NewParser();' 와 같이 리턴만 바꾸면 된다


class XMLparser implements Parseable{
	public void parse(String fileName) {
		//구문분석 구현
		System.out.println(fileName +" - XML 파일 파싱 완료");
	}
}

class HTMLparser implements Parseable{
	public void parse(String fileName) {
		//구문분석 구현
		System.out.println(fileName +" - HTML 파일 파싱 완료");
	}
}
