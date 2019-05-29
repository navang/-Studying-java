package view;

import java.awt.BorderLayout;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import model.vo.Movie;

public class UserTicketing extends JFrame {
	
	SelectMovie sm;
	Payment pay;
	CheckTicket ct;
	ThNum1 th1;
	ThNum2 th2;
	public CardLayout card;
	JPanel pan;
	public Movie movie;
	
	public UserTicketing() {
		//화면 객체 생성
		sm = new SelectMovie(this);
		pay = new Payment(this);
		ct = new CheckTicket(this);
		th1 = new ThNum1(this);
		th2 = new ThNum2();
		card = new CardLayout();
		pan = new JPanel();
		movie = new Movie();
		
		//card Layout 붙이기
		pan.setLayout(card);
		pan.add("1", sm);
		pan.add("2", th1);
		pan.add("3", th2);
		pan.add("4", pay);
		
		JTabbedPane  pane = new JTabbedPane();

		pane.add("영화예매", pan);
		pane.add("예약확인", ct);
		
		//화면구성
		add(pane, BorderLayout.CENTER);
		setSize(1440, 1080);
		setVisible( true );
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
	}

	public static void main(String[] args) {
		UserTicketing ut = new UserTicketing();

	}

}
