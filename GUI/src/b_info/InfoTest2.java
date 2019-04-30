package b_info;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class InfoTest2 {

	//1 . 멤버변수 선언
	JFrame f;
	JButton bAdd, bShow, bSearch, bDelete, bCancle, bExit;
	JTextArea ta;
	JTextField tfName, tfId, tfTel, tfSex,tfAge, tfHome;

	ArrayList<TestPerson> list = new ArrayList<TestPerson>();

	//2. 멤버 객체 생성
	InfoTest2(){
		f = new JFrame("정보");

		bAdd = new JButton("추가");
		bShow = new JButton("show");
		bSearch = new JButton("검색");
		bDelete = new JButton("삭제");
		bCancle = new JButton("취소");
		bExit = new JButton("나가기");

		ta = new JTextArea();

		tfName =new JTextField(15);
		tfId =new JTextField(15);
		tfTel =new JTextField(15);
		tfSex =new JTextField(15);
		tfAge =new JTextField(15);
		tfHome =new JTextField(15);


	}



	// 3. 화면 붙이기 및 화면 출력
	void addLayout() {

		BorderLayout bl = new BorderLayout();
		f.setLayout(bl);

		// South 영역 

		JPanel p_south =new JPanel();
		JPanel p_center = new JPanel();
		JPanel p_west = new JPanel();


		p_south.add(bAdd);
		p_south.add(bShow);
		p_south.add(bSearch);
		p_south.add(bDelete);
		p_south.add(bCancle);
		p_south.add(bExit);
		p_south.setLayout(new GridLayout(1, 6));

		f.add(p_south, BorderLayout.SOUTH);

		// WEST 영역 

		p_west.add(new JLabel("name"));
		p_west.add(tfName);
		p_west.add(new JLabel("Id"));
		p_west.add(tfId);
		p_west.add(new JLabel("Tel"));
		p_west.add(tfTel);
		p_west.add(new JLabel("Sex"));
		p_west.add(tfSex);
		p_west.add(new JLabel("Age"));
		p_west.add(tfAge);
		p_west.add(new JLabel("Home"));
		p_west.add(tfHome);
		p_west.setLayout(new GridLayout(6,2));

		f.add(p_west, BorderLayout.WEST);
		// 나머지도 이런방식

		f.add(ta, BorderLayout.CENTER);

		// 전체프레임영역에 붙이기

		f.setSize(720, 580);
		f.setVisible(true);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	//이벤트 등록
	void eventProc() {
		BtnHdlr bh = new BtnHdlr();
		// 버튼과 이벤트핸들러 연결 
		bAdd.addActionListener(bh);
		bShow.addActionListener(bh);
		bSearch.addActionListener(bh);
		bDelete.addActionListener(bh);
		bCancle.addActionListener(bh);
		bExit.addActionListener(bh);

		// 전화번호 텍스필드 엔터 이벤트
		tfTel.addActionListener(new TfHdlr());
		
		// 포커스 이벤트
		tfId.addFocusListener(new IdFocus());
	}//eventProc 
	// 전화번호 텍스필드 포커스이벤트
	class IdFocus implements FocusListener {

		public void focusGained(FocusEvent e) {
		}

		public void focusLost(FocusEvent e) {
			//" 801214-7845167"
			String id = tfId.getText();
			char sung = id.charAt(7);
			if(sung=='1' || sung =='3') tfSex.setText("남자");
			else tfSex.setText("여자");
			// 출신지 
			char from = id.charAt(8);
			if(from == '0')tfHome.setText("서울");
			else tfHome.setText("지방");
			// 나이 
			String nai1 = id.substring(0, 2);
			int nai2 = Integer.parseInt(nai1);
			int age = 0;
			Calendar year = Calendar.getInstance();
			char gen = id.charAt(7);
				if(gen == '1' || gen == '2') {
				age = year.get(Calendar.YEAR) - ( 1900 + nai2) + 1;
			}
				else if(gen == '3' || gen == '4') {
				age = year.get(Calendar.YEAR) - ( 2000 + nai2) + 1;
			}
			tfAge.setText(Integer.toString(age));
		}
		
	}

	class TfHdlr implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("전화번호 이벤트");
			// 1. 사용자가 입력한 전번 얻어오기 
			String tel = tfTel.getText();
			// 2. ArrayList 의 각 TestPerson의 tel과 비교해서 같은지 
			for(TestPerson p : list ) {
				if(p.getTel().equals(tel)) {
					// 3. 해당 person의 멤버값들을 각각 테스트필드에 출력 
					tfName.setText(p.getName());
					tfId.setText(p.getId());
					tfTel.setText(p.getTel());
					tfSex.setText(p.getGender());
					tfAge.setText(String.valueOf(p.getAge()));
					tfHome.setText(p.getHome());

				}
			}
		} 
	}

	class BtnHdlr implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("이벤트 발생");
			Object evt =e.getSource();
			if(evt == bAdd) {
				// 입력버튼이 눌렸을때 
				insert();
				clearTextField();
			}else if(evt == bShow) {
				// 쇼버튼이 눌렸을때 
				show();

			}else if(evt == bSearch) {

			}else if(evt == bDelete) {
				delete();

			}else if(evt == bCancle) {
				clearTextField();

			}else if(evt == bExit) {
				//System.exit(0);
				exit();
			}
		}

	}
	void clearTextField() {
		tfName.setText(null);
		tfId.setText(null);
		tfTel.setText(null);
		tfSex.setText(null);
		tfAge.setText(null);
		tfHome.setText(null);
	}
	void exit() {
		int result = JOptionPane.showConfirmDialog(null, " 종료하십니까?");
		// 종료버튼이 눌렷을때 강제프로그램 종료 ( System.exit(0); )
		if( result == JOptionPane.OK_OPTION) {
			System.exit(0);
		}
	}
	void show() {
		ta.setText("--------------전체보기----------------\n\n");
		for(TestPerson p : list) {
			ta.append(p.toString());

		}
	}
	void insert() {
		// 1, 각 텍스트 필드의 입력값을 얻어오기 
		// 2. 1번 값들을 TestPerson의 멤버 지정 * (1-생성자 / 2- setter ) 
		// 3. ArrayList에 2번 객체 추가 
		// String name = tfName.getText();
		// 나머지.. 

		TestPerson p = new TestPerson();
		p.setName(tfName.getText());			 // tf에 입력한 값을 가져오기 
		p.setId(tfId.getText());
		p.setTel(tfTel.getText());
		p.setGender(tfSex.getText());
		p.setAge(Integer.parseInt(tfAge.getText())); // Integer.parseInt 
		p.setHome(tfHome.getText());

		list.add(p);


	}
	void delete( ) {
		// 1. 사용자가 입력한 전번 얻어오기 
		String tel = tfTel.getText();
		// 2. ArrayList 의 각 TestPerson의 tel과 비교해서 같은지 
		for(TestPerson p : list ) {
			if(p.getTel().equals(tel)) {
				list.remove(p);
				break; 
			}
		}
		clearTextField();
		show();
	}
	void searchTel() {
		// 1. 사용자가 입력한 전번 얻어오기 
		String tel = tfTel.getText();
		// 2. ArrayList 의 각 TestPerson의 tel과 비교해서 같은지 
		for(TestPerson p : list ) {
			if(p.getTel().equals(tel)) {
				// 3. 해당 person의 멤버값들을 각각 테스트필드에 출력 
				tfName.setText(p.getName());
				tfId.setText(p.getId());
				tfTel.setText(p.getTel());
				tfSex.setText(p.getGender());
				tfAge.setText(String.valueOf(p.getAge()));
				tfHome.setText(p.getHome());
			}
		}
	}
	public static void main(String[] args) {
		InfoTest2 it = new InfoTest2();
		it.addLayout();
		it.eventProc();

	}

}
