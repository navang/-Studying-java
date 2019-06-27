package guest.simple;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class simpleControl extends HttpServlet {
   private static final long serialVersionUID = 1L;

   String jspDir = "/05_mvc_class/1_mvcSimple/";
   
    public simpleControl() {
        super();
 
    }

    
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      processRequest(request, response);
   }

   


   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      processRequest(request, response);
   }
   
   
   protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //이전화면에서 넘겨받는 값을 얻어올 때 : request.getParameter()
      //request에 데이터 저장할 때 : request.setAttribute("name", value)
      //request에서 데이터를 얻어올 때 : request.getAttribute("name")
      String type = request.getParameter("type");
      String value = "오늘도 화이팅";
      if(type!=null) value="우리조단합";
      
      request.setAttribute("param", value);   //데이터 저장 session과 같은 개념
      
      //forwarding  === <jsp:forward page ="파일경로">를 java코드로 변환한 것
      RequestDispatcher dispatcher = request.getRequestDispatcher(jspDir+"simpleView.jsp"); 
      dispatcher.forward(request, response);
   }

}
