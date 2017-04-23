package lzj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lzj.DAO.RememberMeDao;
import lzj.DaoImpl.RememberMeDaoImpl;
import lzj.entity.RememberMe;

/**
 * Servlet implementation class DelLoginServlet
 */
@WebServlet("/DelLogin")
public class DelLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DelLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate();
		int uid = 0;
		String md5 = "";
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("myshopuid")) {
				uid = Integer.valueOf(cookies[i].getValue());
			}
			if (cookies[i].getName().equals("myshopmd5")) {
				md5 = cookies[i].getValue();
			}
		}
		if (uid != 0 && !md5.equals("")) {
			RememberMeDao rememberMeDao = new RememberMeDaoImpl();
			RememberMe rememberMe = new RememberMe(uid, "", "");
			rememberMeDao.delRemeberMe(rememberMe);
		}
		response.sendRedirect("ShopIndex.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
