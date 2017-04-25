package lzj.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import lzj.DAO.BaseDao;
import lzj.DAO.OrderDao;
import lzj.entity.Goods;
import lzj.entity.Order;

public class OrderDaoImpl extends BaseDao implements OrderDao {
	Gson gson = new Gson();

	@Override
	public int addOrder(Order order) {

		String sql = "INSERT INTO `shop`.`order_list` (`uid`, `totalprice`, `orderinfo`, `sid`) VALUES (?, ?, ?, ?);";
		Object[] o = { order.getUserId(), order.getTotalPrice(), gson.toJson(order.getArrayListGoods()),
				order.getAdress().getAdressId() };
		return this.exceuteUpdate(sql, o);
	}

	@Override
	public int delOrder(Order order) {
		String sql = "DELETE FROM `shop`.`order_list` WHERE `oid`=?;";
		Object[] o = { order.getOrderId() };
		return this.exceuteUpdate(sql, o);
	}

	@Override
	public int updateOrder(Order order) {
		String sql = "UPDATE `shop`.`order_list` SET `uid`=?, `totalprice`=?, `orderinfo`=?, `sid`=? WHERE `oid`=?;";
		Object[] o = { order.getUserId(), order.getTotalPrice(), gson.toJson(order.getArrayListGoods()),
				order.getAdress().getAdressId(), order.getOrderId() };
		return this.exceuteUpdate(sql, o);
	}

	@Override
	public ArrayList<Order> findOrderByUid(int uid) {
		String sql = "SELECT * FROM order_list where uid=?;";
		Object[] o = { uid };
		ResultSet rs = this.execeuteQuary(sql, o);
		ArrayList<Order> arrayListOrder = new ArrayList<>();
		try {
			while (rs.next()) {
				Order order = new Order();
				order.setAdress(new AddressDaoImpl().findAddressByUid(rs.getInt("uid")).get(0));
				order.setArrayListGoods(gson.fromJson(rs.getString("orderinfo"), new TypeToken<ArrayList<Goods>>() {
				}.getType()));
				order.setOrderId(rs.getInt("oid"));
				order.setOrderInfo(rs.getString("orderinfo"));
				order.setTime(rs.getString("orderdate"));
				order.setTotalPrice(rs.getDouble("totalprice"));
				order.setUserId(rs.getInt("uid"));
				arrayListOrder.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return arrayListOrder;
	}

	@Override
	public ArrayList<Order> findOrderByOid(int oid) {
		String sql = "SELECT * FROM order_list where oid=?;";
		Object[] o = { oid };
		ResultSet rs = this.execeuteQuary(sql, o);
		ArrayList<Order> arrayListOrder = new ArrayList<>();
		try {
			while (rs.next()) {
				Order order = new Order();
				order.setAdress(new AddressDaoImpl().findAddressByUid(rs.getInt("sid")).get(0));
				order.setArrayListGoods(gson.fromJson(rs.getString("orderinfo"), new TypeToken<ArrayList<Goods>>() {
				}.getType()));
				order.setOrderId(rs.getInt("oid"));
				order.setOrderInfo(rs.getString("orderinfo"));
				order.setTime(rs.getString("orderdate"));
				order.setTotalPrice(rs.getDouble("totalprice"));
				order.setUserId(rs.getInt("uid"));
				arrayListOrder.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return arrayListOrder;
	}

	@Override
	public ArrayList<Order> findOrderByUidPage(int uid, int page) {
		String sql = "SELECT * FROM shop.order_list where uid=? limit ?,10;";
		Object[] o = { uid, page };
		ResultSet rs = this.execeuteQuary(sql, o);
		ArrayList<Order> arrayListOrder = new ArrayList<>();
		try {
			while (rs.next()) {
				Order order = new Order();
				order.setAdress(new AddressDaoImpl().findAddressByUid(rs.getInt("sid")).get(0));
				order.setArrayListGoods(gson.fromJson(rs.getString("orderinfo"), new TypeToken<ArrayList<Goods>>() {
				}.getType()));
				order.setOrderId(rs.getInt("oid"));
				order.setOrderInfo(rs.getString("orderinfo"));
				order.setTime(rs.getString("orderdate"));
				order.setTotalPrice(rs.getDouble("totalprice"));
				order.setUserId(rs.getInt("uid"));
				arrayListOrder.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return arrayListOrder;
	}

}
