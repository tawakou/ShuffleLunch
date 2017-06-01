package servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * テンプレートをするクラス。
 * @author r_takada
 */
@WebServlet("/ComfirmServlet")
public class ComfirmServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "/WEB-INF/jsp/comfirm.jsp";




		request.getRequestDispatcher(url).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url="/WEB-INF/jsp/comfirm.jsp";

		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		request.setAttribute("name",name);
		request.setAttribute("pass",pass);


		request.getRequestDispatcher(url).forward(request, response);

	}


}