package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GamePointDao;
import model.GamePoint;

@WebServlet("/Ranking")
public class Ranking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Ranking() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リダイレクト先のパスを入れる変数
		String path = null;
		HttpSession session = request.getSession();
		path="/WEB-INF/jsp/ranking.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		String gameIdSt =request.getParameter("gameId");
		
		try {
			int gameId = Integer.parseInt(gameIdSt);
			
			GamePointDao gamePointDao = new GamePointDao();
			ArrayList<GamePoint> gamePointList = gamePointDao.getSelectGamePoint(gameId);
			
			String jsonData = convertListToJsonArray(gamePointList);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		

	}
	
    // リストをJSON形式の配列に変換するメソッド
    private String convertListToJsonArray(ArrayList<GamePoint> list) {
        StringBuilder jsonArray = new StringBuilder("[");
        for (GamePoint gamePoint : list) {
            jsonArray.append("{ \"userName\": \"").append(gamePoint.getUserId()).append("\", ")
                    .append("\"point\": \"").append(gamePoint.getUserName()).append(" }, ");
        }
        if (list.size() > 0) {
            jsonArray.delete(jsonArray.length() - 2, jsonArray.length());
        }
        jsonArray.append("]");
        return jsonArray.toString();
    }

}
