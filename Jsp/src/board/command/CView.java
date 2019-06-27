package board.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDao;
import board.model.BoardException;
import board.model.BoardRec;

public class CView implements Comm 
{
	private String next;

	public CView( String _next ){
		next = _next;
	}

	public String execute( HttpServletRequest request , HttpServletResponse response  ) throws CException{
		try{
			int article_id = Integer.parseInt(request.getParameter("article_id"));
				BoardDao dao = BoardDao.getInstance(); // Dao객체 생성
				dao.increaseReadCount(article_id);		
				BoardRec rec = dao.selectById(article_id);		// dao에서 selectById(id에따른 모든 인자값을구함)함수를 이용하여 
				 request.setAttribute("selectbyId", rec );
				 
		}catch( BoardException ex ){
			throw new CException("CView.java < 목록보기시 > " + ex.toString() ); 
		}
		
		return next;
	}
}