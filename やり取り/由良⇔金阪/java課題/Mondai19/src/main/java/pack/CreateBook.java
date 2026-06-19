package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//	確認2番目
//	受け取った情報のnull確認して情報そろってればINSERT
/**
 * Servlet implementation class CreateBook
 */
@WebServlet("/CreateBook")
public class CreateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
    	doPost(request, response);	//	doGet変化分
//    	↓のを呼び出してるだけ
	}
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);	//原文これだけ
		
		// 受け取る文字設定
		request.setCharacterEncoding("utf-8");
		// 送る文字設定(html文字;文字コード)
		response.setContentType("text/html;charset=utf-8");
		
		// オブジェクト指定して表示
		String name = request.getParameter("name");
		String favoriteBook = request.getParameter("favoriteBook");
		String detail = request.getParameter("detail");
		ArrayList<String> errMessage = new ArrayList<String>();
//		request()で受け取れる、受けとった後は普通の変数
		
		if (name.isEmpty()) {
			errMessage.add("名前入力をしてください");
		}
		if (favoriteBook.isEmpty()) {
			errMessage.add("お気に入り書籍を入力してください");
		}
		if (detail.isEmpty()) {
			errMessage.add("詳細を入力してください");
		}
//		入力されて無ければエラーメッセージを返すってことかな？
		
		if (name.isEmpty() || favoriteBook.isEmpty() || detail.isEmpty()) {
//			一つでもなければ、動く
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>確認画面</title>");
			for (String errw : errMessage) {
				out.println(errw);
			}
//			bodyの開きはどこ？	無くね？	headの閉まりもないけど？？
			out.println("</body>");
			out.println("</html>");
		} else {
			BookDAO book = new BookDAO();
			book.connect();
//			中にConnect入ってるのに呼ぶ意味とは？
//			try_Catch あるとはいえSQL文でエラー起こしたら何の意味もなくない？
//			てかなおさらstaticしろよと思ったけど
			book.createFavoriteBook(name, favoriteBook, detail);
			response.sendRedirect("/sampleProject/ReadUsers");
//			SQLに直接書き込んでるから返り値は無し、そも戻り値の概念はあるんやろか
		}
//		もしかしなくとも直接HTML書いてるなこれ？
//		responseにWriterで直接書き込んでる感じ
	}

}
