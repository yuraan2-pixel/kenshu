package pack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowBookDetail
 */
@WebServlet("/ShowBookDetail")
public class ShowBookDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowBookDetail() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 受け取る文字設定
		request.setCharacterEncoding("utf-8");
		// 送る文字設定(html文字;文字コード)
		response.setContentType("text/html;charset=utf-8");

		String URL = "jdbc:oracle:thin:system/pass@//localhost:1521/kenshu";
		String USER = "System";
		String PASS =  "pass";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, USER, PASS);
			pstmt = con.prepareStatement("select * from users where id = ?");
			int userId = Integer.parseInt(request.getParameter("id"));
			pstmt.setInt(1, userId);

			rs = pstmt.executeQuery();
			List<User> bookList = new ArrayList<User>();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setFavoriteBook(rs.getString("favorite_book"));
				user.setDetail(rs.getString("detail"));
				bookList.add(user);
			}

			request.setAttribute("bookList", bookList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//JSPにフォワード
		RequestDispatcher rd = request.getRequestDispatcher("/view/favoriteBook.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

