package e_combobox;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalendarEx {

	//1 멤버변수선언
	JFrame f;
	JComboBox cbY, cbM , cbD;
	JButton b ;
	JLabel la;

	int [] lastDays = { 31, 28, 31, 30, 31, 30, 31, 31,
			30, 31, 30, 31};

	//2 멤버변수 객체생성
	CalendarEx() {	

		f = new JFrame("콤보박스예제");
		Integer[] y = new Integer[11];
		for(int i=0, year=2015; i<y.length; i++, year++) {
			y[i]=year;
		}
		cbY = new JComboBox(y);

		Integer[] m = new Integer[12];
		for(int i=0; i<m.length; i++) {
			m[i]=i+1;
		}
		cbM = new JComboBox(m);
		
		
		
		cbD = new JComboBox();

		b = new JButton("▽");
		la = new JLabel("요일");
	}
	
	//3. 화면 붙이기및 화면보이기 
	void addLayout() {
		//f.setLayout(new BorderLayout());
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());

		p1.add(cbY);
		p1.add(new JLabel("년"));
		p1.add(cbM);
		p1.add(new JLabel("월"));
		p1.add(cbD);
		p1.add(new JLabel("일"));
		p1.add(b);
		p1.add(la);

		f.add(p1);
		f.setSize(400,200);
		f.setVisible(true);
		
		
	}	
	
	void initDate () {
		Calendar c = Calendar.getInstance();
		int y= c.get(Calendar.YEAR);
		cbY.setSelectedItem(y);
		int m= c.get(Calendar.MONTH)+1;
		cbM.setSelectedItem(m);
		
		setDay();		// 년월일
		int d= c.get(Calendar.DATE);
		cbD.setSelectedItem(d);
		
		setDate();		// 요일 
		
	}
	// 4. 이벤트 등록및 처리 
	void eventProc() {
		CbHdlr cb= new CbHdlr();
		cbY.addActionListener(cb);
		cbM.addActionListener(cb);
		b.addActionListener(cb);
	}
	class CbHdlr implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Object obj =e.getSource();
			if( obj ==cbY | obj == cbM) {setDay();
			}else if(obj == b) setDate();
		}
	}
	
	
	void setDay() {
	
		int year = (Integer)cbY.getSelectedItem();
		if(year%4 == 0 && year%100!=100 || year/400 == 0 ) {
			lastDays[1] = 29;
		}else {
			lastDays[2] = 28;
		}
		// 윤년이라면  lastDays[1] = 29
		// 평년이라면 lastDays[2] = 28 
		int month =cbM.getSelectedIndex();
		cbD.removeAllItems();
		for(int i=1; i<=lastDays[month]; i++) {
			cbD.addItem(i);
		}
	}
	public void setDate() {
		int y = (Integer)cbY.getSelectedItem(); 
		int m = (Integer)cbM.getSelectedItem(); 
		int d = (Integer)cbD.getSelectedItem();
		
		Calendar c = Calendar.getInstance();
		c.set(y,m-1,d);
		int date= c.get(Calendar.DAY_OF_WEEK);
		String [] strDate = {"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};
		la.setText(strDate[date-1]);
	//System.out.println("버튼이벤트");
		
		
	}
	public static void main(String[] args) {
		CalendarEx c =new CalendarEx();
		c.addLayout();  // 화면 붙이기및 구성
		c.eventProc();  // 날짜 초기화
		c.initDate();  // 이벤트 처리 
	}

}
