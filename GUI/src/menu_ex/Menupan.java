package menu_ex;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class Menupan extends JFrame {

	// 한신포차 메뉴 이미지 블럭 

	JFrame scr;
	JTextField tf;
	JTextArea ta;

	Tang	tang;
	Anju	anju;
	Drink	drink;


	// 통합할 뭔가
	//String total = "통합";

	Menupan() {

		scr = new JFrame();
		tang 	= new Tang();
		anju	= new Anju();
		drink	= new Drink();
		// 탭팬에 올라갈 객체 생성 필요 


		tf = new JTextField( 30);
		ta = new JTextArea(10,30);

	
	}
	// 화면 출력
	void addLayout() {
		
		setLayout(new BorderLayout());
		JTabbedPane  pane = new JTabbedPane();
		
		pane.addTab("탕", tang );
		pane.addTab("안주", anju);
		pane.addTab("음료", drink );		

		add(ta, BorderLayout.SOUTH);
		add(tf, BorderLayout.SOUTH);
		add(pane,BorderLayout.CENTER);
		JPanel ps =new JPanel();// 패널생성
		JPanel pc =new JPanel();// 탭팬이 올라갈 패널
		ps.setLayout(new BorderLayout());
		ps.add(ta, BorderLayout.CENTER);// 패널에 add
		ps.add(tf, BorderLayout.SOUTH);
	
		
		add(ps, BorderLayout.SOUTH);//패널을 배치

		setSize(1920, 1080);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//각각의 화면을 관리하는 클래스 객체 생성

	// answer에 각각의 값을 각 버튼에 지정 
	void eventProc () {

	}
	class BtnHdlr implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		}
	}
	public static void main(String[] args) {
		Menupan my = new Menupan();
		my.addLayout();
		my.eventProc();
	}

}
