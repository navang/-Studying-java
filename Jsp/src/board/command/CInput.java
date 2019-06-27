package board.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDao;
import board.model.BoardException;
import board.model.BoardRec;



public class CInput implements Comm {
	private String next;

	public CInput( String _next ){
		next = _next;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response  ) throws CException {
		try{
			// 넘겨주는 인자들 이름은 BoardRec.java 으로 부터 
			BoardRec msg = new BoardRec();
			msg.setWriterName( request.getParameter("writerName"));
			msg.setPassword(request.getParameter("password"));
			msg.setContent( request.getParameter("Content"));
			
			BoardDao dao= BoardDao.getInstance();
			dao.insert(msg);
			//====================================
			
			List <BoardRec> mList= dao.selectList();
			request.setAttribute("input", mList);
			
		}catch( BoardException ex ){
			throw new CException("CInput.java < 입력시 > " + ex.toString() ); 
		}
		return next;
	}

}
