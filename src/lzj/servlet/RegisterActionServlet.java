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
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
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
		String yzm = request.getParameter("yzm");
		String rand = (String) request.getSession().getAttribute("rand");
		if (rand.equals(yzm)) {
			UserDao userdao = new UserDaoImpl();
			int stat = userdao.addUser(new User(0, username, password, null, null, 2, null, null));
			if (stat == 1) {
				response.getWriter().print(
						"<script language='JavaScript'>alert('添加成功');window.location.href='Login.jsp';</script>");
			} else {
				response.getWriter().print(
						"<script language='JavaScript'>alert('用户名重复');window.location.href='Register.jsp';</script>");
			}
		} else {
			response.getWriter().print(
					"<script language='JavaScript'>alert('验证码错误');window.location.href='Register.jsp';</script>");
		}

	}

}
