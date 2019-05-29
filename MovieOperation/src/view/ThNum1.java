package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;

import dbmodel.TicketingModel;

import java.util.*;

public class ThNum1 extends JPanel {

	UserTicketing ut;
	JButton [][] seat;
	HashMap<JButton, String> seatInfo;
	JTextField tfmovieTitle, tfmovieDate, tfmovieTime, tfthNum, tfseatNum;
	JButton next , preview;
	TicketingModel db;
	String seatNum;
	int [][] seatCount;

	public ThNum1(UserTicketing ut){
		this.ut = ut;
		connectDB();
		addLayout();
		eventProc();
		setSeatNum();
	}

	//db연결
	public void connectDB() {
		try {
			db = new TicketingModel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addLayout() {
		//기본구성
		setLayout(new BorderLayout());
		tfmovieTitle = new JTextField(10);
		tfmovieDate = new JTextField(10);
		tfmovieTime = new JTextField(10);
		tfthNum = new JTextField(10);
		tfseatNum = new JTextField(10);
		tfmovieTitle.setEditable(false);
		tfmovieDate.setEditable(false);
		tfmovieTime.setEditable(false);
		tfthNum.setEditable(false);
		tfseatNum.setEditable(false);
		next = new JButton("결재하기");
		preview = new JButton("영화선택");
		seatNum = "";

		//좌석
		JPanel p = new JPanel();
		p.setLayout(null);
		p.setBorder(new TitledBorder(""));
		
		//버튼 생성
		seat = new JButton[5][8];
		for(int i = 0; i < seat.length; i++) {
			for(int j = 0; j < seat[i].length; j++) {
				seat[i][j] = new JButton();
				seat[i][j].setSize(30,30);
				if(i == 0) {
					seat[i][j].setBorder(BorderFactory.createLineBorder(new Color(255, 255, 0), 5));
				}else if(i == 1 && (j < 2 || j > 5)){
					seat[i][j].setBorder(BorderFactory.createLineBorder(new Color(255, 255, 0), 5));
				}else if(i == 2 || (i == 1 && (j >= 2 && j <= 5))) {
					seat[i][j].setBorder(BorderFactory.createLineBorder(new Color(0, 255, 0), 5));
				}else {
					seat[i][j].setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0), 5));
				}
			}

		}
		seatCount = new int [seat.length][seat[0].length];

		//버튼 붙이기
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 5; j++) {
				if(i < 4) {
					seat[j][i].setLocation(420 + 30 * i, 200 + 30 * j);
				}else if(i >= 4) {
					seat[j][i].setLocation(450 + 30 * i, 200 + 30 * j);
				}
				p.add(seat[j][i]);
			}

		}

		String [] label = {"A", "B", "C", "D", "E"};

		//라벨 붙이기
		for(int i = 0; i < seat.length; i++) {
			JLabel l = new JLabel(label[i], JLabel.CENTER);
			l.setSize(30, 30);
			l.setLocation(390, 200 + 30 * i);
			p.add(l);
		}
		
		//열번호 붙이기
		for(int i = 0; i < 8; i++) {
			JLabel c = new JLabel(Integer.toString(i+1), JLabel.CENTER);
			c.setSize(30,30);
			if(i < 4) {
				c.setLocation(420 + 30 * i, 170);
			}else if(i >= 4 ) {
				c.setLocation(450 + 30 * i, 170);
			}
			p.add(c);
		}
		
		//스크린 붙이기
		JLabel screen = new JLabel("SCREEN1", JLabel.CENTER);
		screen.setSize(1072, 50);
		screen.setLocation(2,2);
		screen.setBackground(Color.GREEN);
		screen.setOpaque(true);
		//글자 크기
		Font f = new Font("몰라", Font.BOLD, 30);
		screen.setFont(f);
		p.add(screen);
		
		//아래 예매현황
		JPanel p_n = new JPanel();
		p_n.setLayout(new GridLayout(1,5));
		p_n.add(preview);

		//영화제목
		JPanel p_n1 = new JPanel();
		p_n1.setLayout(new GridLayout(2,1));
		p_n1.setBorder(new TitledBorder(""));
		p_n1.add(new JLabel("영화제목"));
		p_n1.add(tfmovieTitle);
		p_n.add(p_n1);

		//상영시간, 상영날짜
		JPanel p_n2 = new JPanel();
		p_n2.setLayout(new GridLayout(4,1));
		p_n2.setBorder(new TitledBorder(""));
		p_n2.add(new JLabel("상영날짜"));
		p_n2.add(tfmovieDate);
		p_n2.add(new JLabel("상영시간"));
		p_n2.add(tfmovieTime);
		p_n.add(p_n2);

		//상영관, 좌석
		JPanel p_n3 = new JPanel();
		p_n3.setLayout(new GridLayout(4,1));
		p_n3.setBorder(new TitledBorder(""));
		p_n3.add(new JLabel("상영관"));
		p_n3.add(tfthNum);
		p_n3.add(new JLabel("좌석"));
		p_n3.add(tfseatNum);
		p_n.add(p_n3);

		//좌석선택 버튼
		p_n.add(next);
		
		//붙이기
		add(p, BorderLayout.CENTER);
		add(p_n, BorderLayout.SOUTH);
	}
	
	//이벤트 등록
	public void eventProc() {
		SeatHdlr hdrl = new SeatHdlr();
		for(int i = 0; i < seat.length; i++) {
			for(int j = 0; j < seat[i].length; j++) {
				seat[i][j].addActionListener(hdrl);
			}
		}
		next.addActionListener(hdrl);
		preview.addActionListener(hdrl);
	}
	//가져온값 지정
	public void setText(){
		tfmovieTitle.setText(ut.movie.getTitle());
		tfmovieDate.setText(ut.movie.getModate());
		tfmovieTime.setText(ut.movie.getTime());
		tfthNum.setText(Integer.toString(ut.movie.getThNum()));
	}
	//좌석 번호 빼기
	public void deleteSeatNum() {
		seatNum = "";
		for(int i = 0; i < seat.length; i++) {
			for(int j = 0; j < seat[i].length; j++) {
				if(seatCount[i][j] == 1) {
					if(seatNum.equals("")) {
						seatNum += seatInfo.get(seat[i][j]);
					}else {
						seatNum += "," + seatInfo.get(seat[i][j]);
					}
				}
			}
		}
		tfseatNum.setText(seatNum);
	}
	//좌석 예매현황 가져오기
	public void ticketingSeat() {
		char [] ticket = new char [40];
		try {
			ticket = db.ticketingSeat(ut.movie);
			int k = 0;
			for(int i = 0; i < seat.length; i++) {
				for(int j = 0; j < seat[i].length; j++) {
					if(ticket[k] == 'Y') {
						seat[i][j].setBackground(new Color(0, 0, 0));
						seat[i][j].setEnabled(false);
					}
					k++;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//이벤트 핸들러
	class SeatHdlr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			for(int i = 0; i < seat.length; i++) {
				for(int j = 0; j < seat[i].length; j++) {
					if(obj == seat[i][j] && seatCount[i][j] == 0) {
						if(seatNum.equals("")) {
							seatNum += seatInfo.get(seat[i][j]);
						}else {
							seatNum += "," + seatInfo.get(seat[i][j]);
						}
						seatCount[i][j] = 1;
						seat[i][j].setBackground(new Color(0,0,255));
						tfseatNum.setText(seatNum);
					}else if(obj == seat[i][j] && seatCount[i][j] == 1) {
						seatCount[i][j] = 0;
						seat[i][j].setBackground(null);
						deleteSeatNum();
					}
				}
			}
			if(obj == next) {
				ut.movie.setSeatNum(seatNum);
				ut.pay.setPrice();
				ut.pay.setText();
				ut.card.show(ut.pan, "4");
			}else if(obj == preview) {
				ut.card.show(ut.pan, "1");
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