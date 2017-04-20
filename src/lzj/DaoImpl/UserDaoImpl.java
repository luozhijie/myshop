package lzj.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lzj.DAO.BaseDao;
import lzj.DAO.UserDao;
import lzj.entity.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public int addUser(User user) {
		String sql = "INSERT INTO `shop`.`user_list` (`username`, `password`, `icon`, `usertype`) VALUES (?, ?, ?, ?);";
		Object[] o = { user.getUsername(), user.getPassword(), user.getIcon(), user.getUserType() };
		return this.exceuteUpdate(sql, o);
	}

	@Override
	public int delUser(User user) {
		String sql = "DELETE FROM `shop`.`user_list` WHERE `uid`=?;";
		Object[] o = { user.getUid() };
		return this.exceuteUpdate(sql, o);
	}

	@Override
	public int updateUser(User user) {
		String sql = "UPDATE `shop`.`user_list` SET `username`=?, `password`=?, `icon`=?, `usertype`=? WHERE `uid`=?;";
		Object[] o = { user.getUsername(), user.getPassword(), user.getIcon(), user.getUserType(), user.getUid() };
		return this.exceuteUpdate(sql, o);
	}

	@Override
	public ArrayList<User> findUserByUid(int uid) {
		String sql = "SELECT * FROM shop.user_list where uid = ?;";
		Object[] o = { uid };
		ResultSet rs = this.execeuteQuary(sql, o);
		ArrayList<User> arrayListUser = new ArrayList<>();
		try {
			while (rs.next()) {
				User user = new User();
				user.setArrayListAdress(new AddressDaoImpl().findAddressByUid(rs.getInt("uid")));
				user.setArrayListOrder(new OrderDaoImpl().findOrderByUid(rs.getInt("uid")));
				user.setIcon(rs.getString("icon"));
				user.setPassword(rs.getString("password"));
				user.setShopCar(new ShopCarDaoImpl().findShopCarByUid(rs.getInt("uid")));
				user.setUid(rs.getInt("uid"));
				user.setUsername(rs.getString("username"));
				user.setUserType(rs.getInt("usertype"));
				arrayListUser.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayListUser;
	}

	@Override
	public ArrayList<User> findUserByUserName(String userName) {
		String sql = "SELECT * FROM shop.user_list where username = ?;";
		Object[] o = { userName };
		ResultSet rs = this.execeuteQuary(sql, o);
		ArrayList<User> arrayListUser = new ArrayList<>();
		try {
			while (rs.next()) {
				User user = new User();
				user.setArrayListAdress(new AddressDaoImpl().findAddressByUid(rs.getInt("uid")));
				user.setArrayListOrder(new OrderDaoImpl().findOrderByUid(rs.getInt("uid")));
				user.setIcon(rs.getString("icon"));
				user.setPassword(rs.getString("password"));
				user.setShopCar(new ShopCarDaoImpl().findShopCarByUid(rs.getInt("uid")));
				user.setUid(rs.getInt("uid"));
				user.setUsername(rs.getString("username"));
				user.setUserType(rs.getInt("usertype"));
				arrayListUser.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayListUser;
	}

	@Override
	public ArrayList<User> findUserByPage(int page) {
		String sql = "SELECT * FROM shop.user_list limit ?,10;";
		Object[] o = { (page - 1) * 10 };
		ResultSet rs = this.execeuteQuary(sql, o);
		ArrayList<User> arrayListUser = new ArrayList<>();
		try {
			while (rs.next()) {
				User user = new User();
				user.setArrayListAdress(new AddressDaoImpl().findAddressByUid(rs.getInt("uid")));
				user.setArrayListOrder(new OrderDaoImpl().findOrderByUid(rs.getInt("uid")));
				user.setIcon(rs.getString("icon"));
				user.setPassword(rs.getString("password"));
				user.setShopCar(new ShopCarDaoImpl().findShopCarByUid(rs.getInt("uid")));
				user.setUid(rs.getInt("uid"));
				user.setUsername(rs.getString("username"));
				user.setUserType(rs.getInt("usertype"));
				arrayListUser.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayListUser;
	}

}
