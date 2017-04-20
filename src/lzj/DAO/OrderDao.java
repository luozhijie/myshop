package lzj.DAO;

import java.util.ArrayList;

import lzj.entity.Order;

public interface OrderDao {
	public int addOrder(Order order);

	public int delOrder(Order order);

	public int updateOrder(Order order);

	public ArrayList<Order> findOrderByUid(int uid);

	public ArrayList<Order> findOrderByOid(int oid);

	public ArrayList<Order> findOrderByUidPage(int uid, int page);
}
