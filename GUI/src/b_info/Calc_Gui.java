package b_info;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Calc_Gui {
	// 1. 멤버변수 선언
	JFrame f;
	//	JButton bone, btwo, bthree, bfour, bfive, bsix, bseven, beight, bnine, bzero,bmul,bsum,benter,bsub,bdiv;

	JButton[] barr = new JButton[16];
	JTextField tf;


	int[] su;
	String[] op;
	//2. 멤버객체 생성
	Calc_Gui(){
		f = new JFrame("계산기");

		for(int i=1; i<10; i++) {
			barr[i] = new JButton(String.valueOf(i));	// (int)값을 String으로 바꿔줌 
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

	// 3. 화면붙이기 및 화면 출력
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
	// 이벤트 등록 
	void eventProc() {
		BtnHdlr bh = new BtnHdlr();
		for(int i=1; i<16; i++) {
			barr[i].addActionListener(bh);
		} // barr[1]~ barr[15] 이벤트 핸들러 연결
	}
	class BtnHdlr implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("클릭이벤트 발생");
			JButton evt =(JButton)e.getSource();
			for(int i=1; i<16; i++) { // 숫자까지 이벤트
				if(evt == barr[i]) {
					if(i < 10) {	// 숫자까지 int로 저장
						tf.setText(barr[i].getText());
						//	int su =Integer.parseInt(barr[i].getText());
						//	list.add(su);

						//su[i]=Integer.parseInt(barr[i].getText());
						//번호판이 사라짐
						showinfo();

					}else if(i >=10 && i<16 ) { // 까지 char로 저장
						tf.setText(barr[i].getText());
						// op[i] = barr[i].getText();	
						//					list.add(op);
						//barr[i].setText(null);


					}
//					else if(i == 12) {
//						su[i]=Integer.parseInt(barr[i].getText());
//						op[i] = barr[i].getText();	
//						tf.setText();
//					}
					

				}
			}

		}
	}
	//	void insert() {
	//		
	//	}
	void showinfo() { // 계산한것과 결과값 출력
	
	}



	public static void main(String[] args) {
		Calc_Gui it = new Calc_Gui();
		it.addLayout();
		it.eventProc();
	}

}
