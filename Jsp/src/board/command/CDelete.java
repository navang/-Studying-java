package board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDao;
import board.model.BoardException;


public class CDelete implements Comm {
	private String next;

	public CDelete( String _next ){
		next = _next;
	}
	
	public String execute(HttpServletRequest request, HttpServletResponse response  ) throws CException {

		try{
				
			int article_id = Integer.parseInt(request.getParameter("article_id"));
			String password = request.getParameter("password");
			
			int resultCnt = BoardDao.getInstance().delete(article_id, password);
			
			request.setAttribute("rs", resultCnt);
			
		}catch( BoardException ex ){
			throw new CException("CDelete.java < 삭제시 > " + ex.toString() ); 
		}
		
		return next;			
	}

}
