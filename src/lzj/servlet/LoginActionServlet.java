package lzj.servlet;

import java.io.IOException;
import java.io.Writer;
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
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
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
		} else {
			// request.setCharacterEncoding("utf-8");
			// response.setCharacterEncoding("utf-8");
			// Writer out = response.getWriter();
			// out.write("用户名或密码错误");
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
		// UserDao userdao = new UserDaoImpl();
		// RememberMeDao rememberMeDao = new RememberMeDaoImpl();
		// User user = null;
		// Cookie[] cookies = request.getCookies();
		// String myshopMd5 = null;
		// if (cookies == null) {
		// } else {
		// for (int i = 0; i < cookies.length; i++) {
		// // 获得具体的Cookie
		// Cookie cookie = cookies[i];
		// // 获得Cookie的名称
		// if (cookie.getName().equals("myshopmd5")) {
		// myshopMd5 = cookie.getValue();
		// if (rememberMeDao.findRemeberMeByMd5(myshopMd5) == null) {
		// myshopMd5 = null;
		// }
		// }
		// }
		// }
		// if (myshopMd5 == null) {
		// String username = request.getParameter("username");
		// String password = request.getParameter("password");
		// String[] rember = request.getParameterValues("remeberme");
		// user = userdao.findUserByUserNameAndPassword(username, password);
		// if (rember != null) {
		// try {
		// Cookie cookie = new Cookie("myshopmd5",
		// Md5Tools.EncoderByMd5(Math.random() + "pwd"));
		// cookie.setMaxAge(60 * 60 * 24 * 15);
		// response.addCookie(cookie);
		// rememberMeDao.addRemeberMe(
		// new RememberMe(user.getUid(), cookie.getValue(),
		// GetIpAdderss.getIpAddr(request)));
		// } catch (NoSuchAlgorithmException e) {
		// e.printStackTrace();
		// }
		// }
		// } else {
		//
		// }
	}

}
