package ex02.runable;

public class UserRunable implements Runnable {
	
	String name;
	
	public UserRunable(String name){
		this.name = name;
	}
	@Override
	public void run() {
		for(int i=0; i<=10; i++){
				if(i==7){
					try {
						Thread.sleep(500); // 예외발생, 0.5초 동안, 1/1000 <==1초
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.print(name);
				}//end if
				System.out.print(i);
			}//end for
		}
	}

