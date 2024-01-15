package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GameStartLogic;
import model.Point;
import model.User;

@WebServlet("/GameStart")
public class GameStart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GameStart() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect("Index");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//リダイレクト先のパスを入れる変数
		String path = null;
		HttpSession session = request.getSession();

		if (session == null) {
			path = "/WEB-INF/jsp/login.jsp";
		}

		User user = (User) session.getAttribute("loginUser");

		int gameId = -1;
		int levelId = -1;
		
		Point point = new Point();
		
		try {

			gameId = Integer.parseInt(request.getParameter("gameId"));
			levelId = Integer.parseInt(request.getParameter("levelId"));

		} catch (Exception e) {

			//存在しない難易度の場合ゲームメニューへ飛ばす
			path = "/WEB-INF/jsp/gamemenu.jsp";
		}

		GameStartLogic gameStartLogic = new GameStartLogic();

		if (!gameStartLogic.checkGameLevel(gameId, levelId)) {
			//存在しない難易度の場合ゲームメニューへ飛ばす
			path = "/WEB-INF/jsp/gamemenu.jsp";
		}

		gameStartLogic.checkEnoughPoint(user, gameId, levelId, point);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

}