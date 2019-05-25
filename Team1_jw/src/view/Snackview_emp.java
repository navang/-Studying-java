package	 view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import empmodel.dao.empModel;

public class Snackview_emp extends JPanel{	
	// ta
	TextArea taOrder;

	// 세트, 먹을거, 음료 각 4개씩12개 한번에 멤버변수선언
	JButton[][] jbMenu = new JButton[3][4];
	String setName[] = {"허니콤보  " , "어벤져스 콤보  " , "콤보콤보  ", "커플콤보",
			"버터오징어  " , "딥인더 치즈나쵸  " , "1인1닭  ", "노가리",
			"콜라  " , "사이다  " , "미닛메이드 ", "아메리카노"}; // 메뉴이름
	//콤보박스
	JComboBox<String> comBoxEach[][] = new JComboBox[3][4];
	
	// 각 메뉴종류별 패널 12개 
	JPanel pMe[];

	// j table 
	JTable JtableFood;
	SnackTableModel tbModelFood;

	// jb 결제 
	JButton jbDone;

	//**************
	// 비지니스 로직 = 모델 클래스 변수 선언
	empModel db;
	
	//##############################################
	//	constructor method

	public Snackview_emp(){
		addLayout();
		eventProc();
		initStyle();
		connectDB();	// DB연결
	}
	public void connectDB(){	// DB연결
		
		try {
			db = empModel(); // 모델 
		} catch (Exception e) {
			System.out.println("드라이버 로딩 실패 ");
		}
	}
	
	private empModel empModel() {
		// TODO Auto-generated method stub
		return null;
	}
	public void initStyle(){   // 입력하지 못하게 만듬.
		//tfInsertCount.setEditable(false);		
		//tfInsertCount.setHorizontalAlignment(JTextField.RIGHT);
	}
	public void eventProc(){
		ButtonEventHandler hdlr = new ButtonEventHandler();
		jbDone.addActionListener(hdlr);
		
			for (int i =0; i<3; i++ ) {	
				for( int j=0; j<4; j++) {
			// 메뉴 버튼 각 4개씩 
			jbMenu[i][j].addActionListener(hdlr);
			}
		}
	}
	// 버튼 이벤트 핸들러 만들기
	class ButtonEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			Object o = ev.getSource();

			if(o==jbDone){  
				searchFood(); // 재고확인 
				JbDoneCheck();// 이벤트확인
			}
			else{
				for(int i=0; i<12; i++) {
					if(o == jbMenu[i]) {
						JOptionPane.showMessageDialog(null,setName[i]);
						taOrder.append(setName[i]+"\n");					
					}
				}
			}
		}
	}	
	
	// 이벤트 확인용 메소드
	public void JbDoneCheck() {
		JOptionPane.showMessageDialog(null, "주문?");


	}

	// 비디오현황검색
	public void searchFood() {
		// ta에 있는 단어들을 구분해서 개수까지 		
		String food = jbMenu[0][0].getText();
		int fcnt = (Integer)(comBoxEach[0][0].getSelectedIndex());
		
		try {
			// 검색결과를 화면 JTable 의 내용을 담당하는 TableModel 안에 data 지정 
			tbModelFood.data = db.selectAllFood(food,fcnt);
			tbModelFood.fireTableDataChanged();
		}
		catch (Exception e) {
			System.out.println("검색실패:" + e.getMessage());
		}

	}

	//  화면설계 메소드
	public void addLayout(){
		//멤버변수의 객체 생성

		for (int i =0; i<3; i++ ) {	
			for( int j=0; j<4; j++) {
				// 콤보박스는  3*4개
				String []cbEachStr = {"1","2","3","4","5","6","7","8","9"};
				// 콤보박스 
				comBoxEach[i][j] = new JComboBox(cbEachStr);
				
				// 메뉴 버튼 12
				jbMenu[i][j] = new JButton();
			}
			
			
		}
		// 버튼과 콤박이 올라갈 메뉴의 버튼 
		JPanel pMe[][] = new JPanel[3][5];		
		
		for(int i=0; i<3; i++) {
			for( int j=0; j<5; j++) {
				pMe[i][j] = new JPanel();}	
			
			
		}
		// ta
		taOrder = new TextArea();
	
		//table 
		tbModelFood = new SnackTableModel();
		JtableFood = new JTable(tbModelFood);
		// 결제버튼 
		jbDone = new JButton();

		//*********************************************************************
		// 화면 구성

		// 전체화면-------------------
		JPanel sView = new JPanel();
		
			// 메뉴 & 메뉴확인 --------------
			JPanel pa = new JPanel();
			//pa.setBorder(new TitledBorder("p1"));

				//1번
				JPanel p1 = new JPanel();
				//p1.setBorder(new TitledBorder("p1"));

					for(int i=0; i<3; i++) {
						for (int j=0; j<4; j++) {					
						pMe[i][j].setLayout(new BorderLayout());
						pMe[i][j].setBorder(new TitledBorder(String.valueOf(j)));
						
						pMe[i][j].add(jbMenu[i][j] , BorderLayout.CENTER);
						pMe[i][j].add(comBoxEach[i][j] ,BorderLayout.SOUTH);
								
						}
					}
					// p1 에 버튼 붙이기 맨앞줄은 라벨 
					p1.setLayout(new GridLayout(3,5));
					for(int i=0; i<3; i++) {
						for (int j =0; j <4; j++) {
							if(i == 0 && j == 0) {
								p1.add(new JLabel("세트메뉴"));
								} 
							else {
								p1.add(pMe[i][j]);	
								}								
						    if(i == 1 && j == 0) {
								p1.add(new JLabel("감식메뉴"));
								} 
						    else {
								p1.add(pMe[i][j]);	
								}	
							if(i == 2 && j == 0) {
								p1.add(new JLabel("음료메뉴"));
								} 
							else {
								p1.add(pMe[i][j]);	
								}
							}										
					}
				//3번
				JPanel p3 = new JPanel();
				//p3.setBorder(new TitledBorder("p3"));

				// 3 layout
				p3.setLayout(new BorderLayout());
				p3.add( taOrder );

			//상
			pa.setLayout(new BorderLayout());	
			pa.add(p1 , BorderLayout.CENTER);
			pa.add(p3 , BorderLayout.SOUTH);	


		// 결제 주문테이블 & 결제버튼 	
		JPanel pb = new JPanel();
		//pb.setBorder(new TitledBorder("p1"));

		// 2번
		JPanel p2 = new JPanel();
		//p2.setBorder(new TitledBorder("p2"));

		p2.setLayout(new BorderLayout());
		p2.add(new JScrollPane(JtableFood),BorderLayout.CENTER );

		//4번
		JPanel p4 = new JPanel();
		//p4.setBorder(new TitledBorder("p4"));

		p4.setLayout(new BorderLayout());
		p4.add(jbDone , BorderLayout.CENTER);


		//하
		pb.setLayout(new GridLayout(2,1));		
		pb.add(p2);
		pb.add(p4);

		sView.setLayout(new BorderLayout());
		sView.add(pa , BorderLayout.CENTER);
		sView.add(pb , BorderLayout.EAST);


		setLayout(new BorderLayout());
		add(sView, BorderLayout.CENTER);

	}

	// 화면에 테이블 붙임

	class SnackTableModel extends AbstractTableModel { 

		ArrayList data = new ArrayList();
		String [] columnNames = {"메뉴이름","가격","재고"};

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
}



