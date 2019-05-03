package menu_ex;

import java.awt.*;
import javax.swing.*;

import menu_ex.Menupan.BtnHdlr;

public class Drink extends JPanel
{JButton bmenu21, bmenu22, bmenu23;
public Drink(){
	bmenu21 = new JButton("아메리카노", new ImageIcon("src/menu_ex/foodimg/coffee.png"));
	bmenu22 = new JButton("소주",new ImageIcon("src/menu_ex/foodimg/soju.jpg"));
	bmenu23 = new JButton("막걸리",new ImageIcon("src/menu_ex/foodimg/mak.png"));

	bmenu21.setVerticalTextPosition(JButton.BOTTOM);
	bmenu21.setHorizontalTextPosition(JButton.CENTER);
	bmenu22.setVerticalTextPosition(JButton.BOTTOM);
	bmenu22.setHorizontalTextPosition(JButton.CENTER);
	bmenu23.setVerticalTextPosition(JButton.BOTTOM);
	bmenu23.setHorizontalTextPosition(JButton.CENTER);

	//	setBackground( Color.blue );
	add(bmenu21);
	add(bmenu22);
	add(bmenu23);
	setLayout(new GridLayout(1,3));
}
	public void ActionListener(BtnHdlr evt) {
		// TODO Auto-generated method stub
		
	}
};

