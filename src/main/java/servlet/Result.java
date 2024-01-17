package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PointDao;
import model.Point;

@WebServlet("/Result")
public class Result extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Result() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//パスを入れる変数宣言
		//ポスト前提なのでゲットは無条件でindexへ
		String path = "Index";



		//　ページ遷移
		response.sendRedirect(path);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//フォワード先のパスを入れる変数宣言
		String forwardPath = "/WEB-INF/jsp/index.jsp";
		
		//セッションの獲得
		HttpSession session = request.getSession();
		if (session == null) {
			
			//セッションがなかったらセッションを開始し、indexへ
			session = request.getSession(true);
			forwardPath = "/WEB-INF/jsp/index.jsp";
		
		} else {

			//セッションがあったらログインしているかのチェック
			Object loginCheck = session.getAttribute("loginUser");
			if (loginCheck == null) {
				forwardPath = "/WEB-INF/jsp/index.jsp";

			} else {
				
				forwardPath = "/WEB-INF/jsp/result.jsp";

			}

			String scoreSt = request.getParameter("score");

			int score = 0;

			try {
				score = Integer.parseInt(scoreSt) * 10;
			} catch (Exception e) {

				//不正な値きたこれ

			}
			Point point = (Point) session.getAttribute("point");

			PointDao pointDao = new PointDao();
			pointDao.updatePoint(point, score);

			session.setAttribute("point", point);

			request.setAttribute("getPoint", score);

		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

}
