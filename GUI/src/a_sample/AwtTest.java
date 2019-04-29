package a_sample;

/*
 *  Java GUI 
 *  		- AWT -1.2  이전
 *  		- Swing - 1.2 이후 
 */

import java.awt.*;
import javax.swing.*;

public class AwtTest extends JFrame{
	// 1.멤버변수 선언	
	JButton b1;
	JButton b2;
	JTextField tf;
	JTextArea ta;
	JRadioButton cb1;
	JRadioButton cb2;


	AwtTest(){
		super("나의 두번째");
		//2. 객체생성
		b1 = new JButton("OK");
		b2 = new JButton("Cancle");
		tf = new JTextField( 30);
		ta = new JTextArea(20,10);
		cb1 = new JRadioButton("female");
		cb2 = new JRadioButton("Male");
		ButtonGroup bg = new ButtonGroup();
		bg.add(cb1);
		bg.add(cb2);
	}
	void addLayout() {
		//		Frame f = new Frame("s");
		
		//		3. 화면에 붙이기'
		//		FlowLayout fl = new FlowLayout();
		//		setLayout(fl);

		//setLayout(new FlowLayout()); // 윗줄 상단 중앙에 배치 , 컴포넌트의 크기가 고정되어있다
		// setLayout(new GridLayout(3,2)); (행 열) 에따라 배치
		setLayout(new BorderLayout()); //NORTH, SOUTH, CENTER, WEST,EAST 

		add(b1, BorderLayout.NORTH);
		add(b2, BorderLayout.SOUTH);
		add(tf, BorderLayout.WEST);
		add(ta, BorderLayout.CENTER);

		add(cb1, BorderLayout.EAST);
		add(cb2, BorderLayout.EAST);
		JPanel p = new JPanel();
		p.add(cb1);
		p.add(cb2);
		add(p, BorderLayout.EAST);
		//4. 화면에 출력
		setSize(600,480);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		AwtTest at = new AwtTest();
		at.addLayout();

	}

}
