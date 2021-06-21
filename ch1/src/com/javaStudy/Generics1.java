package com.javaStudy;
import java.util.*;

class Fruit 			   { public String toString() { return "Fruit"; }}
class Apple extends Fruit  { public String toString() { return "Apple"; }}
class Banana extends Fruit { public String toString() { return "Banana"; }}
class Toy 				   { public String toString() { return "Toy"; }}

class Box<T>{
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) { list.add(item); }
	T get(int i)	 { return list.get(i); }
	int size()		 { return list.size(); }
	public String toString() { return list.toString(); }
}

public class Generics1 {

	public static void main(String[] args) {
		// TODO 지네릭스(Generics) : 다양한 타입의 객체들을 다루는 메서드나 컬렉션 클래스에 컴파일할때 타입 체크를 해주는 기능
		// 타입 안정성 제공, 타입 체크-형변환을 생략함으로 코드가 간결해짐 (객체 타입 미리 명시)
		
		Box<Fruit> fruitBox = new Box<Fruit>();
		Box<Apple> appleBox = new Box<Apple>();
		Box<Toy> toyBox = new Box<Toy>();
		
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		//fruitBox엔 Fruit 내지는 Fruit의 자손 타입만 넣을수 있음 (void add(Fruit item)때문)
		
		appleBox.add(new Apple());
		appleBox.add(new Apple());
		//appleBox엔 Apple 타입만 넣을수 있음... new toy()안됨
		
		toyBox.add(new Toy());
		
		System.out.println(fruitBox);
		System.out.println(appleBox);
		System.out.println(toyBox);		
	}
}

