package ex04.Synchronized;

class Atm{
	private int money;
	
	public Atm(int money){ // 생성자 함수
		this.money = money;
	}


//입금함수
public void deposit(int amount, String name){
	money += amount; // money = money + amount
	System.out.println(name + "의 입금금액 : "+amount);
}
//출금함수
public synchronized void withdraw(int amount, String name){
	if((money - amount)>0){
		Thread.yield();
		money -=amount;// money = money - amount;
		System.out.println(name + "의 출금금액 : "+amount);
	}else{
		System.out.println(name+" : 잔액이 부족합니다.");
	}
}
//통장 잔고 함수
public void getMoney(){
	System.out.println("              잔액은 : "+money);
}
}// atm emd


class UserAtm extends Thread{
	Atm obj;
	boolean flag = false;
	
	public UserAtm(Atm obj, String name){ // 생성자 함수
		super(name);
		this.obj=obj;
	}
	@Override
	public void run() {// 스레드 구현부(실행부)
		for(int i=0; i<2; i++){
			try {
				sleep(50); // 상속받아서 바로 사용가능
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
		UserAtm user1 = new UserAtm(at, "이슬기");
		UserAtm user2 = new UserAtm(at, "이슐기");
		UserAtm user3 = new UserAtm(at, "이슈기");
		
		user1.start();
		user2.start();
		user3.start();
		
	}
}


