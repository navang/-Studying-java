package board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CNull implements Comm{
	private String next;

	public CNull( String _next ){
		next = _next;
	}

	public String execute( HttpServletRequest request, HttpServletResponse response   ) throws CException{
		return next;
	}

}
