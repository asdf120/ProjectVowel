package mvc.guest.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandNull implements Command{
	private String next;

	public CommandNull( String next ){
		this.next = next;
	}

	public String execute( HttpServletRequest request, HttpServletResponse response   ) throws CommandException{
		return next;
	}

}
