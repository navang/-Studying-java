package  view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.function.BinaryOperator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import model.dao.RentModel;



public class RentView extends JPanel 
{
	JTextField tfRentTel, tfRentCustName, tfRentVideoNum;
	JButton bRent;

	JTextField tfReturnVideoNum;
	JButton bReturn;

	JTable tableRecentList;

	RentTableModel rentTM;

	//******************************
	// 비지니스 로직 역할을 하는 모델 클래스 선언 
	RentModel db;



	//==============================================
	//	 생성자 함수
	public RentView(){
		addLayout();	//화면구성
		eventProc();	//DB연결
		connectDB();
		selectNonReturn();
	}

	// DB 연결
	void connectDB(){
		try {
			db = new RentModel();

		} catch (Exception e) {

		}
	}


	// 이벤트 등록
	public void eventProc(){	
		ActionHandler ah = new ActionHandler();
		// 이벤트가 발생할 객체를 핸들러와 연결
		tfRentTel.addActionListener(ah);
		bRent.addActionListener(ah);
		bReturn.addActionListener(ah);

	}
	class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object evt = e.getSource();
			if(evt == tfRentTel ) {
				selectCustName();

			}else if (evt == bRent) {
				rentVideo();
				selectNonReturn();

			}else if (evt == bReturn) {
				returnVideo();
				selectNonReturn();
			}

		}
	}

	/*	객체 생성 및 화면 구성   */
	public void addLayout(){
		tfRentTel = new JTextField();
		tfRentCustName = new JTextField();
		tfRentVideoNum = new JTextField();

		tfReturnVideoNum = new JTextField();

		bRent = new JButton("대여");
		bReturn = new JButton("반납");

		rentTM = new RentTableModel();	
		tableRecentList = new JTable(rentTM);


		//-----------------------
		// 1 north, center 로 1차 나눔 
		JPanel p_north = new JPanel();
		p_north.setBorder(new TitledBorder("대여"));
		JPanel p_center = new JPanel();
		p_center.setBorder(new TitledBorder("출력"));

		// 1-위 
		p_north.setLayout(new GridLayout(1,2));

		// 좌
		JPanel p_north_left = new JPanel();
		//	p_north_left.setBorder(new TitledBorder("왼쪽"));

		// 검색란
		JPanel p_north_left_info = new JPanel();
		p_north_left_info.setLayout(new GridLayout(4,2));
		p_north_left_info.add(new JLabel("전화번호"));
		p_north_left_info.add(tfRentTel);
		p_north_left_info.add(new JLabel("고객명"));
		p_north_left_info.add(tfRentCustName);
		p_north_left_info.add(new JLabel("비디오번호"));
		p_north_left_info.add(tfRentVideoNum);
		p_north_left_info.add(bRent);


		// 검색란 을 위, 왼쪽패널에 붙임
		p_north_left.add(p_north_left_info);


		// 우
		JPanel p_north_right = new JPanel();
		p_north_right.setBorder(new TitledBorder("반납"));

		JPanel p_north_return = new JPanel();
		p_north_return.setLayout(new GridLayout(1,3));


		p_north_return.add(new JLabel("비디오번호"));
		p_north_return.add(tfReturnVideoNum);
		p_north_return.add(bReturn);

		p_north_right.add(p_north_return);

		// 좌우 나눔을 레이아웃에 올림

		p_north.add(p_north_left);
		p_north.add(p_north_right);
		//				
		// 1- 출력 
		p_center.setLayout(new BorderLayout());


		//1 전체 레이아웃에 위, 출력 추가 	
		setLayout(new GridLayout(2,1));
		add(p_north);
		add(p_center);


	}



	class RentTableModel extends AbstractTableModel { 

		ArrayList data = new ArrayList();
		String [] columnNames = {"비디오번호","제목","고객명","전화번호","반납예정일","반납여부"};

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
	
	public void selectCustName() {	
		String sel = tfRentCustName.getSelectedText();
		boolean word = bReturn.getSelectedObjects() != null;
		try {
			// 검색결과를 화면 JTable 의 내용을 담당하는 TableModel 안에 data 지정 
			rentTM.data = db.selectCustName(sel, word);
			rentTM.fireTableDataChanged();
		}
		catch (Exception e) {
			System.out.println("검색실패:" + e.getMessage());
		}
		
	}
		
		// 고객검색 선택 
	
	// 미납몰록 출력하는 메소드 
	public void selectNonReturn() {
		try {
			rentTM.data = db.selectList();
			rentTM.fireTableDataChanged();
			
		}catch (Exception ex) {
			System.out.println("검색 실패 " + ex.getMessage());
		}
			
	}

	// 비디오 반납시 처리하는 메소드
	public void returnVideo() {
		int vNum = Integer.parseInt(tfRentVideoNum.getText());	
		
		try {
			db.returnVideo(vNum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	// 비디오 대여시 처리하는 메소드 
	public void rentVideo() {
		//1. 화면에서 필요한 정보 얻어옴
		String tel =tfRentTel.getText();
		int vNum = Integer.parseInt(tfRentVideoNum.getText());		
		
		// 3 . 대여후 결과처리	
		try {
			//2. 모델쪽에서 메소드 호출
			db.rentVideo(tel, vNum);
		} catch (Exception e) {
		
		}		
	}
}
