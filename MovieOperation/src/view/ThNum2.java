package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;
import java.util.*;

public class ThNum2 extends JPanel {

	JButton [][] seat;
	HashMap<JButton, String> seatInfo;

	public ThNum2(){
		addLayout();
		eventProc();
		setSeatNum();
	}

	public void addLayout() {
		//기본구성
		setLayout(null);

		//버튼 생성
		seat = new JButton[7][9];
		for(int i = 0; i < seat.length; i++) {
			for(int j = 0; j < seat[i].length; j++) {
				seat[i][j] = new JButton();
				seat[i][j].setSize(30,30);
			}

		}

		//버튼 붙이기
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 7; j++) {
				seat[j][i].setLocation(405 + 30 * i, 200 + 30 * j);
				add(seat[j][i]);
			}

		}

		String [] label = {"A", "B", "C", "D", "E", "F", "G"};

		//라벨 붙이기
		for(int i = 0; i < seat.length; i++) {
			JLabel l = new JLabel(label[i], JLabel.CENTER);
			l.setSize(30, 30);
			l.setLocation(375, 200 + 30 * i);
			add(l);
		}
		
		//열번호 붙이기
		for(int i = 0; i < 9; i++) {
			JLabel c = new JLabel(Integer.toString(i+1), JLabel.CENTER);
			c.setSize(30,30);
			c.setLocation(405 + 30 * i, 170);
			add(c);
		}
		
		//스크린 붙이기
		JLabel screen = new JLabel("SCREEN2", JLabel.CENTER);
		screen.setSize(1080, 50);
		screen.setLocation(0,0);
		screen.setBackground(Color.GREEN);
		screen.setOpaque(true);
		//글자 크기
		Font f = new Font("몰라", Font.BOLD, 30);
		screen.setFont(f);
		add(screen);
	}
	
	//이벤트 등록
	public void eventProc() {
		SeatHdlr hdrl = new SeatHdlr();
		for(int i = 0; i < seat.length; i++) {
			for(int j = 0; j < seat[i].length; j++) {
				seat[i][j].addActionListener(hdrl);
			}
		}
	}
	
	//이벤트 핸들러
	class SeatHdlr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			for(int i = 0; i < seat.length; i++) {
				for(int j = 0; j < seat[i].length; j++) {
					if(obj == seat[i][j]) {
						JOptionPane.showMessageDialog(null, seatInfo.get(seat[i][j]));
					}
				}
			}
			
		}
		
	}
	
	//좌석정보 등록
	public void setSeatNum() {
		seatInfo = new HashMap<JButton, String>();
		char col = 'A';
		for(int i = 0; i < seat.length; i++) {
			for(int j = 0; j < seat[i].length; j++) {
				String num = Character.toString((char) col) + Integer.toString((j + 1));
				seatInfo.put(seat[i][j], num);
			}
			col += 1;
		}
	}
}