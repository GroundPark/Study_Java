package com.javaStudy;

class polymorphism2 {

	public static void main(String[] args) {
		// TODO 메서드의 매개변수에 다형성 적용
		buyer b = new buyer();
		
		b.buy(new Tv1());
		
		System.out.println("남은돈은 " +b.money + "만원입니다");	
	}
}

class Product{
	int price;
	int bonusPoint;
	
	Product(int price){
		this.price = price;
		bonusPoint = (int)(price * 0.1);
	}
}

class Tv1 extends Product{
	Tv1(){
		super(100);
	}
	public String toString() {	return "TV";	}
}

class buyer{
	int money = 1000;
	int bonusPoint = 0;
	
	void buy(Product p) {	
		//메서드의 매개변수에 다형성을 적용함. 
		//buy(Tv1).. buy(Audio).. 등 종류가 많아지면 감당안됨
		//배열쓸거면 멤버변수에 Vector로 가변배열을 만들어서..add로 넣고..반복문의 get으로 객체얻고.. 하는식으로 구현
		if(money < p.price) {
			System.out.println("잔액 부족함");
			return;
		}
	money -= p.price;
	bonusPoint += p.bonusPoint;
	System.out.println(p +"를 구입함           " +bonusPoint +" <- 보너스 금액");
	}
	
}