package menu_ex;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import menu_ex.Menupan.BtnHdlr;

public class Tang extends JPanel implements ActionListener {

	//Menupan parent;
	JButton bmenu1, bmenu2, bmenu3;
	public Tang(){
		bmenu1 = new JButton("오뎅탕 14,000 원", new ImageIcon("src/menu_ex/foodimg/24_오뎅탕.png"));
		bmenu2 = new JButton("해물누룽지탕",new ImageIcon("src/menu_ex/foodimg/28_해물누룽지탕.png"));
		bmenu3 = new JButton("홍합탕",new ImageIcon("src/menu_ex/foodimg/29_홍합탕.png"));

		bmenu1.setVerticalTextPosition(JButton.BOTTOM);
		bmenu1.setHorizontalTextPosition(JButton.CENTER);
		bmenu2.setVerticalTextPosition(JButton.BOTTOM);
		bmenu2.setHorizontalTextPosition(JButton.CENTER);
		bmenu3.setVerticalTextPosition(JButton.BOTTOM);
		bmenu3.setHorizontalTextPosition(JButton.CENTER);

		//	setBackground( Color.blue );
		add(bmenu1);
		add(bmenu2);
		add(bmenu3);
		setLayout(new GridLayout(1,3));
	}


	public void ActionListener(BtnHdlr evt) {
		Object obj= evt.getSource();					 // ActionEvent e의 오브젝트를 나눠서 이벤트 발생을 구분 
		if(obj == bmenu1) {
			String msg = bmenu1.getText();
			JOptionPane.showMessageDialog(null,msg + " 버튼 이벤트 발생");

		}

	}
}
