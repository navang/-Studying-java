package b_info;

import java.awt.*;

import javax.swing.*;

public class Calc_Gui {
	
	JFrame f;
//	JButton bone, btwo, bthree, bfour, bfive, bsix, bseven, beight, bnine, bzero,bmul,bsum,benter,bsub,bdiv;
	
	JButton[] barr = new JButton[16];
	JTextField tf;
	
	Calc_Gui(){
		f = new JFrame("계산기");
		
		for(int i=1; i<10; i++) {
			barr[i] = new JButton(String.valueOf(i));	
		}
		barr[10] = new JButton("=");
		barr[11] = new JButton("0");
		barr[12]= new JButton("+");
		barr[13] = new JButton("-");
		barr[14] = new JButton("*");
		barr[15] = new JButton("/");
		/*
		bone = new JButton("1");
		btwo = new JButton("2");
		bthree = new JButton("3");
		bfour = new JButton("4");
		bfive = new JButton("5");
		bsix = new JButton("6");
		bseven = new JButton("7");
		beight = new JButton("8");
		bnine = new JButton("9");
		benter = new JButton("=");
		bzero = new JButton("0");
		bsum = new JButton("+");
		bsub = new JButton("-");
		bmul = new JButton("*");
		bdiv = new JButton("/");
		*/
		tf = new JTextField(15);
		
	}
	void addLayout() {
		
		BorderLayout bl = new BorderLayout();
		f.setLayout(bl);
		
		JPanel p_center =new JPanel();
		
		for(int i=1; i<16; i++) {
			p_center.add(barr[i]);
		}
		/*
		p_center.add(bone);
		p_center.add(btwo);
		p_center.add(bthree);
		p_center.add(bfour);
		p_center.add(bfive);
		p_center.add(bsix);
		p_center.add(bseven);
		p_center.add(beight);
		p_center.add(bnine);
		p_center.add(bsum);	
		p_center.add(bzero);
	
		p_center.add(benter);
		p_center.add(bsub);
		p_center.add(bmul);
		p_center.add(bdiv);	*/
		p_center.setLayout(new GridLayout(5,3));
		
		f.add(p_center, BorderLayout.CENTER);
		f.add(tf, BorderLayout.NORTH);
		
		f.setSize(400, 300);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		Calc_Gui it = new Calc_Gui();
		it.addLayout();
	}

}
