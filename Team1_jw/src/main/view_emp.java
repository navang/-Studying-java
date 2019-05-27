package main;

import java.awt.*;
import javax.swing.*;

import view.Cinemaview_emp;
import view.Snackview_emp;
public class view_emp extends JFrame 
{
	Cinemaview_emp	Cinemaview_emp;
	Snackview_emp	Snackview_emp;


	public view_emp(){
		//각각의 화면을 관리하는 클래스 객체 생성
		Cinemaview_emp = new Cinemaview_emp();
		Snackview_emp = new Snackview_emp();

		JTabbedPane  pane = new JTabbedPane();
		pane.addTab("직원-좌석보기", Cinemaview_emp );
		pane.addTab("직원-매점보기", Snackview_emp );

		pane.setSelectedIndex(1);

		add("Center", pane );
		setSize(1440,720);
		setVisible( true );

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );	
	}
	public static void main(String[] args) 
	{
		new view_emp();
	}
}

