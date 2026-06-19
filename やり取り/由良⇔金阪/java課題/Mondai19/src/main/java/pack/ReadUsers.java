package pack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//	確認4番目
//	戻り値っぽいのがあった。基本はSELECT(name id)
/**
 * Servlet implementation class ReadUsers
 */
@WebServlet("/ReadUsers")
public class ReadUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		原文これだけ
		
		// 受け取る文字設定
		request.setCharacterEncoding("utf-8");
		// 送る文字設定(html文字;文字コード)
		response.setContentType("text/html;charset=utf-8");
		
		BookDAO book = new BookDAO();
		book.connect();
		
		request.setAttribute("bookList", book.readUsers());
//		ここでSQL情報受け取ってsetしてる(name idだけ)	全部入れりゃいいのに
		//JSPにフォワード
		RequestDispatcher rd = request.getRequestDispatcher("/view/index.jsp");
		rd.forward(request, response);
//		見た感じこれが戻り値っぽくなあい？	結果：分かったら書く
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
