package pack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//	確認5番目
//	メソッド使えよと思ったのが大きすぐる	もやもやする
//	してることはほぼshowuser	なおさらメソッド使えよ
//	おれはおまえがきらいだ
/**
 * Servlet implementation class ShowBookDetail
 */
@WebServlet("/ShowBookDetail")
public class ShowBookDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBookDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// 受け取る文字設定
		request.setCharacterEncoding("utf-8");
		// 送る文字設定(html文字;文字コード)
		response.setContentType("text/html;charset=utf-8");
//		ここ定型文ポイ	全員継承はしてるしそのクラスにこれ置いとけないかな？
		
		int userId = Integer.parseInt(request.getParameter("id"));
		List<User> bookList = new ArrayList<User>();
		BookDAO book = new BookDAO("");
		
		bookList.add(book.showBookDetail(userId, book.con()));
		/*
		String URL = "jdbc:oracle:thin:@localhost:1521/kenshu";
		String USER = "system";
		String PASS = "pass";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, USER, PASS);
//			なおさらConnect使えや、なんか意味感じねぇんですがぁ！？文言全く同じやんけ！
			pstmt = con.prepareStatement("select * from users where id = ?");
//			？？？？？？？？？メソッド使おうや、これそのままのやつあるやん何のために作ったんよ
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
//				もしかしてこれだけの為に追加してらっしゃる？
//				んなもん後から追加せぇよ！
			}
			
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
//		*/
		request.setAttribute("bookList", bookList);
//			直接Listをセットできてる！？便利ねぇ	これセットしてるやつが返されてるかも
		
		//JSPにフォワード
		RequestDispatcher rd = request.getRequestDispatcher("/view/favoriteBook.jsp");
		rd.forward(request, response);
//		フォワードってのが戻り値のことな感じするねぇ	違うかもけど
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
//		今更けどどっち呼び出しても同じ動きせんか？これ
	}

}
