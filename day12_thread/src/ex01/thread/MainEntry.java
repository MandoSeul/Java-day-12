package ex01.thread;

public class MainEntry {
	public static void main(String[] args) {
	//Thread t1 = new Thread();
	UserThread t1 = new UserThread("t1");
	Thread t2 = new UserThread("t2");
	Thread t3 = new UserThread("t3");
	//t1.run();//������ �۾� �ƴ� ( ����� �Ұ� )
	t1.start(); // run()����
	t2.start(); // run()����
	t3.start(); // run()����
}
}
