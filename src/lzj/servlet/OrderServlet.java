package lzj.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lzj.DAO.GoodsDao;
import lzj.DAO.OrderDao;
import lzj.DAO.ShopCarDao;
import lzj.DaoImpl.AddressDaoImpl;
import lzj.DaoImpl.GoodsDaoImpl;
import lzj.DaoImpl.OrderDaoImpl;
import lzj.DaoImpl.ShopCarDaoImpl;
import lzj.entity.Goods;
import lzj.entity.Order;
import lzj.entity.ShopCar;
import lzj.entity.User;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/Order")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		OrderDao orderdao = new OrderDaoImpl();
		ShopCarDao shopCarDao = new ShopCarDaoImpl();
		GoodsDao goodsDao = new GoodsDaoImpl();
		double price = 0;
		ArrayList<ShopCar> al = shopCarDao.findShopCarByUid(user.getUid());
		ArrayList<Goods> gal = new ArrayList<>();
		for (ShopCar shopCar : al) {
			Goods goods = goodsDao.findGoods(shopCar.getGoodsId());
			goods.setNum(shopCar.getNum());
			price += (goods.getGoodsPrice() * goods.getNum());
			gal.add(goods);
			goodsDao.downNum(goods.getGoodsId(), goods.getNum());
		}
		Order order = new Order(user.getUid(), gal, "", price, 0, "",
				new AddressDaoImpl().findAddressByAid(Integer.valueOf(request.getParameter("sid"))));
		orderdao.addOrder(order);
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
