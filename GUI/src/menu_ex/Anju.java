package menu_ex;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import menu_ex.Menupan.BtnHdlr;

public class Anju extends JPanel
{	JButton bmenu11, bmenu12, bmenu13;
	public Anju(){
		bmenu11 = new JButton("통오징어철판구이", new ImageIcon("src/menu_ex/foodimg/4_통오징어철판구이.png"));
		bmenu12 = new JButton("5_새우감바스",new ImageIcon("src/menu_ex/foodimg/5_새우감바스.png"));
		bmenu13 = new JButton("7_닭똥집",new ImageIcon("src/menu_ex/foodimg/7_닭똥집.png"));

		bmenu11.setVerticalTextPosition(JButton.BOTTOM);
		bmenu11.setHorizontalTextPosition(JButton.CENTER);
		bmenu12.setVerticalTextPosition(JButton.BOTTOM);
		bmenu12.setHorizontalTextPosition(JButton.CENTER);
		bmenu13.setVerticalTextPosition(JButton.BOTTOM);
		bmenu13.setHorizontalTextPosition(JButton.CENTER);

		//	setBackground( Color.blue );
		add(bmenu11);
		add(bmenu12);
		add(bmenu13);
		setLayout(new GridLayout(1,3));
	}
	public void ActionListener(BtnHdlr evt) {
		// TODO Auto-generated method stub
		
	}
};

