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
import model.RegistrationLogic;
import model.User;

@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Registration() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//リダイレクト先のパスを入れる変数
		String path = null;
		HttpSession session = request.getSession();


		path = "/WEB-INF/jsp/registration.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		//リダイレクト先のパスを入れる変数
		String path = null;
		HttpSession session = request.getSession();

		request.setCharacterEncoding("UTF-8");

		
		String registrationName = request.getParameter("registrationName");
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");
		String samePass = request.getParameter("samePass");

		User registrationUser = new User();
		Point point = new Point();
		PointDao pointDao = new PointDao();
		
		
		pointDao.getPoint(point);
		
		
		//エラーメッセージ初期化
		session.setAttribute("registrationErrorr", "");
		

		RegistrationLogic registrationLogic = new RegistrationLogic();

		String registrarionError = registrationLogic.chackRegistration(registrationName, mail,pass, samePass ,registrationUser);
		
		if(registrarionError == null ||registrarionError.isEmpty()) {
			//エラーメッセージがないなら登録成功
			//indexへ
			point.setUserId(registrationUser.getUserId());
			pointDao.getPoint(point);
			System.out.println(point);
			System.out.println(point.getPoint());
			System.out.println(point.getSumPoint());
			System.out.println(point.getUserId());
			session.setAttribute("point", point);
			session.setAttribute("loginUser", registrationUser);
			path ="Index";
			session.setMaxInactiveInterval(60*10);
		}else {
			//エラーメッセージがあるならエラーメッセージを設定し登録画面へ
			
			session.setAttribute("registrationError", registrarionError);
			path="Registration";
		}
		
		//遷移先のサーブレットを指定
		
		response.sendRedirect(path);
	}

}
