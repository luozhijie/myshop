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
import lzj.entity.User;

/**
 * Servlet implementation class EditAddress
 */
@WebServlet("/EditAddress")
public class EditAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditAddress() {
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
		Address addresse = addressDao.findAddressByAid(Integer.valueOf(request.getParameter("sid")));
		addresse.setAdress(address);
		addresse.setPhoneNumber(phoneNumber);
		addresse.setSendName(name);
		addressDao.updateAddress(addresse);
		response.sendRedirect("AddressManager.jsp");
	}

}
