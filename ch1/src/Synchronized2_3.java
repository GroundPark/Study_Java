import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

class Customer4 implements Runnable {
	private Table4 table;
	private String food;

	Customer4(Table4 table, String food) {
		this.table = table;  
		this.food  = food;
	}

	public void run() {
		while(true) {
			try { Thread.sleep(100);} catch(InterruptedException e) {}
			String name = Thread.currentThread().getName();
			
			table.remove(food);
			System.out.println(name + " ate a " + food);
		} // while
	}
}

class Cook4 implements Runnable {
	private Table4 table;
	
	Cook4(Table4 table) {	this.table = table; }

	public void run() {
		while(true) {
			int idx = (int)(Math.random()*table.dishNum());
			table.add(table.dishNames[idx]);
			try { Thread.sleep(10);} catch(InterruptedException e) {}
		} // while
	}
}

class Table4 {
	String[] dishNames = { "donut","donut","burger" }; // donut의 확률을 높인다.
	final int MAX_FOOD = 6;
	private ArrayList<String> dishes = new ArrayList<>();

	private ReentrantLock lock = new ReentrantLock();
	private Condition forCook = lock.newCondition();
	private Condition forCust  = lock.newCondition();

	public void add(String dish) {
		lock.lock();

		try {
			while(dishes.size() >= MAX_FOOD) {
					String name = Thread.currentThread().getName();
					System.out.println(name+" is waiting.");
					try {
						forCook.await(); // wait(); COOK쓰레드를 기다리게 한다.
						Thread.sleep(500);
					} catch(InterruptedException e) {}	
			}

			dishes.add(dish);
			forCust.signal(); // notify();  기다리고 있는 CUST를 깨우기 위함.
			System.out.println("Dishes:" + dishes.toString());
		} finally {
			lock.unlock();
		}
	}

	public void remove(String dishName) {
		lock.lock(); //		synchronized(this) {	
		String name = Thread.currentThread().getName();

		try {
			while(dishes.size()==0) {
					System.out.println(name+" is waiting.");
					try {
						forCust.await(); // wait(); CUST쓰레드를 기다리게 한다.
						Thread.sleep(500);
					} catch(InterruptedException e) {}	
			}

			while(true) {
				for(int i=0; i<dishes.size();i++) {
					if(dishName.equals(dishes.get(i))) {
						dishes.remove(i);
						forCook.signal(); // notify();잠자고 있는 COOK을 깨움
						return;
					}
				} // for문의 끝

				try {
					System.out.println(name+" is waiting.");
					forCust.await(); // wait(); // CUST쓰레드를 기다리게 한다.
					Thread.sleep(500);
				} catch(InterruptedException e) {}	
			} // while(true)
			 // } // synchronized
		} finally {
			lock.unlock();
		}
	}

	public int dishNum() { return dishNames.length; }
}

class Synchronized2_3  {
	public static void main(String[] args) throws Exception {
		Table4 table = new Table4();

		new Thread(new Cook4(table), "COOK1").start();
		new Thread(new Customer4(table, "donut"),  "CUST1").start();
		new Thread(new Customer4(table, "burger"), "CUST2").start();
	
		Thread.sleep(2000);
		System.exit(0);
		// 이 코드는 Customer와 Cook 각각의 경우를 Condition을 만들어서 각각의 대기실에서 기다리게 하고...
		// wait/notify 대신 await/signal을 사용해서... Customer와 Cook 사이의 기아 현상, 경쟁 상태를 해결함
		
		// ! synchronized 블럭의 단점을 개선하여 Lock클래스를 사용한다
		// ReentrantLock		  : 재진입가능-배타적인 일반적인 lock
		
		// ReentrantReadWriteLock : 공유적 읽기 lock, 배타적 쓰기 lock 
		// 읽기 lock 또는 쓰기 lock 둘중 하나의 상태만 사용함. 공유적 읽기로 '여러 쓰레드가 읽는것'은 큰 문제가 되지 않기때문
		
		// StampedLock 			  : 공유적 읽기 lock, 배타적 쓰기 lock + 낙관적 읽기 lock
		// lock을 걸거나 해지할때 Stamp(정수)를 사용함. 읽기 lock이 걸려있으면 쓰기 lock을 얻기위해 기다려야 하지만... 낙관적 읽기는 쓰기 lock에 바로 풀린다
		// 쓰기/읽기가 충돌할때만 쓰기가 끝난후 읽기 lock을 검
		
		// !! ReentrantLock()에서 매개변수 bool값은 공정성(fair)을 가지는데... 가장 오래 기다린 쓰레드가 lock을 가짐. (확인과정에서 성능을 요구하기에 일반적으로 굳이 쓰진않음)
		// ReentrantLock은 '수동으로' lock을 컨트롤 해야한다. lock,unlock,isLocked 메서드가 정의돼있음
		// 일반적으로 lock() 후에 try-finally로 unlock()를 감싼다. (임계영역내에서의 예외 발생, return으로 탈출하면 lock이 안풀림)
		
		// + tryLock() : 다른 쓰레드에 의해 lock이 걸려있으면 lock을 기다리지 않음 (응답성이 중요한 경우 사용)
		// 사용자가 매개변수로 지정한 시간동안 lock을 기다리며... 받았다면 T/F를 return
		// lock을 얻지못했다면 다시 작업을 할지를 사용자가 결정할수 있게함.  InterruptedException을 이용해 interrupt()로 작업취소를 가능케 해놓았음
	}
}
