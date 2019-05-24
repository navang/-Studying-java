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
import javax.swing.table.AbstractTableModel;

import empmodel.dao.empModel;

public class Snackview_emp extends JPanel{	
	// ta
	TextArea taOrder;
	TextField tfOrder;


	// 세트, 먹을거, 음료 각 4개씩
	JButton[] Jbset = new JButton[4];
	String setName[] = {"허니콤보  " , "어벤져스 콤보  " , "콤보콤보  ", "커플콤보"}; // 메뉴이름

	JButton[] Jbsnack = new JButton[4];
	String snackName[] = {"버터오징어  " , "딥인더 치즈나쵸  " , "1인1닭  ", "노가리"}; 

	JButton[] Jbdrink = new JButton[4];
	String drinkName[] = {"콜라  " , "사이다  " , "미닛메이드 ", "아메리카노"}; 

	//각 메뉴종류별 콤보박스
	JComboBox<String> comBoxSetEach[] = new JComboBox[4];
	JComboBox<String> comBoxSnackEach[] = new JComboBox[4];
	JComboBox<String> comBoxDrinkEach[] = new JComboBox[4];

	// 각 메뉴종류별 패널
	JPanel bSPan[];
	JPanel bNPan[];
	JPanel bDPan[];	

	// j table 
	JTable JtableFood;
	SnackTableModel tbModelFood;

	// jb 결제 
	JButton JbDone;

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
		JbDone.addActionListener(hdlr);
		tfOrder.addActionListener(hdlr);


		for (int i =0; i<4; i++ ) {		
			// 메뉴 버튼 각 4개씩 
			Jbset[i].addActionListener(hdlr);
			Jbsnack[i].addActionListener(hdlr);
			Jbdrink[i].addActionListener(hdlr);
		}

	}

	//



	// 버튼 이벤트 핸들러 만들기
	class ButtonEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			Object o = ev.getSource();

			if(o==JbDone){  
				searchFood(); // 재고확인 
				JbDoneCheck();// 이벤트확인
			}
			else{
				for(int i=0; i<4; i++) {
					if(o == Jbset[i]) {

						JOptionPane.showMessageDialog(null,setName[i]);
						taOrder.append(setName[i]+"\n");
						// 이벤트확인

					}else if(o == Jbsnack[i]) {
						JOptionPane.showMessageDialog(null,snackName[i]);
						taOrder.append(snackName[i]+"\n");
						// 이벤트확인

					}else if(o == Jbdrink[i]) {
						JOptionPane.showMessageDialog(null,drinkName[i]);
						taOrder.append(drinkName[i]+"\n");
						// 이벤트확인
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
		String food = Jbset[0].getText();
		int fcnt = (Integer)(comBoxSetEach[0].getSelectedIndex());
		
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
		//멤버변수의 객체 생

		for (int i =0; i<4; i++ ) {				// 콤보박스는  12개
			String []cbEachStr = {"1","2","3","4","5","6","7","8","9"};
			comBoxSetEach[i] = new JComboBox(cbEachStr);
			comBoxSnackEach[i] = new JComboBox(cbEachStr);
			comBoxDrinkEach[i] = new JComboBox(cbEachStr);
		}
		/*
				comBoxSetEach[] = new JComboBox<E>();
				comBoxSnackEach[] = new JComboBox<E>();
				comBoxDrinkEach[] = new JComboBox<E>();
		 */
		for (int i =0; i<12; i++ ) {		
			// 메뉴에 들어갈 수량 1~9


			// 메뉴 버튼 각 4개씩 
			if( i < 4) {
				Jbset[i] = new JButton();
				Jbsnack[i] = new JButton();
				Jbdrink[i] = new JButton();
			}
		}
		JPanel bSPan[] = new JPanel[4];		
		JPanel bNPan[] = new JPanel[4];
		JPanel bDPan[] = new JPanel[4];



		for(int i=0; i<4; i++) {
			bSPan[i] = new JPanel();
			bNPan[i] = new JPanel();
			bDPan[i] = new JPanel();
		}

		// ta
		taOrder = new TextArea();
		tfOrder = new TextField();

		tbModelFood = new SnackTableModel();
		JtableFood = new JTable(tbModelFood);

		JbDone = new JButton();


		//*********************************************************************
		// 화면 구성

		// 전체화면
		JPanel sView = new JPanel();


		// 메뉴 & 메뉴확인 
		JPanel pa = new JPanel();
		//pa.setBorder(new TitledBorder("p1"));

		//1번
		JPanel p1 = new JPanel();
		//p1.setBorder(new TitledBorder("p1"));



		for(int i=0; i<4; i++) {
			bSPan[i].setLayout(new BorderLayout());
			bSPan[i].add(Jbset[i] , BorderLayout.CENTER);
			bSPan[i].add(comBoxSetEach[i] ,BorderLayout.SOUTH);
		}
		for(int i=0; i<4; i++) {
			bNPan[i].setLayout(new BorderLayout());
			bNPan[i].add(Jbsnack[i] , BorderLayout.CENTER);
			bNPan[i].add(comBoxSnackEach[i] ,BorderLayout.SOUTH);
		}
		for(int i=0; i<4; i++) {
			bDPan[i].setLayout(new BorderLayout());
			bDPan[i].add(Jbdrink[i] , BorderLayout.CENTER);
			bDPan[i].add(comBoxDrinkEach[i] ,BorderLayout.SOUTH);
		}

		p1.setLayout(new GridLayout(3,5));
		p1.add(new JLabel("세트메뉴"));
		for(int i=0; i<4; i++) {
			p1.add(bSPan[i]);			
		}

		p1.add(new JLabel("간식메뉴"));
		for(int i=0; i<4; i++) {
			p1.add(bNPan[i]);			
		}

		p1.add(new JLabel("음료메뉴"));
		for(int i=0; i<4; i++) {
			p1.add(bDPan[i]);			
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
		p4.add(JbDone , BorderLayout.CENTER);


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



