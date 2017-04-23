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
 * Servlet implementation class EditUserServlet
 */
@WebServlet("/EditUser")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditUserServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int uid = Integer.valueOf(request.getParameter("uid"));
		UserDao userDao = new UserDaoImpl();
		String password = request.getParameter("pwd");
		User user = userDao.findUserByUid(uid).get(0);
		user.setPassword(password);
		userDao.updateUser(user);
		response.sendRedirect("UserManager.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
