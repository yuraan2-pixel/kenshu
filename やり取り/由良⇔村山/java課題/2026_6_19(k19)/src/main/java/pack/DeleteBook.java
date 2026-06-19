package pack;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteBook")
public class DeleteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteBook() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ó‚¯æ‚é•¶šİ’è
		request.setCharacterEncoding("utf-8");
		// ‘—‚é•¶šİ’è(html•¶š;•¶šƒR[ƒh)
		response.setContentType("text/html;charset=utf-8");

		BookDAO book = new BookDAO();
		book.connect();
		book.deleteUser(Integer.parseInt(request.getParameter("id")));

		response.sendRedirect("/sampleProject/ReadUsers");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
