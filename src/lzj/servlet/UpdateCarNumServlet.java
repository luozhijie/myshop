package lzj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lzj.DAO.ShopCarDao;
import lzj.DaoImpl.ShopCarDaoImpl;
import lzj.entity.ShopCar;
import lzj.entity.User;

/**
 * Servlet implementation class UpdateCarNumServlet
 */
@WebServlet("/UpdateCarNum")
public class UpdateCarNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int gid;
	int num;
	int uid;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCarNumServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		gid = Integer.valueOf(request.getParameter("gid"));

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		num = Integer.valueOf(request.getParameter("num"));
		uid = ((User) request.getSession().getAttribute("user")).getUid();
		ShopCarDao shopCarDao = new ShopCarDaoImpl();
		shopCarDao.updateNum(uid, gid, num);
		response.sendRedirect("MyUserInfo.jsp");
	}

}
