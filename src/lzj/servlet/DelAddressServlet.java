package lzj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lzj.DAO.AddressDao;
import lzj.DaoImpl.AddressDaoImpl;
import lzj.entity.Address;

/**
 * Servlet implementation class DelAddressServlet
 */
@WebServlet("/DelAddress")
public class DelAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DelAddressServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int aid = Integer.valueOf(request.getParameter("aid"));
		AddressDao addressDao = new AddressDaoImpl();
		addressDao.delAdderss(new Address(aid, null, null, null, 0));
		response.sendRedirect("UserManager.jsp");
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
