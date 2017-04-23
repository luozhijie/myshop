package lzj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lzj.DAO.UserDao;
import lzj.DaoImpl.UserDaoImpl;
import lzj.entity.User;

/**
 * Servlet implementation class RegisterActionServlet
 */
@WebServlet("/RegisterAction")
public class RegisterActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterActionServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		String username = request.getParameter("username");
		String password = request.getParameter("pwd");

		UserDao userdao = new UserDaoImpl();
		int stat = userdao.addUser(new User(0, username, password, null, null, 2, null, null));
		if (stat == 1) {
			System.out.println("添加成功");
		} else {
			System.out.println("添加失败");
		}
	}

}
