package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Result")
public class Result extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Result() {
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
				forwardPath = "/WEB-INF/jsp/result.jsp";

			} else {
				forwardPath = "/WEB-INF/jsp/index.jsp";
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}