package board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Comm {
	public String execute( HttpServletRequest request, HttpServletResponse response  ) throws CException;
}
