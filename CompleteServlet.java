package servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Person;
import dao.PersonDAO;
import ds.ConnectionManager;



/**
 * テンプレートをするクラス。
 * @author r_takada
 */
@WebServlet("/CompleteServlet")
public class CompleteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "/WEB-INF/jsp/main.jsp";

		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		PersonDAO pdao = new PersonDAO(conn);
		HttpSession se = request.getSession();
		Person p = (Person) se.getAttribute("p");
		try {
		int ok = pdao.regi(p.getName(), p.getPass());
		System.out.println(ok);
		if(ok!=1){
			url = "/WEB-INF/jsp/regi.jsp";
		}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


		request.getRequestDispatcher(url).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url="/WEB-INF/jsp/main.jsp";

		String name = request.getParameter("name");
		String pass = request.getParameter("pass");



		request.getRequestDispatcher(url).forward(request, response);

	}


}