package ex01.thread;

public class UserThread extends Thread{
	String name;
	public UserThread(String name){//생성자함수
		this.name = name;
	}
	@Override
	public void run() { // 스레드 실행부(구현부)
		//super.run();
//		System.out.println(name);
//		System.out.println("start() 메소드에 의해 run()이 유도된다. (실행대기 상태)");
		for(int i=0; i<10; i++){
			if(i==7){
				try {
					sleep(500); // 예외발생, 0.5초 동안, 1/1000 <==1초
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

