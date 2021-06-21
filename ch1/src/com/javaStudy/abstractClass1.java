package com.javaStudy;

public class abstractClass1 {

	public static void main(String[] args) {
		// TODO 추상화 [클래스간의 공통점을 찾고.. 공통의 조상을 만들며.. 자식에서 구현한다]
		// 추상화한건 자식클래스에서 반드시 다 구현해야함
	}
}

abstract class notePlayer{	//추상클래스
	boolean pause;
	int currentPos;
	
	notePlayer(){
		pause = false;
		currentPos = 0;
	}
	
	abstract void play(int pos);	//추상메서드
	abstract void stop();			//추상메서드
}
	// 구현하고자하는 클래스에서 공통된 부분을 모아 추상화 해놨다

class midiPlayer extends notePlayer{
	void play(int currentPos) {
		//play 내용
	}
	void stop() {
		//stop 내용
	}
	
	int currentMidi;
	void MidiTrack() {
		//추가된 멤버 내용
	}
}

class cdPlayer extends notePlayer{
	void play(int currentPos) {
		//play 내용
	}
	void stop() {
		//stop 내용
	}
	
	int currentFile;
	void FileTrack() {
		//추가된 멤버 내용
	}
}