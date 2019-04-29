package b_info;

import java.awt.*;

import javax.swing.*;


public class InfoTest {

	//1 . 멤버변수 선언
	JFrame f;
	JButton bAdd, bShow, bSearch, bDelete, bCancle, bExit;
	JTextArea ta;
	JTextField tfName, tfId, tfTel, tfSex,tfAge, tfHome;

	
	//2. 멤버 객체 생성
	InfoTest(){
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
		p_south.add(bAdd);
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
	public static void main(String[] args) {
		InfoTest it = new InfoTest();
		it.addLayout();
	}

}
