package c_event;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TestB extends JFrame implements ActionListener {

	JButton b;
	JTextField tf;
	
	TestB() {
		b = new JButton("버튼");
		tf = new JTextField("입력해봐", 30); 
	}
	
	void addLayout() {

		setLayout(new FlowLayout());
		add(b);
		add(tf);
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	void eventProc() {  //연결 
		b.addActionListener(this);
		tf.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) { // overriding 
		
		JOptionPane.showMessageDialog(null, " 버튼 이벤트 발생");
	}
	public static void main(String[] args) {
		
		TestB t = new TestB();
		t.addLayout();
		t.eventProc();

	}

	

}
