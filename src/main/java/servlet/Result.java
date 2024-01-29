package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GamePointDao;
import dao.PointDao;
import model.GamePoint;
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

				//ログインしてなかったらIndexへ
				forwardPath = "/WEB-INF/jsp/index.jsp";

			} else {

				//していたらリザルトへ
				forwardPath = "/WEB-INF/jsp/result.jsp";

			}

			//送られてきた獲得ポイント用
			String scoreSt = request.getParameter("score");

			//数字に直して入れるよう
			int score = 0;

			try {

				//トライキャッチを使って数字に変換できるかチェック
				score = Integer.parseInt(scoreSt);

				//現在ポイントをセッションスコープから取得
				Point point = (Point) session.getAttribute("point");

				//ポイントDAO作成
				PointDao pointDao = new PointDao();

				//獲得ポイントを反映させる
				pointDao.updatePoint(point, score);

				//繁栄後のポイントをセッションスコープに保存
				session.setAttribute("point", point);

				//リザルトに表示用の獲得ポイントをリクエストスコープに保全
				//一度使うだけなのでリクエストスコープ
				request.setAttribute("getPoint", score);

				//ここにゲームの最大ポイントを更新するプログラムを記述

				GamePoint gamePoint = new GamePoint();
				GamePointDao gamePointDao = new GamePointDao();

				int gameId = (Integer)session.getAttribute("gameId");
				int levelId = (Integer) session.getAttribute("levelId");

				System.out.println(gameId);
				System.out.println(levelId);

				gamePoint.setUserId(point.getUserId());
				gamePoint.setGameId(gameId);
				gamePoint.setLevelId(levelId);
				gamePoint.setMaxGamePoint(score);

				if (!gamePointDao.findSelectGamePoint(gamePoint)) {
					gamePointDao.setGamePoint(gamePoint);
					System.out.println("成功");
				} else {
					System.out.println("失敗");
				}
				if(score>gamePoint.getMaxGamePoint()) {
					
					gamePointDao.updatePoint(gamePoint);
				}
				//具体的な手順
				//DAO　Logicの作成
				//GAmeid levelId　userIdごとに一列
				//DAOを使ってそもそも初プレイの場合はデータをインサート
				//二回目以降の場合はデータを比較して大きかったら更新
				//初プレイかどうかはDAOでデータあるかどうか調べる
				//データがない場合はNULLで返すなどをしてロジック側でわかるように
				//User情報はセッションスコープにあるので引っ張ってきてください

			} catch (Exception e) {
				e.printStackTrace();
				//キャッチされたら不正な値なので後で垢BANつくりたい

			}

		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

}
