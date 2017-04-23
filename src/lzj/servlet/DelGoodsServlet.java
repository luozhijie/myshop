package lzj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lzj.DAO.GoodsDao;
import lzj.DaoImpl.GoodsDaoImpl;
import lzj.entity.Goods;

/**
 * Servlet implementation class DelGoodsServlet
 */
@WebServlet("/DelGoods")
public class DelGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DelGoodsServlet() {
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
		GoodsDao goodsDao = new GoodsDaoImpl();
		goodsDao.delGoods(new Goods(gid, null, null, null, null, null, 0, 0));
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
