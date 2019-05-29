package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.TitledBorder;

import dbmodel.TicketingModel;

import java.util.*;

public class Payment extends JPanel{
	
	UserTicketing ut;
	JTextField tfrawMoney, tfdcMoney, tfpayMoney, tfmovieTitle, tfmovieDate, tfmovieTime, tfthNum, tfseatNum ;
	JCheckBox dcCheck;
	JComboBox comDC; //체크박스 이벤트 핸들러 처리하기
	JButton next , preview;
	TicketingModel db;
	
	public Payment(UserTicketing ut) {
		this.ut = ut;
		connectDB();
		addLayout();
		eventProc();
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
	
	public void addLayout(){
		//객체 생성
		tfrawMoney = new JTextField(16);
		tfdcMoney = new JTextField("0", 16);
		tfpayMoney = new JTextField(16);
		tfrawMoney.setEditable(false);
		tfdcMoney.setEditable(false);
		tfpayMoney.setEditable(false);
		dcCheck = new JCheckBox("할인종류");
		String [] dccb = {"통신사 할인", "직원 할인"};
		comDC = new JComboBox(dccb);
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
		preview = new JButton("좌석선택");
		comDC.setEnabled(false);
	
		//기본설정
		setLayout(new BorderLayout());
		
		//왼쪽화면
		
		//왼쪽화면 할인
		JPanel p_ws = new JPanel();
		p_ws.setBorder(new TitledBorder("할인"));
		p_ws.add(dcCheck);
		p_ws.add(comDC);
		
		//오른쪽 화면
		JPanel p_e = new JPanel();
		p_e.setLayout(new GridLayout(3,1));
		
		//rawmoney
		JPanel p_en = new JPanel();
		p_en.setBorder(new TitledBorder(""));
		p_en.setLayout(new GridLayout(2,1));
		p_en.add(new JLabel("결제하실 금액", JLabel.CENTER));
		JPanel p_en1 = new JPanel();
		p_en1.add(tfrawMoney);
		p_en1.add(new JLabel("원"));
		p_en.add(p_en1);
		p_e.add(p_en);
		
		//discount money
		JPanel p_ec = new JPanel();
		p_ec.setBorder(new TitledBorder(""));
		p_ec.setLayout(new GridLayout(2,1));
		p_ec.add(new JLabel("할인받은 금액", JLabel.CENTER));
		JPanel p_ec1 = new JPanel();
		p_ec1.add(tfdcMoney);
		p_ec1.add(new JLabel("원"));
		p_ec.add(p_ec1);
		p_e.add(p_ec);
		
		//payment money
		JPanel p_es = new JPanel();
		p_es.setBorder(new TitledBorder(""));
		p_es.setLayout(new GridLayout(2,1));
		p_es.add(new JLabel("남은 결제금액", JLabel.CENTER));
		JPanel p_es1 = new JPanel();
		p_es1.add(tfpayMoney);
		p_es1.add(new JLabel("원"));
		p_es.add(p_es1);
		p_e.add(p_es);

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
		add(p_ws, BorderLayout.CENTER);
		add(p_e, BorderLayout.EAST);
		add(p_n, BorderLayout.SOUTH);
	}
	//이벤트 처리
	public void eventProc() {
		PayHdlr phdr = new PayHdlr();
		next.addActionListener(phdr);
		preview.addActionListener(phdr);
		dcCheck.addActionListener(phdr);
		comDC.addActionListener(phdr);
	}
	//예매완료 
	public void comTicketing() {
		try {
			db.insertTicket(ut.movie);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//예약정보 세팅
	public void setText() {
		tfmovieTitle.setText(ut.movie.getTitle());
		tfmovieDate.setText(ut.movie.getModate());
		tfmovieTime.setText(ut.movie.getTime());
		tfthNum.setText(Integer.toString(ut.movie.getThNum()));
		tfseatNum.setText(ut.movie.getSeatNum());
	}
	//예약정보에서 가격 가져오기
	public void setPrice() {
		try {
			tfrawMoney.setText(Integer.toString(db.setPrice(ut.movie.getThNum(), ut.movie.getSeatNum())));
			tfpayMoney.setText(Integer.toString(db.setPrice(ut.movie.getThNum(), ut.movie.getSeatNum())));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	class PayHdlr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if(obj == next) {
				JOptionPane.showMessageDialog(null, "결재 완료");
			}else if(obj == preview) {
				ut.card.show(ut.pan, "2");
			}else if(obj == dcCheck) {
				comDC.setEnabled(dcCheck.isSelected());
				if(!dcCheck.isSelected()) {
					tfdcMoney.setText("0");
					tfpayMoney.setText(tfrawMoney.getText());
				}
			}else if(obj == comDC) {
				int money = Integer.parseInt(tfrawMoney.getText());
				tfdcMoney.setText(Integer.toString((int)(money * 0.1)));
				tfpayMoney.setText(Integer.toString((int)(money * 0.9)));
			}
		}	
	}
	
}
