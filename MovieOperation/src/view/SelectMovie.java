package view;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import dbmodel.TicketingModel;
import model.vo.Movie;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

public class SelectMovie extends JPanel {
	
	UserTicketing ut;
	JList<String> movieList;
	Vector<String> movieLM;
	Vector<String> dateM;
	JTextField tfmovieTitle, tfmovieDate, tfmovieTime, tfthNum, tfseatNum;
	JButton next;
	JButton [] today;
	String [] todayText;
	TicketingModel db;
	CardLayout poster, schedule;
	JPanel p_wc, p_ec;
	ArrayList<String> scheList;
	ArrayList<JButton> scheButton1;
	ArrayList<JButton> scheButton2;

	public SelectMovie(UserTicketing ut) {
		this.ut = ut;
		connectDB();
		addLayout();
		showSchedule();
		eventProc();
	}
	
	public void connectDB() {
		try {
			db = new TicketingModel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addLayout() {
		
		//객체 생성
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
		next = new JButton("좌석선택");
		poster = new CardLayout();
		today = new JButton [7];
		todayText = new String [7];
		scheList = new ArrayList<String>();
		scheButton1 = new ArrayList<JButton>();
		scheButton2 = new ArrayList<JButton>();
		p_ec = new JPanel();
		schedule = new CardLayout();
		//기본설정
		setLayout(new BorderLayout());
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(1,2));
		
		//왼쪽
		JPanel p_w = new JPanel();
		p_w.setLayout(new BorderLayout());
		
		//왼쪽의 영화목록 
		JPanel p_ww = new JPanel();
		p_ww.setBorder(new TitledBorder("영화"));
		movieLM = new Vector<String>();
		try {
			movieLM = db.movieList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		movieList = new JList<String>(movieLM);
		p_ww.add(movieList);
		p_w.add(p_ww, BorderLayout.WEST);
		
		//왼쪽에 영화 포스터
		p_wc = new JPanel();
		p_wc.setBorder(new TitledBorder("포스터"));
		p_wc.setLayout(poster);
		int n = movieLM.size();
		for(int i = 0; i < n; i++) {
			ImageIcon pos = new ImageIcon("src\\img\\" + Integer.toString(i + 1) + ".jpg");
			JLabel moviePoster = new JLabel(pos);
			p_wc.add(Integer.toString(i) , moviePoster);
		}
		p_wc.setVisible(false);
		p_w.add(p_wc, BorderLayout.CENTER);
		
		//오른쪽
		JPanel p_e = new JPanel();
		p_e.setLayout(new BorderLayout());
		
		//오른쪽 날짜
		JPanel p_ew = new JPanel();
		p_ew.setBorder(new TitledBorder("날짜"));
		p_ew.setLayout(new GridLayout(7,1));
		dateM = getCald();
		for(int i = 0; i < dateM.size(); i++) {
			String day = dateM.get(i);
			StringTokenizer st = new StringTokenizer(day, "-");
			st.nextToken();
			String result = st.nextToken() + "/" +st.nextToken();
			today[i] = new JButton(result);
			todayText[i] = result;
			p_ew.add(today[i]);
			if(i > 2) {
				today[i].setEnabled(false);
			}
		}
	
	
		p_e.add(p_ew, BorderLayout.WEST);
		
		//오른쪽 상영 스케줄 
		p_ec.setBorder(new TitledBorder("스케줄"));
		p_ec.setLayout(schedule);
		p_ec.setVisible(false);
		p_e.add(p_ec, BorderLayout.CENTER);
		
		//아래 예매현황
		JPanel p_n = new JPanel();
		p_n.setLayout(new GridLayout(1,5));
		p_n.add(new JLabel(""));
		
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
		p_n3.add(new JLabel(""));
		p_n.add(p_n3);
		
		//좌석선택 버튼
		p_n.add(next);
		
		//왼쪽, 오른쪽 붙이기
		p.add(p_w);
		p.add(p_e);
		add(p, BorderLayout.CENTER);
		add(p_n, BorderLayout.SOUTH);
	}
	//이벤트 등록
	public void eventProc() {
		SMHdlr smh = new SMHdlr();
		next.addActionListener(smh);
		ClickMovie cmm = new ClickMovie();
		movieList.addMouseListener(cmm);
		for(int i = 0; i < today.length; i++) {
			today[i].addActionListener(smh);
		}
		for(int i = 0; i < scheButton1.size(); i++) {
			scheButton1.get(i).addActionListener(smh);
		}
		for(int i = 0; i < scheButton2.size(); i++) {
			scheButton2.get(i).addActionListener(smh);
		}
		
	}
	//날짜가져오자
	public Vector<String> getCald() {
		try {
			return db.getCald();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//스케쥴 가져오기
	public void showSchedule() {
		for(int i = 0; i < movieLM.size(); i++) {
			String mtitle = movieLM.get(i);
			for(int j = 0; j < 3; j++) {
				String day = todayText[j];
				JPanel sch = new JPanel();
				sch.setLayout(new GridLayout(2,1));
				JPanel sch_1 = new JPanel();
				JPanel sch_2 = new JPanel();
				sch_1.setBorder(new TitledBorder("1관"));
				sch_1.setLayout(new GridLayout(3,3));
				sch_2.setBorder(new TitledBorder("2관"));
				sch_2.setLayout(new GridLayout(3,3));
				try {
					scheList = db.showSchedule(mtitle, day, 1);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(scheList == null) {
				
				}else {
					int n = 0;
					while(n < scheList.size()) {
						JButton a = new JButton(scheList.get(n));
						sch_1.add(a);
						n++;
						scheButton1.add(a);
					}
				}

				try {
					scheList = db.showSchedule(mtitle, day, 2);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(scheList == null) {
					
				}else {
					int n = 0;
					while(n < scheList.size()) {
						JButton a = new JButton(scheList.get(n));
						sch_2.add(a);
						n++;
						scheButton2.add(a);
					}
				}
				
				sch.add(sch_1);
				sch.add(sch_2);
				p_ec.add(Integer.toString(i) + Integer.toString(j), sch);
			}
		}

	}

	//선택정보 저장
	public void setMovie() {
		ut.movie.setModate(tfmovieDate.getText());
		ut.movie.setThNum(Integer.parseInt(tfthNum.getText()));
		ut.movie.setTime(tfmovieTime.getText());
		ut.movie.setTitle(tfmovieTitle.getText());
	}
	
	
	//이벤트 핸들러
	class SMHdlr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			for(int i = 0; i < today.length; i++) {
				if(obj == today[i]) {
					tfmovieDate.setText(todayText[i]);
					String name = Integer.toString(movieList.getSelectedIndex()) + Integer.toString(i);
					schedule.show(p_ec, name);
					p_ec.setVisible(true);
				}
			}
			for(int i = 0; i < scheButton1.size(); i++) {
				if(obj == scheButton1.get(i)) {
					String time = scheButton1.get(i).getText();
					tfmovieTime.setText(time);
					tfthNum.setText("1");
					setMovie();
				}
			}
			for(int i = 0; i < scheButton2.size(); i++) {
				if(obj == scheButton2.get(i)) {
					String time = scheButton2.get(i).getText();
					tfmovieTime.setText(time);
					tfthNum.setText("2");
					setMovie();
				}
			}
			if(obj == next) {
				setMovie();
				if(tfthNum.getText().equals("1")) {
					ut.th1.setText();
					ut.th1.ticketingSeat();
					ut.card.show(ut.pan, "2");
				}else if(tfthNum.getText().equals("2")) {
					ut.card.show(ut.pan, "3");
				}
			}

		}
	}
	class ClickMovie extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			Object obj = e.getSource();
			if(obj == movieList) {
				String name = Integer.toString(movieList.getSelectedIndex());
				poster.show(p_wc, name);
				tfmovieTitle.setText(movieList.getSelectedValue());
				p_wc.setVisible(true);
			}
			
		}
		
	}
}

