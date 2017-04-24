package lzj.servlet;

import java.io.IOException;
import java.io.Writer;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lzj.DAO.RememberMeDao;
import lzj.DAO.UserDao;
import lzj.DaoImpl.RememberMeDaoImpl;
import lzj.DaoImpl.UserDaoImpl;
import lzj.entity.RememberMe;
import lzj.entity.User;
import lzj.tools.GetIpAdderss;
import lzj.tools.Md5Tools;

/**
 * Servlet implementation class LoginActionServlet
 */
@WebServlet("/LoginAction")
public class LoginActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginActionServlet() {
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
		String rand = (String) request.getSession().getAttribute("rand");
		String input = (String) request.getParameter("yzm");
		if (rand.equals(input)) {
		} else {
			System.out.println("yzmcw");
			response.getWriter()
					.print("<script language='JavaScript'>alert('验证码错误');window.location.href='Login.jsp';</script>");
		}
		UserDao userdao = new UserDaoImpl();
		RememberMeDao rememberMeDao = new RememberMeDaoImpl();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String[] rember = request.getParameterValues("remeberme");
		User user = userdao.findUserByUserNameAndPassword(username, password);
		if (user != null) {
			if (rember != null) {
				try {
					Cookie cookie = new Cookie("myshopmd5", Md5Tools.EncoderByMd5(Math.random() + "pwd"));
					cookie.setMaxAge(60 * 60 * 24 * 15);
					response.addCookie(cookie);
					Cookie cookie2 = new Cookie("myshopuid", user.getUid() + "");
					cookie2.setMaxAge(60 * 60 * 24 * 15);
					response.addCookie(cookie2);
					if (rememberMeDao.findRemeberMeByUid(user.getUid()) == null) {
						rememberMeDao.addRemeberMe(
								new RememberMe(user.getUid(), cookie.getValue(), GetIpAdderss.getIpAddr(request)));
					} else {
						rememberMeDao.updateRemeberMe(
								new RememberMe(user.getUid(), cookie.getValue(), GetIpAdderss.getIpAddr(request)));
					}
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
			}
			request.getSession().setAttribute("user", user);
			response.sendRedirect("ShopIndex.jsp");
		} else {
			response.getWriter().print(
					"<script language='JavaScript'>alert('用户名或密码错误');window.location.href='Login.jsp';</script>");
		}
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("myshopuid")) {
				System.out.println(cookies[i].getValue());
			}
			if (cookies[i].getName().equals("myshopmd5")) {
				System.out.println(cookies[i].getValue());
			}
		}
	}
}
