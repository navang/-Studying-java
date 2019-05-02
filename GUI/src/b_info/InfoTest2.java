package b_info;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class InfoTest2{
   //1. 멤버 변수 선언 (생성자 안에서 선언하나, 멤버 변수로 선언햇기 때문에 메소드 안에서 사용 가능.)
   //객체 생성은 HasA
   JFrame f;
   JTextField tf_name, tf_id, tf_tel, tf_email, tf_sex, tf_age, tf_address;
   JTextArea ta1;
   JButton b_search, b_show, b_add, b_modify, b_delete, b_print, b_exit;
   
   //2. 멤버 객체 생성
   InfoTest2(){
      f = new JFrame("DB Test");
      
      //NullPointerException: 객체 생성 miss
      
      tf_name = new JTextField(15);
      tf_id = new JTextField(15);
      tf_tel = new JTextField(15);
      tf_email = new JTextField(15);
      tf_sex = new JTextField(15);
      tf_age = new JTextField(15);
      tf_address = new JTextField(15);
      
      Border border = BorderFactory.createLineBorder(Color.BLACK);
      
      ta1 = new JTextArea(11, 50);
//      ta1.setSize(2, 50);
      ta1.setBorder(border);
      ta1.setFont(new Font("Verdana", Font.BOLD, 12));

      
      b_search = new JButton("Search");
      b_show = new JButton("Show");
      b_add = new JButton("Add");
      b_modify = new JButton("Modify");
      b_delete = new JButton("Delete");
      b_print = new JButton("Print");
      b_exit = new JButton("Exit");
   }
   
   //3. 화면 붙이기 및 화면 출력
   void addLayout() {
      f.setLayout(new BorderLayout());
      
      //패널의 기본 형은 FlowLayout
      JPanel tf_p1 = new JPanel();
      //패널 레이 아웃 형은 GridLayout 형으로 변경.
      tf_p1.setLayout(new GridLayout(7, 2));
      tf_p1.add(new JLabel("Name"));
      tf_p1.add(tf_name);
      tf_p1.add(new JLabel("Id"));
      tf_p1.add(tf_id);
      tf_p1.add(new JLabel("Tel"));
      tf_p1.add(tf_tel);
      tf_p1.add(new JLabel("E_mail"));
      tf_p1.add(tf_email);
      tf_p1.add(new JLabel("성별"));
      tf_p1.add(tf_sex);
      tf_p1.add(new JLabel("나이"));
      tf_p1.add(tf_age);
      tf_p1.add(new JLabel("주소"));
      tf_p1.add(tf_address);
      f.add(tf_p1, BorderLayout.WEST);
      
      f.add(ta1, BorderLayout.CENTER);
      
      JPanel b_p1 = new JPanel();
      b_p1.setLayout(new GridLayout(1, 7));
      b_p1.add(b_search);
      b_p1.add(b_show);
      b_p1.add(b_add);
      b_p1.add(b_modify);
      b_p1.add(b_delete);
      b_p1.add(b_print);
      b_p1.add(b_exit);
      f.add(b_p1, BorderLayout.SOUTH);
      
      //4. 화면에 출력 
      f.setSize(700, 500);
      f.setVisible(true);
      
      //화면 닫고 프로세스 CLOSE 하겠다.
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }//end of addLayout()
   
   void eventConnec(){
      //MouseListener를 상속받은 MyHandler 클래스 객체 생성 >>> 메모리 상 업로드
      MyHandler event1 = new MyHandler();
      //b_exit 버튼과 이벤트 연결
      b_exit.addMouseListener(event1);
   }
   
   //메소드가 두 개 이상인 경우, 필요없는 MouseListener 자체를 implements 하지 말고
//   class MyHandler implements MouseListener{
   
   //하기와 같이 MouseListener를 implements 하여 중간에 만들어진 MouseAdapter 를 상속하면
   //하나의 메소드 오버라이딩 해도 됨.
   
   //그럼에도 불구하고 왜 interface를 구현(implements) 하는 방법을 지향하나?
   
   //인터페이스를 구현하는 경우에는, 무조건 동일 메소드를 오버라이딩 하지 않으면 에러가 나지만
   //중간 클래스를 상속받은 경우에는, 메소드 상속시 오타를 발견할 확률이 매우 적다.
   
   //따라서 지향하는 코딩 순서는
   //1. 중간 implements 클래스가 존재하는 지 확인.
   //2. interface를 구현(implements) 한다.
   //3. 그 후 중간 implements 클래스를 extends(상속).
   
   class MyHandler extends MouseAdapter{
      @Override
      public void mouseClicked(MouseEvent e) {
         Object obj1 = e.getSource();
         if(obj1 == b_exit) {
            System.exit(0);
         }
      }
   }
   
   //interface를 implements한 클래스를 
   class IdFocus extends FocusAdapter{
      
   }
   
   public static void main(String[] args) {
	   InfoTest2 frame = new InfoTest2();
      frame.addLayout();
      frame.eventConnec();
   }
}
   
