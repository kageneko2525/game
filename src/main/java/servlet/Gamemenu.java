package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Gamemenu")
public class Gamemenu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Gamemenu() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//リダイレクト先のパスを入れる変数
		HttpSession session = request.getSession();

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gamemenu.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//遷移先のサーブレットを指定
		response.sendRedirect("Index");
	}

}
