package com.javaStudy;

class clone2 {
	public static void main(String[] args) {
		// TODO clone을 이용한 얕은복사, 깊은복사
		// 얕은복사는 같은 객체를 공유하면서 복사되므로 그 객체의 값이 바뀌면 같이 바뀜
		// 깊은복사는 각각의 객체로 복사되므로 서로 아무 상관없음
	
		Circle3 c1 = new Circle3(new Point3(1, 1), 2.0);
		Circle3 c2 = c1.shallowCopy();
		Circle3 c3 = c1.deepCopy();
	
		System.out.println("c1="+c1);
		System.out.println("c2="+c2);
		System.out.println("c3="+c3);
		c1.p.x = 9;
		c1.p.y = 9;
		System.out.println("= c1의 변경 후 =");
		System.out.println("c1="+c1);
		System.out.println("c2="+c2);
		System.out.println("c3="+c3);
	}
}

	class Circle3 implements Cloneable {
		Point3 p;  // 원점
		double r; // 반지름

		Circle3(Point3 p, double r) {
			this.p = p;
			this.r = r;
		}

		public Circle3 shallowCopy() { // 얕은 복사
			Object obj = null;

			try {
				obj = super.clone();
			} catch (CloneNotSupportedException e) {}

			return (Circle3)obj;
		}

		public Circle3 deepCopy() { // 깊은 복사
			Object obj = null;

			try {
				obj = super.clone();
			} catch (CloneNotSupportedException e) {}

			Circle3 c = (Circle3)obj; 
			c.p = new Point3(this.p.x, this.p.y); 

			return c;
		}

		public String toString() {
			return "[p=" + p + ", r="+ r +"]";
		}
	}

	class Point3 {
		int x;
		int y;

		Point3(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public String toString() {
			return "("+x +", "+y+")";
		}
	}


