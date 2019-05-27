package	 view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import view.Snackview_emp.ButtonEventHandler;


public class Cinemaview_emp extends JPanel 
{	
	 
	// 1.영화 시간 콤보 박스 
		JComboBox comMovie;
		JComboBox comTime;
	
	// 2. 좌석 A1~ G8 버튼
	
		
		JButton JbA1;
		JButton JbA2;
		JButton JbA3;
		JButton JbA4;
		JButton JbA5;
		JButton JbA6;
		JButton JbA7;
		JButton JbA8;
		JButton JbA9;
		
		JButton JbB1;
		JButton JbB2;
		JButton JbB3;
		JButton JbB4;
		JButton JbB5;
		JButton JbB6;
		JButton JbB7;
		JButton JbB8;
		JButton JbB9;
		
		JButton JbC1;
		JButton JbC2;
		JButton JbC3;
		JButton JbC4;
		JButton JbC5;
		JButton JbC6;
		JButton JbC7;
		JButton JbC8;
		JButton JbC9;
		
		JButton JbD1;
		JButton JbD2;
		JButton JbD3;
		JButton JbD4;
		JButton JbD5;
		JButton JbD6;
		JButton JbD7;
		JButton JbD8;
		JButton JbD9;
		
		JButton JbE1;
		JButton JbE2;
		
		JButton JbE8;
		JButton JbE9;
		
		
		// NULL 버튼 - 상호작용 X 빈칸채우기용 
		
		JButton JBnull1;
		JButton JBnull2;
		JButton JBnull3;
		JButton JBnull4;
		JButton JBnull5;
		JButton JBnull6;
		JButton JBnull7;
		JButton JBnull8;
		JButton JBnull9;
		JButton JBnull10;
		
		
		JButton JBnull11;
		JButton JBnull12;
		JButton JBnull13;
		JButton JBnull14;
		JButton JBnull15;
		JButton JBnull16;
		JButton JBnull17;
		JButton JBnull18;
		JButton JBnull19;
		JButton JBnull20;
	
		
		JButton JBnull21;
		JButton JBnull22;
		JButton JBnull23;
		JButton JBnull24;
		JButton JBnull25;
		JButton JBnull26;
		JButton JBnull27;
		JButton JBnull28;
		JButton JBnull29;
		JButton JBnull30;
		
		
		JButton JBnull31;
		JButton JBnull32;
		JButton JBnull33;
		JButton JBnull34;
		JButton JBnull35;
		JButton JBnull36;
		JButton JBnull37;
		JButton JBnull38;
		JButton JBnull39;
		JButton JBnull40;

		JButton JBnull41;
		JButton JBnull42;
		JButton JBnull43;
		JButton JBnull44;
		JButton JBnull45;
		JButton JBnull46;
		JButton JBnull47;
		JButton JBnull48;
		JButton JBnull49;
		JButton JBnull50;
		JButton JBnull51;
		
		
		
		
		
		
		
			
	// 3. ta좌석 가격
		JTextArea taAll;
		
	// 4. tf 좌석 합계
		JTextField tfPrice;
	
	// 5 . 결제 버튼 
		JButton JbDone;

	//**************
	// 비지니스 로직 = 모델 클래스 변수 선언


	//##############################################
	//	constructor method
	public Cinemaview_emp(){
		addLayout(); 	// 화면설계
	}
//		connectDB();	// DB연결

/*
	// 버튼 이벤트 핸들러 만들기
	public void eventProc(){
		ButtonEventHandler hdlr = new ButtonEventHandler();
		JbDone.addActionListener(hdlr);
/*
		for (int i =0; i<3; i++ ) {	
			for( int j=0; j<4; j++) {
				// 메뉴 버튼 각 4개씩 
				jbMenu[i][j].addActionListener(hdlr);
			}
		}
	// 버튼 이벤트 핸들러 만들기
	/*
		class ButtonEventHandler implements ActionListener{
			public void actionPerformed(ActionEvent ev){
				Object o = ev.getSource();
			
				if(o==/jbDone){  
					
					//JOptionPane.showMessageDialog(null,menuPrice);
				}
*/
	//	public void initStyle(){   // 입력하지 못하게 만듬.

	//  화면설계 메소드
	public void addLayout(){
		//멤버변수의 객체 생성
		// 1.영화 시간 콤보 박스 
			String []cbMovieStr = {"어벤져스","자바","기생충","나혼자산다",};
				comMovie = new JComboBox(cbMovieStr);
			String []cbTimeStr = {"시간","은","디비로부터","가져오자"};
				comTime = new JComboBox(cbTimeStr);
			
			// 2. 좌석 A1~ G8 버튼
				 JbA1 = new JButton();
				 JbA2 = new JButton();
				 JbA3 = new JButton();
				 JbA4 = new JButton();
				 JbA5 = new JButton();
				 JbA6 = new JButton();
				 JbA7 = new JButton();
				 JbA8 = new JButton();
				 JbA9 = new JButton();
				 
				 JbB1 = new JButton();
				 JbB2 = new JButton();
				 JbB3 = new JButton();
				 JbB4 = new JButton();
				 JbB5 = new JButton();
				 JbB6 = new JButton();
				 JbB7 = new JButton();
				 JbB8 = new JButton();
				 JbB9 = new JButton();
				 
				 JbC1 = new JButton();
				 JbC2 = new JButton();
				 JbC3 = new JButton();
				 JbC4 = new JButton();
				 JbC5 = new JButton();
				 JbC6 = new JButton();
				 JbC7 = new JButton();
				 JbC8 = new JButton();
				 JbC9 = new JButton();
				 
				 JbD1 = new JButton();
				 JbD2 = new JButton();
				 JbD3 = new JButton();
				 JbD4 = new JButton();
				 JbD5 = new JButton();
				 JbD6 = new JButton();
				 JbD7 = new JButton();
				 JbD8 = new JButton();
				 JbD9 = new JButton();
				 
				 JbE1 = new JButton();
				 JbE2 = new JButton();
				
				 JbE8 = new JButton();
				 JbE9 = new JButton();
			
				 JBnull1 = new JButton();
				 JBnull1.setBackground(Color.black);
				 JBnull1.setEnabled(false);
				 JBnull2 = new JButton();
				 JBnull2.setBackground(Color.black);
				 JBnull3 = new JButton();
				 JBnull3.setBackground(Color.black);
				 JBnull4 = new JButton();
				 JBnull4.setBackground(Color.black);
				 JBnull5 = new JButton();
				 JBnull5.setBackground(Color.black);
				 JBnull6 = new JButton();
				 JBnull6.setBackground(Color.black);
				 JBnull7 = new JButton();
				 JBnull7.setBackground(Color.black);
				 JBnull8 = new JButton();
				 JBnull8.setBackground(Color.black);
				 JBnull9 = new JButton();
				 JBnull9.setBackground(Color.black);
				 JBnull10 = new JButton();
				 JBnull10.setBackground(Color.black);
				 
				 JBnull11 = new JButton();
				 JBnull11.setBackground(Color.black);				 
				 JBnull12 = new JButton();
				 JBnull12.setBackground(Color.black);
				 JBnull13 = new JButton();
				 JBnull13.setBackground(Color.black);
				 JBnull14 = new JButton();
				 JBnull14.setBackground(Color.black);
				 JBnull15 = new JButton();
				 JBnull15.setBackground(Color.black);
				 JBnull16 = new JButton();
				 JBnull16.setBackground(Color.black);
				 JBnull17 = new JButton();
				 JBnull17.setBackground(Color.black);
				 JBnull18 = new JButton();
				 JBnull18.setBackground(Color.black);
				 JBnull19 = new JButton();
				 JBnull19.setBackground(Color.black);
				 JBnull20 = new JButton();
				 JBnull20.setBackground(Color.black);
				 
				 JBnull21 = new JButton();
				 JBnull21.setBackground(Color.black);				 
				 JBnull22 = new JButton();
				 JBnull22.setBackground(Color.black);
				 JBnull23 = new JButton();
				 JBnull23.setBackground(Color.black);
				 JBnull24 = new JButton();
				 JBnull24.setBackground(Color.black);
				 JBnull25 = new JButton();
				 JBnull25.setBackground(Color.black);
				 JBnull26 = new JButton();
				 JBnull26.setBackground(Color.black);
				 JBnull27 = new JButton();
				 JBnull27.setBackground(Color.black);
				 JBnull28 = new JButton();
				 JBnull28.setBackground(Color.black);
				 JBnull29 = new JButton();
				 JBnull29.setBackground(Color.black);
				 JBnull30 = new JButton();
				 JBnull30.setBackground(Color.black);
				
				 
				 JBnull31 = new JButton();
				 JBnull31.setBackground(Color.black);				 
				 JBnull32 = new JButton();
				 JBnull32.setBackground(Color.black);
				 JBnull33 = new JButton();
				 JBnull33.setBackground(Color.black);
				 JBnull34 = new JButton();
				 JBnull34.setBackground(Color.black);
				 JBnull35 = new JButton();
				 JBnull35.setBackground(Color.black);
				 JBnull36 = new JButton();
				 JBnull36.setBackground(Color.black);
				 JBnull37 = new JButton();
				 JBnull37.setBackground(Color.black);
				 JBnull38 = new JButton();
				 JBnull38.setBackground(Color.black);
				 JBnull39 = new JButton();
				 JBnull39.setBackground(Color.black);
				 JBnull40 = new JButton();
				 JBnull40.setBackground(Color.black);
				 
				 JBnull41 = new JButton();
				 JBnull41.setBackground(Color.black);				 
				 JBnull42 = new JButton();
				 JBnull42.setBackground(Color.black);
				 JBnull43 = new JButton();
				 JBnull43.setBackground(Color.black);
				 JBnull44 = new JButton();
				 JBnull44.setBackground(Color.black);
				 JBnull45 = new JButton();
				 JBnull45.setBackground(Color.black);
				 JBnull46 = new JButton();
				 JBnull46.setBackground(Color.black);
				 JBnull47 = new JButton();
				 JBnull47.setBackground(Color.black);
				 JBnull48 = new JButton();
				 JBnull48.setBackground(Color.black);
				 JBnull49 = new JButton();
				 JBnull49.setBackground(Color.black);
				 JBnull50 = new JButton();
				 JBnull50.setBackground(Color.black);
				 JBnull51 = new JButton();
				 JBnull51.setBackground(Color.black);
				 
				 
			// 3. ta좌석 가격
				 taAll = new JTextArea(20,20);
				
			// 4. tf 좌석 합계
				 tfPrice = new JTextField();
			
			// 5 . 결제 버튼 
				 JbDone =new JButton();
				 
		//*********************************************************************
		// 화면 구성
				 // 전체화면
				 JPanel Cinemaview = new JPanel();
				 Cinemaview.setBackground(Color.black);
				
				 
				 	//WEST 
				 	JPanel Seat = new JPanel();   // 영화관 패널 
				 	 Seat.setBackground(Color.black);
				     Seat.setBorder(new TitledBorder("좌석"));
				 	 	
				 		// 좌석 버튼 추가 
				 		
				 		Seat.setLayout(new GridLayout(7,13,7,7)); // 영화관 좌석 그리드 붙은 패널
				 		// a0 
				 		
				 		Seat.add(JBnull1);
				 		Seat.add(JBnull2);
				 		Seat.add(JBnull3);
				 		Seat.add(JBnull4);
				 		Seat.add(JBnull5);
				 		Seat.add(JBnull6);
				 		Seat.add(JBnull7);
				 		Seat.add(JBnull8);
				 		Seat.add(JBnull9);
				 		Seat.add(JBnull10);
				 		Seat.add(JBnull11);
				 		Seat.add(JBnull12);
				 		Seat.add(JBnull13);
				 		
				 		Seat.add(JBnull14);
				 		Seat.add(JbA1);
				 		Seat.add(JbA2);
				 		Seat.add(JBnull15);
				 		Seat.add(JbA3);
				 		Seat.add(JbA4);
				 		Seat.add(JbA5);
				 		Seat.add(JbA6);
				 		Seat.add(JbA7);
				 		Seat.add(JBnull16);
				 		Seat.add(JbA8);
				 		Seat.add(JbA9);
				 		Seat.add(JBnull17);
				 		
				 		Seat.add(JBnull18);
				 		Seat.add(JbB1);
				 		Seat.add(JbB2);
				 		Seat.add(JBnull19);
				 		Seat.add(JbB3);
				 		Seat.add(JbB4);
				 		Seat.add(JbB5);
				 		Seat.add(JbB6);
				 		Seat.add(JbB7);
				 		Seat.add(JBnull20);
				 		Seat.add(JbB8);
				 		Seat.add(JbB9);
				 		Seat.add(JBnull21);
				 		
				 		Seat.add(JBnull22);
				 		Seat.add(JbC1);
				 		Seat.add(JbC2);
				 		Seat.add(JBnull23);
				 		Seat.add(JbC3);
				 		Seat.add(JbC4);
				 		Seat.add(JbC5);
				 		Seat.add(JbC6);
				 		Seat.add(JbC7);
				 		Seat.add(JBnull24);
				 		Seat.add(JbC8);
				 		Seat.add(JbC9);
				 		Seat.add(JBnull25);
				 		
				 		Seat.add(JBnull26);
				 		Seat.add(JbD1);
				 		Seat.add(JbD2);
				 		Seat.add(JBnull27);
				 		Seat.add(JbD3);
				 		Seat.add(JbD4);
				 		Seat.add(JbD5);
				 		Seat.add(JbD6);
				 		Seat.add(JbD7);
				 		Seat.add(JBnull28);
				 		Seat.add(JbD8);
				 		Seat.add(JbD9);
				 		Seat.add(JBnull29);
				 		
				 		Seat.add(JBnull30);
				 		Seat.add(JbE1);
				 		Seat.add(JbE2);				 		
				 		Seat.add(JBnull31);
				 		
				 		Seat.add(JBnull32);
				 		Seat.add(JBnull33);
				 		Seat.add(JBnull34);
				 		Seat.add(JBnull35);
				 		Seat.add(JBnull36);
				 		
				 		Seat.add(JBnull37);
				 		Seat.add(JbE8);
				 		Seat.add(JbE9);
				 		Seat.add(JBnull38);
				 				 	
				 		Seat.add(JBnull39);
				 		Seat.add(JBnull40);
				 		Seat.add(JBnull41);
				 		Seat.add(JBnull42);
				 		Seat.add(JBnull43);
				 		Seat.add(JBnull44);
				 		Seat.add(JBnull45);
				 		Seat.add(JBnull46);
				 		Seat.add(JBnull47);
				 		Seat.add(JBnull48);
				 		Seat.add(JBnull49);
				 		Seat.add(JBnull50);
				 		Seat.add(JBnull51);
				 		
				 		
				 		
				 		
				 	//east 
				 	JPanel Selection = new JPanel();
					Selection.setBorder(new TitledBorder("계산"));
				 		
						JPanel JpSel = new JPanel();
						
						
							// 영화, 시간 올라갈 패널
							JPanel Sel_combox = new JPanel();
							Sel_combox.setBorder(new TitledBorder("1"));
						
							Sel_combox.setLayout(new GridLayout(2,2));
							Sel_combox.add(new JLabel("영화 선택"));
							Sel_combox.add(comMovie);
							Sel_combox.add(new JLabel("시간 선택"));
							Sel_combox.add(comTime);
						
							// e열 6번 8000원 올라갈 패널
							JPanel Sel_Seat = new JPanel();
							Sel_Seat.setBorder(new TitledBorder("2"));
						
						Sel_Seat.setLayout(new BorderLayout());
						Sel_Seat.add(taAll , BorderLayout.CENTER);
						Sel_Seat.add(tfPrice , BorderLayout.SOUTH);
						
					
						JpSel.setLayout(new BorderLayout());
						JpSel.add(Sel_combox , BorderLayout.NORTH);
						JpSel.add(Sel_Seat , BorderLayout.CENTER);	
						
					// 패널 추가 그리드 3,1	
					Selection.setLayout(new BorderLayout());
					Selection.add(JpSel , BorderLayout.NORTH);
					Selection.add(JbDone , BorderLayout.CENTER);
				
					
				 // 2분할 
				 Cinemaview.setLayout(new BorderLayout());
				 Cinemaview.add( Seat, BorderLayout.CENTER ); 
				 Cinemaview.add( Selection , BorderLayout.EAST);
				 	
				 setLayout(new BorderLayout());
				 add(Cinemaview, BorderLayout.CENTER);

	}

}


