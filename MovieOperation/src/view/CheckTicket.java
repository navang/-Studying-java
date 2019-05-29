package view;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.TitledBorder;
import java.util.*;

public class CheckTicket extends JPanel {
	
	UserTicketing ut;
	JTextField tfckNum, tfmovieT, tfDate, tfTime, tfthNum, tfseNum;
	JButton okBT;
	JButton cancelBT;
	
	public CheckTicket(UserTicketing ut) {
		this.ut = ut;
		addLayout();
	}

	public void addLayout() {
		//객체생성
		tfckNum = new JTextField(10);
		okBT = new JButton("확인");
		cancelBT = new JButton("예약 취소");
		tfmovieT = new JTextField();
		tfDate = new JTextField();
		tfTime = new JTextField();
		tfthNum = new JTextField();
		tfseNum = new JTextField();
		tfmovieT.setEditable(false);
		tfDate.setEditable(false);
		tfTime.setEditable(false);
		tfthNum.setEditable(false);
		tfseNum.setEditable(false);
		
		
		
		//기본설정
		setLayout(new BorderLayout());
		
		//티켓확인 구성
		JPanel p_c = new JPanel();
		p_c.setLayout(new BorderLayout());
		
		//예매번호 입력
		JPanel p_cn = new JPanel();
		p_cn.setBorder(new TitledBorder(""));
		p_cn.add(new JLabel("예매번호 확인"));
		p_cn.add(tfckNum);
		p_cn.add(okBT);
		p_c.add(p_cn, BorderLayout.NORTH);
		
		//예매정보 출력
		JPanel p_cc = new JPanel();
		p_cc.setBorder(new TitledBorder("예매정보 확인"));
		p_cc.setLayout(new GridLayout(5,2));
		p_cc.add(new JLabel("영화제목", JLabel.CENTER));
		p_cc.add(tfmovieT);
		p_cc.add(new JLabel("상영날짜", JLabel.CENTER));
		p_cc.add(tfDate);
		p_cc.add(new JLabel("상영시간", JLabel.CENTER));
		p_cc.add(tfTime);
		p_cc.add(new JLabel("관 번호", JLabel.CENTER));
		p_cc.add(tfthNum);
		p_cc.add(new JLabel("좌석번호", JLabel.CENTER));
		p_cc.add(tfseNum);
		p_c.add(p_cc, BorderLayout.CENTER);
		
		//붙이기
		add(p_c, BorderLayout.CENTER);
		add(cancelBT, BorderLayout.EAST);
		
	}
}
