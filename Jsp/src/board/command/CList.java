package board.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDao;
import board.model.BoardException;
import board.model.BoardRec;

public class CList implements Comm 
{
	private String next;

	public CList( String _next ){
		next = _next;
	}

	public String execute( HttpServletRequest request , HttpServletResponse response  ) throws CException{
		try{
			
		    List <BoardRec> mList = BoardDao.getInstance().selectList();	
		    request.setAttribute("param", mList );

		}catch( BoardException ex ){
			throw new CException("CList.java < 목록보기시 > " + ex.toString() ); 
		}
		
		return next;
	}
}
