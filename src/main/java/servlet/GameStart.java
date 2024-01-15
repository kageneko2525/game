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
import model.UsePoint;
import model.User;

//初期化どこ　

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
		boolean keepFlg = true;
		if (session == null) {
			path = "/WEB-INF/jsp/login.jsp";
			keepFlg = false;
		}
		System.out.println(keepFlg);
		User user = (User) session.getAttribute("loginUser");
		if (user == null) {
			session.setAttribute("loginError", "ログインしてください。");
			path = "/WEB-INF/jsp/login.jsp";
			keepFlg = false;
		}
		int gameId = -1;
		int levelId = -1;

		UsePoint usePoint = new UsePoint();

		Point point = new Point();

		//エラーメッセージ初期化
		session.setAttribute("gameStartError", "");
		try {

			gameId = Integer.parseInt(request.getParameter("gameId"));
			levelId = Integer.parseInt(request.getParameter("levelId"));

			usePoint.setGameId(gameId);
			usePoint.setLevelId(levelId);

		} catch (Exception e) {
			if (keepFlg) {
				//存在しない難易度やIDの場合ゲームメニューへ飛ばす
				path = "/WEB-INF/jsp/gamemenu.jsp";

				session.setAttribute("gameStartError", "ゲームが見つかりません。");

				keepFlg = false;
			}

		}

		GameStartLogic gameStartLogic = new GameStartLogic();
		System.out.println(keepFlg);
		if (keepFlg && !gameStartLogic.checkGameLevel(gameId, levelId)) {
			//存在しない難易度の場合ゲームメニューへ飛ばす
			path = "/WEB-INF/jsp/gamemenu.jsp";
			keepFlg = false;
			session.setAttribute("gameStartError", "存在しない難易度です。");

		}

		System.out.println(keepFlg);
		if (keepFlg && !gameStartLogic.checkEnoughPoint(user, usePoint, point)) {

			//ポイントが足りない場合ゲームメニューへ飛ばす
			path = "/WEB-INF/jsp/gamemenu.jsp";
			session.setAttribute("gameStartError", "ポイントが足りません。");
			keepFlg = false;
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

}
