package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		//エラーメッセージ初期化
		session.setAttribute("registrarionError", "");
		path = "/WEB-INF/jsp/registration.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//リダイレクト先のパスを入れる変数
		String path = null;
		HttpSession session = request.getSession();

		String registrartionName = request.getParameter("registrationName");
		String pass = request.getParameter("pass");
		String samePass = request.getParameter("samePass");

		User registrationUser = new User();
		
		//エラーメッセージ初期化
		session.setAttribute("registrarionError", "");
		

		RegistrationLogic registrationLogic = new RegistrationLogic();

		String registrarionError = registrationLogic.chackRegistration(registrartionName, pass, samePass ,registrationUser);

		if(registrarionError == null ||registrarionError.isEmpty()) {
			//エラーメッセージがないなら登録成功
			//indexへ
			session.setAttribute("loginUser", registrationUser);
			path ="Index";
		}else {
			//エラーメッセージがあるならエラーメッセージを設定し登録画面へ
			
			session.setAttribute("registrarionError", registrarionError);
			path="Registration";
		}
		
		//遷移先のサーブレットを指定
		response.sendRedirect(path);
	}

}
