package board.control;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.command.CDelete;
import board.command.CException;
import board.command.CInput;
import board.command.CList;
import board.command.CNull;
import board.command.CReply;
import board.command.CView;
import board.command.Comm;
/**
 * Servlet implementation class BoardControl
 */
public class BoardControl extends HttpServlet {
	
	private HashMap cMap;
	private String	jspDir ="/00_board_class/";
	private String  error = "error.jsp";
	

    public BoardControl() {
        super();       
		initCommand();
	}

	private void initCommand(){
		cMap = new HashMap();

		cMap.put("bmain-page",	new CNull("Board_mvc.jsp") );
		cMap.put("blist-page",	new CList("BoardList_mvc.jsp") );
		// 나머지도 추가하기	
		// input
		cMap.put("binput-page", new CNull("BoardInputForm_mvc.jsp"));
		cMap.put("binput-do", new CInput("BoardSave_mvc.jsp"));
		//delete
		cMap.put("bdeleteform-page", new CNull("BoardDeleteForm_mvc.jsp"));
		cMap.put("bdelete-page", new CDelete("BoardDelete_mvc.jsp"));
		cMap.put("bdelete-do", new CDelete("BoardDelete_mvc.jsp"));
		//view
		cMap.put("bview-do", new CView("BoardView_mvc.jsp"));
		//reply
		cMap.put("breply-page", new CNull("BoardReplyForm_mvc.jsp"));
		cMap.put("breply-do", new CReply("BoardReply_mvc.jsp"));
		//update
//		cMap.put("bupdate-page", new CNull("BoardUpdateForm_mvc.jsp"));
//		cMap.put("bupdate-do", new CUpdate("BoardUpdate_mvc.jsp"));
		
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String nextPage = "";
		String cmdKey	= request.getParameter("cmd");
		if( cmdKey == null ){
			cmdKey = "main-page";
		}

		
		Comm cmd = null;

		try{
			
			if( cMap.containsKey( cmdKey ) ){
				cmd = (Comm)cMap.get( cmdKey);
			}else{
				throw new CException("지정할 명령어가 존재하지 않음");
			}

			nextPage = cmd.execute( request, response  );

		}catch( CException e ){
			request.setAttribute("javax.servlet.jsp.jspException", e );
			nextPage = error;
			System.out.println("오류 : " + e.getMessage() );
		}

		RequestDispatcher reqDp = getServletContext().getRequestDispatcher( jspDir + nextPage );
		reqDp.forward( request, response );
		
	}

}
