package ex02.runable;

public class MainEntry {
	public static void main(String[] args) {
		new Thread(new UserRunable("u1")).start();
		UserRunable u1 = new UserRunable("u1");
		UserRunable u2 = new UserRunable("u2");
		Thread t1 = new Thread(u1);
		Thread t2 = new Thread(u2);
		t1.start();
		t2.start();
		//u1.run() ¾ÈµÊ. -> threadÀÌ¿ë
	}
}
