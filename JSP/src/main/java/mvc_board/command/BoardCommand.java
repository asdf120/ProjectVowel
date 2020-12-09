package mvc_board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BoardCommand {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws BoardCommandException;
}
