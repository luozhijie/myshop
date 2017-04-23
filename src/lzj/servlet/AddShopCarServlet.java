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
 * Servlet implementation class AddShopCarServlet
 */
@WebServlet("/AddShopCar")
public class AddShopCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddShopCarServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		request.setCharacterEncoding("utf-8");
		int gid = Integer.valueOf(request.getParameter("gid"));
		ShopCarDao shopCarDao = new ShopCarDaoImpl();
		if (shopCarDao.findShopCarByUidAndGid(user.getUid(), gid) == null) {
			shopCarDao.addShopCar(new ShopCar(0, 1, user.getUid(), gid));
		} else {
			shopCarDao.addShopCarNum(user.getUid(), gid);
		}
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
