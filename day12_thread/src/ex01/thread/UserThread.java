package ex01.thread;

public class UserThread extends Thread{
	String name;
	public UserThread(String name){//�������Լ�
		this.name = name;
	}
	@Override
	public void run() { // ������ �����(������)
		//super.run();
//		System.out.println(name);
//		System.out.println("start() �޼ҵ忡 ���� run()�� �����ȴ�. (������ ����)");
		for(int i=0; i<10; i++){
			if(i==7){
				try {
					sleep(500); // ���ܹ߻�, 0.5�� ����, 1/1000 <==1��
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

