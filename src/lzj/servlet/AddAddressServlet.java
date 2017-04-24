package lzj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.buf.UEncoder;

import lzj.DAO.AddressDao;
import lzj.DaoImpl.AddressDaoImpl;
import lzj.entity.Address;
import lzj.entity.User;

/**
 * Servlet implementation class AddAdressServlet
 */
@WebServlet("/AddAddress")
public class AddAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddAddressServlet() {
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
		String name = request.getParameter("name");
		String phoneNumber = request.getParameter("phoneNumber");
		String address = request.getParameter("address");

		AddressDao addressDao = new AddressDaoImpl();
		User user = (User) request.getSession().getAttribute("user");
		addressDao.addAddress(new Address(0, address, phoneNumber, name, user.getUid()));
		response.sendRedirect("UserManager.jsp");
	}

}
