package c_event;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TestA extends JFrame{  // 이너클래스를 통함 

	JButton b;
	JTextField tf;

	TestA() {
		b = new JButton("버튼");
		tf = new JTextField("입력>", 30); 
	}

	void addLayout() {
		setLayout(new FlowLayout());
		add(b);
		add(tf);
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	}
	void eventProc() {
		//2. 핸들러 객체 생성 
		MyEvent me = new MyEvent();
		//3. 이벤트 발생을 원하는 컴포넌트와 연결 
		b.addActionListener(me);
		tf.addActionListener(me);

	}
	//1. 이벤트 핸들러 
	class MyEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object obj= e.getSource();					 // ActionEvent e의 오브젝트를 나눠서 이벤트 발생을 구분 
			if(obj == b) {
				String msg = b.getText();
				JOptionPane.showMessageDialog(null,msg + " 버튼 이벤트 발생");
			}else if(obj == tf){
				String msg = tf.getText();
				JOptionPane.showMessageDialog(null,msg + "를 입력하셨습니다 ");
			}			
		}
	}
	public static void main(String[] args) {

		TestA t = new TestA();
		t.addLayout();
		t.eventProc();
	}

}
