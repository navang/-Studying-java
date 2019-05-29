package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class GraphView extends JFrame{

	//**member field***************************
	// lName_매출현황관리, lDate_날짜, lYear_년, lMonth_월, lDay_일, lMark_기호, lCircle_원, lLine_꺽은선, lStick_막대
	JLabel lName, lDate, lYear, lMonth, lDay, lMark, lCircle, lLine, lStick, lYear2, lMonth2, lDay2;
	// cbYear_년, cbMonth_월, cbDay_일
	JComboBox cbYear, cbMonth, cbDay, cbYear2, cbMonth2, cbDay2;
	// bSearch_검색
	JButton bSearch;
	
	//==============================================
	// 비지니스 로직 역할을 하는 모델 클래스 선언
	

	//==============================================
	//	 생성자 함수
	public GraphView() {
		addLayout(); 	// 화면설계
		eventProc();	// 이벤트 등록
		connectDB();	// DB연결
	}
	
	// DB 연결
	void connectDB(){
		
	}
	
	// 이벤트 등록
	public void eventProc(){
		ActionHandler ah = new ActionHandler();
		// 이벤트가 발생할 객체들을 핸들러로 연결
		bSearch.addActionListener(ah);	//검색 버튼을 눌렀을 때 이벤트 발생
		
	}
	
	class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			if(o == bSearch) {
				searchGraph();
			}
		}
	}	
	
	//매출 현황을 확인하는 메소드
	public void searchGraph() {
		int year = cbYear.getSelectedIndex();
		int month = cbMonth.getSelectedIndex();
		int day = cbDay.getSelectedIndex();
		int year2 = cbYear2.getSelectedIndex();
		int month2 = cbMonth2.getSelectedIndex();
		int day2 = cbDay2.getSelectedIndex();

		try {
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "에러발생>"+e.getMessage());
		}
	}


	//  화면설계 메소드
	public void addLayout(){
		//멤버변수의 객체 생성
		lName = new JLabel();
		lName.setText("매출 현황 관리");
		lDate = new JLabel();
		lDate.setText("날짜");
		lYear = new JLabel();
		lYear.setText("년");
		lMonth = new JLabel();
		lMonth.setText("월");
		lDay = new JLabel();
		lDay.setText("일");
		lMark = new JLabel();
		lMark.setText("~");
		lCircle = new JLabel();
		lCircle.setText("원 그래프");
		lLine = new JLabel();
		lLine.setText("꺽은선 그래프");
		lStick = new JLabel();
		lStick.setText("막대 그래프");
		lYear2 = new JLabel();
		lYear2.setText("년");
		lMonth2 = new JLabel();
		lMonth2.setText("월");
		lDay2 = new JLabel();
		lDay2.setText("일");
		
		cbYear = new JComboBox();
		cbMonth = new JComboBox();
		cbDay = new JComboBox();
		cbYear2 = new JComboBox();
		cbMonth2 = new JComboBox();
		cbDay2 = new JComboBox();
		
		bSearch = new JButton("검색");

		//*********************************************************************
		// 화면 구성
		// NORTH 영역
		setLayout(new BorderLayout());
		JPanel p_north = new JPanel();
		p_north.setBorder(new TitledBorder(""));
		p_north.setLayout(new BorderLayout());

			//NORTH - NORTH 영역
			JPanel p_north_n = new JPanel();
			p_north_n.add(lName);
			
			// NORTH - Center 영역
			JPanel p_north_c = new JPanel();
			p_north_c.add(lDate);
			p_north_c.add(cbYear);
			p_north_c.add(lYear);
			p_north_c.add(cbMonth);
			p_north_c.add(lMonth);
			p_north_c.add(cbDay);
			p_north_c.add(lDay);
			p_north_c.add(lMark);
			p_north_c.add(cbYear2);
			p_north_c.add(lYear2);
			p_north_c.add(cbMonth2);
			p_north_c.add(lMonth2);
			p_north_c.add(cbDay2);
			p_north_c.add(lDay2);
			p_north_c.add(bSearch);
			
		p_north.add(p_north_n, BorderLayout.NORTH);
		p_north.add(p_north_c, BorderLayout.CENTER);
			
		// CENTER 영역
		JPanel p_center = new JPanel();
		p_center.setBorder(new TitledBorder(""));
		p_center.setLayout(new GridLayout(1,2));
		
			// CENTER - WEST 영역
			JPanel p_center_w = new JPanel();
			p_center_w.setBorder(new TitledBorder(""));
			p_center_w.setLayout(new GridLayout(2,1));
			
				// CENTER - WEST - NORTH영역
				JPanel p_center_w_n = new JPanel();
				p_center_w_n.setBorder(new TitledBorder(""));
				p_center_w_n.setLayout(new BorderLayout());
				
				p_center_w_n.add(lCircle, BorderLayout.SOUTH);
				
				// CENTER - WEST - SOUTH영역
				JPanel p_center_w_s = new JPanel();
				p_center_w_s.setBorder(new TitledBorder(""));
				p_center_w_s.setLayout(new BorderLayout());
				
				p_center_w_s.add(lLine, BorderLayout.SOUTH);
			
			p_center_w.add(p_center_w_n);
			p_center_w.add(p_center_w_s);
			
			// CENTER - EAST 영역
			JPanel p_center_e = new JPanel();
			p_center_e.setBorder(new TitledBorder(""));
			p_center_e.setLayout(new BorderLayout());
			
			p_center_e.add(lStick,BorderLayout.SOUTH);
			
		p_center.add(p_center_w);
		p_center.add(p_center_e);
			
			
		// 전체 영역에 붙이기
		add(p_north, BorderLayout.NORTH);
		add(p_center, BorderLayout.CENTER);

		// 화면크기지정
		setSize(1250,750);
		setVisible( true );

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	}
	
	public static void main(String[] args) {
		new GraphView();
	}

}
