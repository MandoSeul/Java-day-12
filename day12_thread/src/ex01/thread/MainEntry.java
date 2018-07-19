package ex01.thread;

public class MainEntry {
	public static void main(String[] args) {
	//Thread t1 = new Thread();
	UserThread t1 = new UserThread("t1");
	Thread t2 = new UserThread("t2");
	Thread t3 = new UserThread("t3");
	//t1.run();//스레드 작업 아님 ( 명시적 불가 )
	t1.start(); // run()유도
	t2.start(); // run()유도
	t3.start(); // run()유도
}
}
