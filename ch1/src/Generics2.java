//package com.javaStudy;
import java.util.ArrayList;

interface Eatable {}

class Fruit implements Eatable { public String toString() { return "Fruit"; }}
class Apple extends Fruit  { public String toString() { return "Apple"; }}
class Banana extends Fruit { public String toString() { return "Banana"; }}
class Toy 				   { public String toString() { return "Toy"; }}

class FruitBox<T extends Fruit & Eatable> extends Box<T>{}

public class Generics2 {
	public static void main(String[] args) {
		// TODO Generics의 제한 : extends를 이용해 특정 타입의 자손들만 대입할수 있게 제한할수있다
		// !! 미완 챕터
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();

		fruitBox.add(new Fruit());
		
		System.out.println("fruitBox-" +fruitBox);
	}

}

class Box<T>{
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) { list.add(item); }
	T get(int i)	 { return list.get(i); }
	int size()		 { return list.size(); }
	public String toString() { return list.toString(); }
}