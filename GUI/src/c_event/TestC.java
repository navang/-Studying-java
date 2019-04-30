package c_event;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TestC extends JFrame{

	JButton b;
	JTextField tf;

	TestC() {
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
	void eventProc() {
		//MyEvent evt = new MyEvent();
		//b.addActionListener(evt);
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, " 버튼 이벤트 발생");
			}
		});
		
		tf.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, " 키 이벤트 발생");
			}
		});
	}
	//	class MyEvent implements ActionListener{
	//		public void actionPerformed(ActionEvent e) {
	//			JOptionPane.showMessageDialog(null, " 버튼 이벤트 발생");
	//		}
	//	}
	public static void main(String[] args) {

		TestC t = new TestC();
		t.addLayout();
		t.eventProc();
	}

}
