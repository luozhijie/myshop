package lzj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lzj.DAO.GoodsDao;
import lzj.DaoImpl.GoodsDaoImpl;
import lzj.entity.Category;
import lzj.entity.Goods;
import lzj.entity.User;

/**
 * Servlet implementation class AddGoodsServlet
 */
@WebServlet("/AddGoods")
public class AddGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddGoodsServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		request.setCharacterEncoding("utf-8");
		User user = (User) request.getSession().getAttribute("user");
		String goodsName = request.getParameter("goodsName");
		String goodsInfo = request.getParameter("goodsInfo");
		double goodsPrice = Double.valueOf(request.getParameter("price"));
		int cid = Integer.valueOf(request.getParameter("categoryNo"));
		int num = Integer.valueOf(request.getParameter("num"));
		GoodsDao goodsDao = new GoodsDaoImpl();
		Goods goods = new Goods();
		goods.setGoodsCategory(new Category(cid, null));
		goods.setGoodsInfo(goodsInfo);
		goods.setGoodsName(goodsName);
		goods.setGoodsPrice(goodsPrice);
		goods.setGoodsUpUserName(user.getUid() + "");
		goods.setNum(num);
		goods.setGoodsimg(new String[] { "", "", "", "", "" });
		goodsDao.addGoods(goods);
	}

}
