import java.util.ArrayList;

class Synchronized2 {
	public static void main(String[] args) throws Exception {
		// TODO wait, notify-notifyAll : Object에 정의 되어있고... 동기화 블록에서만 사용가능함
		// A가 동기화된 임계 영역의 코드를 수행하다가 작업이 원활하지 않으면 wait()를 이용해 A 쓰레드가 락을 반납하고 대기하게 만듬
		// 반납된 락을 이용해 다른 B 쓰레드가 해당 임계 영역의 코드를 수행함
		// 대기중인 A 쓰레드가 작업을 진행할수 있는 상황이 오면 notify()를 이용해 A 쓰레드의 작업을 재개함
		
		// ! 오래 기다린 쓰레드가 락을 얻는다는 식이 아니라 임의로 얻음
		// wait() 호출 >> 실행중이던 쓰레드는 해당 객체의 대기실(waiting pool)에서 통지를 기다림 
		// > notify() 호출 > 대기실의 모든 쓰레드 중에서 임의의 쓰레드만 통지를 받음
		// >>notifyAll() 호출 >> 대기실의 모든 쓰레드에게 통지를 보냄. 단 lock을 얻는건 하나의 쓰레드이므로 다른 쓰레드는 또 lock을 기다림
		
		// !! wait()는 notify, notifyAll이 호출될때까지 기다리지만... 매개변수로 지정된 시간만큼 기다리게 할수있음(즉, 시간뒤에 자동적으로 notify호출됨)
		// 대기실은 '객체'마다 존재함... notifyAll을 쓸때 '호출된 객체의 대기실에서 대기하는 쓰레드'만 notifyAll함
		Table table = new Table(); // 여러 쓰레드가 공유하는 객체

		new Thread(new Cook(table), "COOK1").start();
		new Thread(new Customer(table, "donut"),  "CUST1").start();
		new Thread(new Customer(table, "burger"), "CUST2").start();
		// 손님1은 도넛만 먹고... 손님2는 버거만 먹는다
		
		Thread.sleep(100);
		System.exit(0);
		// 0.1초(100 밀리 세컨드) 후에 강제 종료시킨다.
		
		// ! 아래 코드를 실행하면 동기화를 하지않아서 예외가 2가지 일어난다. 
		// 1. 작업중인 쓰레드의 자원을 사용하려하는 문제 : Cook 쓰레드가 음식 작업하는 도중에, Customer 쓰레드가 음식을 가져가려 함
		// 2. 하나의 자원을 두고 서로 사용하려는 문제 : 전자가 마지막 음식을 가져가는중에 후자도 가지고 가려하다보니 존재하지도 않는 음식을 가져가려 함 
	}
}

class Customer implements Runnable {
	private Table table;
	private String food;

	Customer(Table table, String food) {
		this.table = table;  
		this.food  = food;
	}

	public void run() {
		while(true) {
			try { Thread.sleep(10);} catch(InterruptedException e) {}
			String name = Thread.currentThread().getName();
			
			if(eatFood())
				System.out.println(name + " ate a " + food);
			else 
				System.out.println(name + " failed to eat. :(");
		} // while
	}

	boolean eatFood() { return table.remove(food); }
}

class Cook implements Runnable {
	private Table table;
	
	Cook(Table table) {	this.table = table; }

	public void run() {
		while(true) {
			// ▽ 임의의 요리를 하나 선택해서 table에 추가한다. (계속됨)
			int idx = (int)(Math.random()*table.dishNum());
			table.add(table.dishNames[idx]);

			try { Thread.sleep(1);} catch(InterruptedException e) {}
		} // while
	}
}

class Table {
	String[] dishNames = { "donut","donut","burger" }; // donut이 더 자주 나온다.
	final int MAX_FOOD = 6;  // 테이블에 놓을 수 있는 최대 음식의 개수
	
	private ArrayList<String> dishes = new ArrayList<>();

	public void add(String dish) {
		// ▽ 테이블에 음식이 가득찼으면, 테이블에 음식을 추가하지 않는다.
		if(dishes.size() >= MAX_FOOD)	
			return;
		dishes.add(dish);
		System.out.println("Dishes:" + dishes.toString());
	}

	public boolean remove(String dishName) {
		// ▽ 지정된 요리와 일치하는 요리를 테이블에서 제거한다.(먹는다)
		for(int i=0; i<dishes.size();i++)
			if(dishName.equals(dishes.get(i))) {
				dishes.remove(i);
				return true;
			}

		return false;
	}

	public int dishNum() { return dishNames.length; }
}
