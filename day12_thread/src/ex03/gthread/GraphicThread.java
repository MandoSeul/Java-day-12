package ex03.gthread;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JFrame;

public class GraphicThread extends JFrame implements Runnable {
//frame : window ->console��尡 �ƴ�
	
	int num,x,y;
	Color color;
	Random random;
	public GraphicThread(int num){//�Ű����� 1�� ������ �Լ�, ������� �ʱ�ȭ
		this.num=num;
		color = Color.red;
		random = new Random();
		setSize(500,400); // ������(ȭ��)ũ�� - �ʺ�, ����
		setVisible(true);// ȭ�麸���ֱ�
		setLocation(300,150); // ȭ���� ��� ���� ���� // frame�� ��ġ
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �ݱ�
		
		
		
	}
	@Override
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, 10, 10);
	}
	@Override
	public void run() { // ������ ������(�����)
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
