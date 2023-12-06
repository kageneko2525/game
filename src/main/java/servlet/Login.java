package servlet;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;


/**
 * 
 * @author ねこ
 *
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardPath = null;
		HttpSession session = request.getSession();
		if (session == null) {
			session = request.getSession(true);
			forwardPath = "/WEB-INF/jsp/index.jsp";

		} else {
			Object loginCheck = session.getAttribute("loginUser");
			if (loginCheck == null) {
				forwardPath = "/WEB-INF/jsp/login.jsp";

			} else {
				forwardPath = "/WEB-INF/jsp/index.jsp";
			}
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName =request.getParameter("userName");
		String pass = request.getParameter("pass");
		
		HttpSession session = request.getSession();
		
		//エラーメッセージ初期化
		session.setAttribute("errorMessage", null);
		
		if(userName == "" || pass =="") {
			//IDかpassが入力されていないときの処理とエラーメッセージ
			session.setAttribute("errorMessage", "IDまたはパスワードが入力されていません。");
			response.sendRedirect("/esegaGameLand/Login");
		}else {
			//入力された時の処理
			
			//user仮置き
			User user = new User();
			user.setUserName(userName);
			//ハッシュ化処理
			byte[] cipher_byte;
			try {
				MessageDigest md = MessageDigest.getInstance("SHA-256");
				md.update(pass.getBytes());
				cipher_byte = md.digest();
				StringBuffer sb = new StringBuffer(2 * cipher_byte.length);
				for (byte b : cipher_byte) {
					sb.append(String.format("%02x", b & 0xff));
				}
				user.setHash(sb.toString());
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}

			UserDao userdao = new UserDao();
			boolean isLogin = userdao.findByIdAndHash(user);
			if (isLogin) {
				//一致するIDがあるとき
				//ログインする
				session.setAttribute("loginUser", user);
				session.setMaxInactiveInterval(60*10);
				response.sendRedirect("/esegaGameLand/Index");
			} else {
				//しないときはエラーメッセージをつけてloginへ
				session.setAttribute("errorMessage", "存在しないID、またはパスワードが間違っています。");
			    response.sendRedirect("/esegaGameLand/Login");
			}
			
		}
		
		
	}

}
