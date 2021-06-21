package com.javaStudy;

public class accessModifier {

	public static void main(String[] args) {
		// TODO 접근제어자 : 외부로 부터 데이터 보호/불필요한 노출 감추기(캡슐화)
		Time myTime = new Time(12,30,45);
		System.out.println(myTime);
		
		// !myTime.hour = 13; 	
		myTime.setHour(myTime.getHour()+1);
		System.out.println("변경후 : " +myTime);
		
		// hour를 13으로 변경하려면... private변수 이므로 접근을 못하므로.. public인 겟터, 셋터를 이용해서 접근하여 13으로 변경해야함
	}

}

class Time{
	private int hour, minute, second;
	
	Time(int hour, int minute, int second){
		setHour(hour);
		setMinute(minute);
		setSecond(second);
	}
	
	public int getHour() { return hour; }
	public void setHour(int hour) {
		if(hour<0 || hour > 23) return;
		this.hour = hour;
	}
	public int getMinute() { return minute; }
	public void setMinute(int minute) {
		if(minute<0 || minute > 59) return;
		this.minute = minute;
	}
	public int getSecond() { return second; }
	public void setSecond(int second) {
		if(second<0 || second > 59) return;
		this.second = second;
	}
	public String toString() {
		return hour +":" +minute +":" +second;
	}
}

