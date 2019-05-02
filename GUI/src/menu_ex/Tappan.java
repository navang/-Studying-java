package menu_ex;

import java.awt.*;
import javax.swing.*;
public class Tappan extends JFrame 
{
	Tang	tang;
	Anju	anju;
	Drink	drink;

	public Tappan(){
		//각각의 화면을 관리하는 클래스 객체 생성
			tang = new Tang();
			anju	= new Anju();
			drink	= new Drink();

			JTabbedPane  pane = new JTabbedPane();
			pane.addTab("탕", tang );
			pane.addTab("안주", anju);
			pane.addTab("음료", drink );

			pane.setSelectedIndex(2);

			add("Center", pane );
			setSize(1920,1080);
			setVisible( true );

		//	setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );	
	}
	
}
