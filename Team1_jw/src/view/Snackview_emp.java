package	 view;

import java.awt.TextArea;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;


public class Snackview_emp extends JPanel 
{	

	// combox 

	JComboBox comEach1;
	JComboBox comEach2;
	JComboBox comEach3;
	JComboBox comEach4;
	JComboBox comEach5;
	JComboBox comEach6;
	JComboBox comEach7;
	JComboBox comEach8;
	JComboBox comEach9;
	JComboBox comEach10;
	JComboBox comEach11;
	JComboBox comEach12;


	// ta
	TextArea taOrder;

	// jb
	JButton Jbset1;
	JButton Jbset2;
	JButton Jbset3;
	JButton Jbset4;
	JButton Jbset5;

	JButton Jbsnack1;
	JButton Jbsnack2;
	JButton Jbsnack3;
	JButton Jbsnack4;
	JButton Jbsnack5;

	JButton Jbdrink1;
	JButton Jbdrink2;
	JButton Jbdrink3;
	JButton Jbdrink4;
	JButton Jbdrink5;


	// j table 

	JTable JtableSnack;

	SnackTableModel tbModelSnack;

	//**************
	// 비지니스 로직 = 모델 클래스 변수 선언


	//##############################################
	//	constructor method
	/*
	public Snack_emp(){
		addLayout(); 	// 화면설계

		initStyle();

		eventProc();

		connectDB();	// DB연결
	}

	public void connectDB(){	// DB연결
		try {
			db = new ();
		} catch (Exception e) {
			System.out.println("드라이버 로딩 실패 ");
		}
	}

	public void eventProc(){
		ButtonEventHandler hdlr = new ButtonEventHandler();



		// 버튼 이벤트 핸들러 만들기
		class ButtonEventHandler implements ActionListener{
			public void actionPerformed(ActionEvent ev){
				Object o = ev.getSource();

				if(o==b){  
					// 
				}
				else if(o==bV){  
					// 
				}
				else if(o==b){  
					// 
				}
				else if(o==tf){
					//
				}
			}
		}


		public void initStyle(){   // 입력하지 못하게 만듬.
			//tfVideoNum.setEditable(false);  // 편집만 못하게 만듬 -- SetEditable // 기능 상실   -- SetEnabled 
			//tfInsertCount.setEditable(false);		
			//	tfInsertCount.setHorizontalAlignment(JTextField.RIGHT);
		}

		// 


	}


	 *///  화면설계 메소드
	public void addLayout(){
		//멤버변수의 객체 생성

		comEach1 = new JComboBox();
		comEach2 = new JComboBox();
		comEach3 = new JComboBox();
		comEach4 = new JComboBox();
		comEach5 = new JComboBox();
		comEach6 = new JComboBox();
		comEach7 = new JComboBox();
		comEach8 = new JComboBox();
		comEach9 = new JComboBox();
		comEach10 = new JComboBox();
		comEach11 = new JComboBox();
		comEach12 = new JComboBox();


		// ta
		taOrder = new TextArea();

		// jb
		Jbset1 = new JButton();
		Jbset2 = new JButton();
		Jbset3 = new JButton();
		Jbset4 = new JButton();
		Jbset5 = new JButton();


		Jbsnack1 = new JButton();
		Jbsnack2 = new JButton();
		Jbsnack3 = new JButton();
		Jbsnack4 = new JButton();
		Jbsnack5 = new JButton();

		Jbdrink1 = new JButton();
		Jbdrink2 = new JButton();
		Jbdrink3 = new JButton();
		Jbdrink4 = new JButton();
		Jbdrink5 = new JButton();


		tbModelSnack = new SnackTableModel();
		JtableSnack = new JTable(tbModelSnack);
		//*********************************************************************
		// 화면 구성






	}


	class SnackTableModel extends AbstractTableModel { 

		ArrayList data = new ArrayList();
		String [] columnNames = {"주문메뉴","수량"};

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

