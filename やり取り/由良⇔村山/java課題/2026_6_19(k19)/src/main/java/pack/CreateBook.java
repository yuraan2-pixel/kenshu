package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateBook
 */
@WebServlet("/CreateBook")
public class CreateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateBook() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 受け取る文字設定
		request.setCharacterEncoding("utf-8");
		// 送る文字設定(html文字;文字コード)
		response.setContentType("text/html;charset=utf-8");

		// オブジェクト指定して表示
		String name = request.getParameter("name");
		String favoriteBook = request.getParameter("favoriteBook");
		String detail = request.getParameter("detail");
		ArrayList<String> errMessage = new ArrayList<String>();
		if (name.isEmpty()) {
			errMessage.add("名前入力をしてください");
		}
		if (favoriteBook.isEmpty()) {
			errMessage.add("お気に入り書籍を入力してください");
		}
		if (detail.isEmpty()) {
			errMessage.add("詳細を入力してください");
		}

		if (name.isEmpty() || favoriteBook.isEmpty() || detail.isEmpty()) {
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>確認画面</title>");
			for (String errw : errMessage) {
				out.println(errw);
			}
			out.println("</body>");
			out.println("</html>");
		} else {
			BookDAO book = new BookDAO();
			book.connect();
			book.createFavoriteBook(name, favoriteBook, detail);
			response.sendRedirect("/sampleProject/ReadUsers");
		}
	}

}
