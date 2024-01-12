package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Explanation")
public class Explanation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Explanation() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//リダイレクト先のパスを入れる変数
		String path = "/WEB-INF/jsp/explanation/ex";
		HttpSession session = request.getSession();

		String gamePath = request.getParameter("game");

		path = path + gamePath+".jsp";
		System.out.println(path);
		System.out.println("/WEB-INF/jsp/explanation/exForlook.jsp");
		System.out.println(path.equals("/WEB-INF/jsp/explanation/exForlook.jsp"));
//		path = "/WEB-INF/jsp/explanation/exForlook.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//遷移先のサーブレットを指定
		response.sendRedirect("Index");
	}

}
