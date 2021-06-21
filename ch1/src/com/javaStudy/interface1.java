package com.javaStudy;

public class interface1 {

	public static void main(String[] args) {
		// TODO 인터페이스 : 다중상속이 가능한 추상클래스. 구현할때 implements 사용
		// 1.개발시간 단축
		// 2.표준화 : 프로젝트의 기본틀을 인터페이스로 만든다음.. 개발자들끼리 구현함으로 .. 일관되고 정형화됨
		// 3.강제로 관계 맺기 : 상속, 조상 등의 관계 없어도 공통적인 인터페이스 구현으로 관계 맺음 
		//   p392에 설명돼있음. instanceof로 확인하고.. 캐스팅해서 사용하는식으로..
		// 4.독립적 프로그래밍 : 간접적으로 클래스를 변경하므로 영향을 미치지 않고 독립적으로 프로그래밍 가능
	}
}

class Unit{
	int x, y;
	int hp;
}

interface Movable {	void move(int x, int y);	}
interface Attackable {	void attack(Unit u);	}
interface Fightable extends Movable, Attackable {};
//interface의 다중상속

interface defaultInter{ 
	void methodd();
	default void addedMethod() {
		//구현
	}
}
//(!업데이트) 인터페이스에 새 메서드를 추가할때.. 전부 바꿔야하는 어려움이 있으므로.. [default 메서드]를 사용한다

class Fighter extends Unit implements Fightable{
	//상속, 구현 동시에 가능
	public void move(int x, int y) {
		//move 구현
	}
	
	public void attack(Unit u) {
		//attack 구현
	}
}

abstract class FighterAddon implements Fightable{
	//일종의 추상클래스이므로 일부만 구현한다면.. 구현 class 앞에 abstract를 씀
	public void move(int x, int y) {
		//move 구현
	}
}

