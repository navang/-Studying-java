package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import org.w3c.dom.CDATASection;

import model.ScheduleModel;
import vo.Schedule;

public class ScheduleView extends JFrame{

	//**member field***************************
	// lName_스케줄관리, lTitle_영화제목, lCinema_상영관, lCinemeName_관, lDate_상영날짜, 
	// lOpenTime_상영관오픈시간, lCloseTime_상영관마감시간, lMark_기호, lPlayTime_상영시간
	JLabel lName, lTitle, lCinema, lCinemeName, lDate, lOpenTime, lCloseTime, lMark, lPlayTime;
	// cbTitle_영화제목, cbCinema_상영관, cbDate_상영날짜
	JComboBox cbTitle, cbCinema, cbDate;
	//tfOpenTime_시작시간, tfCloseTime_끝시간, tfPlayTime_상영시간
	JTextField tfOpenTime, tfCloseTime, tfPlayTime;
	// 만들기 버튼
	JButton bMade;


	JTextField	tfScheduleSearch;	// view 역할
	JTable		tableSchedule;		// model 역할

	ScheduleTableModel tbModelSchedule;

	String [] cinemeNames = {"1", "2"};

	//==============================================
	// 비지니스 로직 역할을 하는 모델 클래스 선언
	ScheduleModel db;

	//==============================================
	//	 생성자 함수
	public ScheduleView() {
		connectDB();	// DB연결
		addLayout(); 	// 화면설계
		eventProc();	// 이벤트 등록	
		searchSchedule(); //내역확인
		getTime();
	}
	

	// DB 연결
	void connectDB(){
		try {
			db = new ScheduleModel();
			checkSchedule();
		} catch (Exception e) {
			System.out.println("DB 연결 에러발생>"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	// 이벤트 등록
	public void eventProc(){
		ActionHandler ah = new ActionHandler();
		// 이벤트가 발생할 객체들을 핸들러로 연결
		bMade.addActionListener(ah);	//만들기 버튼을 눌렀을 때 이벤트 발생
		cbTitle.addActionListener(ah);	//영화제목을 선택했을 때 상영시간이 뜨는 이벤트 발생
		cbDate.addActionListener(ah);   //날짜별 상영스케줄 확인
		cbCinema.addActionListener(ah);
		
	}
	
	class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			if(o == bMade) {
				madeSchedule();
				checkSchedule();
				searchSchedule();
			} else if(o == cbTitle) {
				getTime();
			} else if(o == cbDate) {
				searchSchedule();
			} else if(o == cbCinema) {
				searchSchedule();
			}
		}
	}
	
	//현재시간이랑 비교해서 상영여부 Y로 바꿔주는 메소드
	public void checkSchedule() {
		try {
			db.changeSchedule();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//스케줄 정보를 만드는 메소드
	public void madeSchedule() {
		
		// 1. 화면 텍스트필드의 입력값 얻어오기	
		Schedule vo = new Schedule();
		
		vo.setMtitle((String) cbTitle.getSelectedItem());	//영화제목 가져오기
		vo.setSthn(cbCinema.getSelectedIndex() + 1);	//상영관 번호 가져오기
		vo.setSdate((String) cbDate.getSelectedItem());	//상영일 가져오기
		String o_time = tfOpenTime.getText();	//상영관 오픈 시간 가져오기
		String c_time = tfCloseTime.getText();	//상영관 마감 시간 가져오기
		int p_time = Integer.parseInt(tfPlayTime.getText());	//상영시간 가져오기
		
		StringTokenizer st = new StringTokenizer(o_time,":");	// 상영관 오픈시간을 :단위로 쪼개기
		int ohour = Integer.parseInt(st.nextToken());	//:앞의 시간 부분을 ohour에 저장
		ohour = ohour*60;	//시간을 분으로 만들기 위해 60곱하기
		int omin = Integer.parseInt(st.nextToken());	//:뒤의 분 부분을 omin에 저장
		int otime = ohour+omin;	//시간을 분으로 만들어 모든 시간을 분으로 저장
		
		StringTokenizer st2 = new StringTokenizer(c_time,":");	// 상영관 마감시간을 :단위로 쪼개기
		int chour = 0;
		int cmin = 0;
		int ctime = 0;
		
		if(st2.countTokens() == 0) {
			ctime = otime;
		}else {
			chour = Integer.parseInt(st2.nextToken());	//:앞의 시간 부분을 chour에 저장
			chour = chour*60;	//시간을 분으로 만들기 위해 60곱하기
			cmin = Integer.parseInt(st2.nextToken());	//:뒤의 분 부분을 cmin에 저장
			ctime = chour+cmin;//시간을 분으로 만들어 모든 시간을 분으로 저장
		}
		int thour = 0;	//thour은 계산된 상영시간의 시를 의미
		int tmin = 0;	//tmin는 계산된 상영시간의 분을 의미
		
		ArrayList<String> ttime = new ArrayList<String>();
		
		for(int i = otime; i<= ctime; i = i + p_time + 25) {
			thour = i / 60;
			tmin = i % 60;
			String time = null;
			if(thour >= 10) {
				if(tmin < 10) {
					time = Integer.toString(thour) + ":0" + Integer.toString(tmin);
				}else {
					time = Integer.toString(thour) + ":" + Integer.toString(tmin);
				}
			}else {
				if(tmin < 10) {
					time = "0" + Integer.toString(thour) + ":0" + Integer.toString(tmin);
				}else {
					time = "0" + Integer.toString(thour) + ":" + Integer.toString(tmin);
				}
			}
			ttime.add(time);
		}
		
		// 2. 모델단의 메소드 1번값들 전송
		try {
			db.madeSchedule(vo, ttime);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		clearTextField();
		
	}
	
	//스케줄 정보의 전체 목록을 확인하는 메소드
	public void searchSchedule() {
		try {
			String date = (String) cbDate.getSelectedItem();
			int num = cbCinema.getSelectedIndex() + 1;
			tbModelSchedule.data = db.searchSchedule(date, num);
			tbModelSchedule.fireTableDataChanged();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "에러발생>"+e.getMessage());
		}
	}
	
	//영화제목 정보 가져오는 메소드
	public Vector<String> inputMovie() {
		try {
			return db.inputMovie();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	//선택한 영화의 상영시간을 가져오는 메소드
	public void getTime() {
		String title = (String) cbTitle.getSelectedItem();
		try {
			tfPlayTime.setText(Integer.toString(db.getTime(title)));
		} catch (Exception e) {
			System.out.println("상영시간 가져오는 에러발생>"+e.getMessage());
			e.printStackTrace();
		}
	}

	//상영정보를 만들고 선택한 것 지우기 메소드
	void clearTextField() {
		tfOpenTime.setText(null);
		tfCloseTime.setText(null);
		
	}

	//날짜를 가져오는 메소드
	public Vector<String> getCald() {
		try {
			return db.getCald();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//  화면설계 메소드
	public void addLayout(){
		//멤버변수의 객체 생성
		lName = new JLabel();
		lName.setText("영화 스케줄 관리");
		lTitle = new JLabel();
		lTitle.setText("영화제목");
		lCinema = new JLabel();
		lCinema.setText("상영관");
		lCinemeName = new JLabel();
		lCinemeName.setText("관");
		lDate = new JLabel();
		lDate.setText("상영날짜");
		lOpenTime = new JLabel();
		lOpenTime.setText("상영관오픈시간");
		lMark = new JLabel();
		lMark.setText("~");
		lCloseTime = new JLabel();
		lCloseTime.setText("상영관마감시간");
		lPlayTime = new JLabel();
		lPlayTime.setText("상영시간");
		
		
		cbTitle = new JComboBox(inputMovie());
		cbCinema = new JComboBox(cinemeNames);
		cbDate = new JComboBox(getCald());
		
		tfOpenTime = new JTextField(7);
		tfCloseTime = new JTextField(7);
		tfPlayTime = new JTextField(7);
		tfPlayTime.setEditable(false);
		
		bMade = new JButton("만들기");

		tbModelSchedule = new ScheduleTableModel();
		tableSchedule = new JTable(tbModelSchedule);
		
		//*********************************************************************
		// 화면 구성
		// NORTH 영역
		JPanel p_north = new JPanel();
		p_north.setBorder(new TitledBorder(""));
		p_north.setLayout(new BorderLayout());
		
			//NORTH - NORTH 영역
			JPanel p_north_n = new JPanel();
			p_north_n.add(lName);
			
			// NORTH - Center 영역
			JPanel p_north_c = new JPanel();
			p_north_c.add(lTitle);
			p_north_c.add(cbTitle);
			p_north_c.add(lCinema);
			p_north_c.add(cbCinema);
			p_north_c.add(lCinemeName);
			p_north_c.add(lDate);
			p_north_c.add(cbDate);
			p_north_c.add(lOpenTime);
			p_north_c.add(tfOpenTime);
			p_north_c.add(lMark);
			p_north_c.add(lCloseTime);
			p_north_c.add(tfCloseTime);
			p_north_c.add(lPlayTime);
			p_north_c.add(tfPlayTime);
			p_north_c.add(bMade);
			
		setLayout(new BorderLayout());
		p_north.add(p_north_n, BorderLayout.NORTH);
		p_north.add(p_north_c, BorderLayout.CENTER);
		
		// CENTER 영역
		JPanel p_center = new JPanel();
		p_center.setBorder(new TitledBorder(""));
		p_center.setLayout(new BorderLayout());
		p_center.add(new JScrollPane(tableSchedule), BorderLayout.CENTER);
		
		// 전체 영역에 붙이기
		setLayout(new BorderLayout());
		add(p_north, BorderLayout.NORTH);
		add(p_center, BorderLayout.CENTER);

			// 화면크기지정
			setSize(1250,750);
			setVisible( true );

			setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	}
	class ScheduleTableModel extends AbstractTableModel { 

		ArrayList data = new ArrayList();
		String [] columnNames = {"스케줄번호","영화제목","상영관","상영시간","날짜","상영여부"};

		//=============================================================
		// 1. 기본적인 TabelModel  만들기
		// 아래 세 함수는 TabelModel 인터페이스의 추상함수인데
		// AbstractTabelModel에서 구현되지 않았기에...
		// 반드시 사용자 구현 필수!!!!

		public int getColumnCount() { 
			return columnNames.length; 
		} 

		public int getRowCount() { 
			return data.size(); 
		} 

		public Object getValueAt(int row, int col) { 
			ArrayList temp = (ArrayList)data.get( row );
			return temp.get( col ); 
		}

		public String getColumnName(int col){
			return columnNames[col];
		}
	}

	public static void main(String[] args) {
		new ScheduleView();
	}
	
}
