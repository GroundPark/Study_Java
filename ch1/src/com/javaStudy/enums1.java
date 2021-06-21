package com.javaStudy;

enum Direction { east, west, south, north }

// enum은 class로 표기하면 다음과 같음
/*
class Direction {
	static final Direction east = new Direction("east");
	static final Direction west = new Direction("west");
	static final Direction south = new Direction("south");
	static final Direction north = new Direction("north");
	
	private String name;
	
	private Direction(String name) {
		this.name = name;
	}
*/

public class enums1 {

	public static void main(String[] args) {
		// TODO enums(열거형) : 여러 상수를 정의할때 사용
		Direction d1 = Direction.east;
		Direction d2 = Direction.valueOf("west");	// 열거형 상수의 '이름'으로 참조
		Direction d3 = Enum.valueOf(Direction.class, "south");
		
		System.out.println("d1 > "+d1);
		System.out.println("d2 > "+d2);
		System.out.println("d3 > "+d3);
		
		System.out.println("d1 == d3 인가? : "+(d1==d3));	//equals 도 가능은 하다
		System.out.println("d1.compareTo(d2) : " +d1.compareTo(d2)); // 왼쪽이 크면 양수, 오른쪽이 크면 음수, 같으면 0
		
		switch(d1) {
			case east:
				System.out.println("the direction is east"); 
				break;
			default:
				System.out.println("the direction is unknown"); 
				break;
		}
		
		Direction [] dArr = Direction.values();
		// values()를 사용해 모든값을 배열에 담음 
		for(Direction d : dArr)
			System.out.printf("%s=%d%n", d.name(), d.ordinal());
		// 열거형에 담긴 모든 상수를 출력함. ordinal은 열거형 순서(0부터) 반환
	}

}
