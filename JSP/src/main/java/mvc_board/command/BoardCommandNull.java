package mvc_board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardCommandNull implements BoardCommand{
	private String next;

	public BoardCommandNull(String next ){
		this.next = next;
	}

	public String execute( HttpServletRequest request, HttpServletResponse response   ) throws BoardCommandException{
		return next;
	}

}
