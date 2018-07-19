package ex03.gthread;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JFrame;

public class GraphicThread extends JFrame implements Runnable {
//frame : window ->console모드가 아님
	
	int num,x,y;
	Color color;
	Random random;
	public GraphicThread(int num){//매개변수 1개 생성자 함수, 멤버변수 초기화
		this.num=num;
		color = Color.red;
		random = new Random();
		setSize(500,400); // 프레임(화면)크기 - 너비, 높이
		setVisible(true);// 화면보여주기
		setLocation(300,150); // 화면이 어디서 뜰지 결정 // frame의 위치
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기
		
		
		
	}
	@Override
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, 10, 10);
	}
	@Override
	public void run() { // 스레드 구현부(실행부)
		Rectangle rec = getBounds();
		for(int i=0; i<num;i++){
			x = random.nextInt(rec.width);
			y = random.nextInt(rec.height);
			repaint();
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}// for end
	}
	
	public static void main(String[] args) {
//		GraphicThread gt = new GraphicThread(10);
//		Thread t1 = new Thread(gt);
//		t1.start();
		new Thread(new GraphicThread(2000)).start();
	}
}
