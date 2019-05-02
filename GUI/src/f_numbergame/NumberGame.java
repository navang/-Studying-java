package f_numbergame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class MyFrame extends JFrame implements ActionListener{

	int getsu = 4;
	JButton[][] la = new JButton[getsu][getsu];

	char[][]answer = new char[getsu][getsu];

	// 첫번째 버튼 
	JButton firstClick;
	int firstRow, firstCol;


	MyFrame() {
		//객체생성
		//화면붙이기및 출력
		setLayout(new GridLayout(getsu,getsu));

		for(int i=0; i<la.length; i++) {
			for(int j=0; j<la[i].length; j++) {
				la[i][j] = new JButton();
				add(la[i][j]);
				la[i][j].addActionListener(this);
				answer[i][j]='0'; //문자 초기화 
			}
		}
		setSize(700, 500);
		setVisible(true);
		//4. 화면에 출력 

	}
	void initChar () {
		char alpha = '0';
		END :
			for(int i=0; i<getsu*getsu;) {
				//임의의 알파벳 만들기 
				if(i%2 == 0) {
					alpha = (char)('A' + (int)(Math.random()*26));
					// 기존에 이미 이 알파벳이 있는지 확인 
					for(int row=0; row<answer.length; row++) {
						for(int col=0; col<answer[row].length; col++) {
							if(answer[row][col] == alpha) continue END;
						}
					}
				}
				// 임의의 자리에 알파벳 넣기
				boolean ok =false;

				do {
					int row = (int)(Math.random()*getsu);
					int col = (int)(Math.random()*getsu);
					if(answer[row][col] == '0') {
						answer[row][col] = alpha;
						i++;
						ok=true;

					}
				}while(!ok);
			}
	}

	// answer에 각각의 값을 각 버튼에 지정 
	void showAnswer () {
		for (int i = 0; i< answer.length; i++) {
			for (int j = 0; j<answer.length; j++) {
				la[i][j].setText( String.valueOf(answer[i][j]));
			}
		}

				try {
					Thread.sleep(1000);
				} catch (Exception e) { // 잠깐 멈춤 
				}
				for (int i = 0; i< answer.length; i++) {
					for (int j = 0; j<answer.length; j++) {
						la[i][j].setText( null);
					}
				}
	}
	public void actionPerformed(ActionEvent e) {
		// 이벤트 확인 
		JButton obj = (JButton)e.getSource();
		
		for (int i = 0; i< answer.length; i++) {
			for (int j = 0; j<answer.length; j++) {
				
				if(obj == la[i][j] ){
					// 첫번째인지
					
					if(firstClick == null) {
						firstClick = obj;
						firstRow = i;
						firstCol = j;
						firstClick.setBackground(new Color(20,20,240));
						firstClick.setText(String.valueOf(answer[i][j]));
						
					
					}else {// 두번재인지
						if(answer[firstRow][firstCol] == answer[i][j] 
								&& (firstRow !=i && firstCol !=j) ) {
							
							//la[i][j].setText(null);
							
								
							la[i][j].setBackground(new Color(20,20,240));
							
							 JOptionPane.showMessageDialog(null, "딩동댕");
							
						}else {
							firstClick.setText(null);
							firstClick.setBackground(null);
						}firstClick = null; 
					}
				}
			}
		}
	}
}


public class NumberGame {
	public static void  main(String[] args) {
		MyFrame my = new MyFrame();
		my.initChar();
		my.showAnswer();
	}

}