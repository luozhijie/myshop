package lzj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lzj.DAO.ShopCarDao;
import lzj.DaoImpl.ShopCarDaoImpl;
import lzj.DaoImpl.UserDaoImpl;
import lzj.entity.ShopCar;
import lzj.entity.User;

/**
 * Servlet implementation class DelShopCarListServlet
 */
@WebServlet("/DelShopCarList")
public class DelShopCarListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DelShopCarListServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int gid = Integer.valueOf(request.getParameter("gid"));
		User user = (User) request.getSession().getAttribute("user");
		ShopCarDao shopCarDao = new ShopCarDaoImpl();
		ShopCar shopcar = new ShopCar(0, 0, user.getUid(), gid);
		shopCarDao.delShopCarByUidAndGid(shopcar);
		response.sendRedirect("MyUserInfo.jsp");
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
