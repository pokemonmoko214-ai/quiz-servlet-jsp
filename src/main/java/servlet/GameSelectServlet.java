package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/GameSelectServlet")

public class GameSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//------ doGet ------
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//リクエストパラメータ を取得する
		String action = request.getParameter("action");

		if (action == null) {
			//index.jspに飛ぶ
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		} else if (action.equals("select")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);

			//game.jspに飛ぶ
		}	else if(action.equals("game")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/game.jsp");
			dispatcher.forward(request, response);
		}	

	}

}
