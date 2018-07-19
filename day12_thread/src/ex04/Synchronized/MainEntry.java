package ex04.Synchronized;

class Atm{
	private int money;
	
	public Atm(int money){ // ������ �Լ�
		this.money = money;
	}


//�Ա��Լ�
public void deposit(int amount, String name){
	money += amount; // money = money + amount
	System.out.println(name + "�� �Աݱݾ� : "+amount);
}
//����Լ�
public synchronized void withdraw(int amount, String name){
	if((money - amount)>0){
		Thread.yield();
		money -=amount;// money = money - amount;
		System.out.println(name + "�� ��ݱݾ� : "+amount);
	}else{
		System.out.println(name+" : �ܾ��� �����մϴ�.");
	}
}
//���� �ܰ� �Լ�
public void getMoney(){
	System.out.println("              �ܾ��� : "+money);
}
}// atm emd


class UserAtm extends Thread{
	Atm obj;
	boolean flag = false;
	
	public UserAtm(Atm obj, String name){ // ������ �Լ�
		super(name);
		this.obj=obj;
	}
	@Override
	public void run() {// ������ ������(�����)
		for(int i=0; i<2; i++){
			try {
				sleep(50); // ��ӹ޾Ƽ� �ٷ� ��밡��
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(flag){
				obj.deposit((int)(Math.random()*10+2)*100, getName());
				obj.getMoney();
			}else{
				obj.withdraw((int)(Math.random()*10+2)*100, getName());
				obj.getMoney();
			}
			flag = true;
	}//for end
	
	}
}//useratm end


public class MainEntry {
	public static void main(String[] args) {
		Atm at = new Atm(1000);
		UserAtm user1 = new UserAtm(at, "�̽���");
		UserAtm user2 = new UserAtm(at, "�̽���");
		UserAtm user3 = new UserAtm(at, "�̽���");
		
		user1.start();
		user2.start();
		user3.start();
		
	}
}


