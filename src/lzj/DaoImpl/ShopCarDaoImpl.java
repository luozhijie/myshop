package lzj.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lzj.DAO.BaseDao;
import lzj.DAO.ShopCarDao;
import lzj.entity.ShopCar;

public class ShopCarDaoImpl extends BaseDao implements ShopCarDao {

	@Override
	public int addShopCar(ShopCar shopCar) {
		String sql = "INSERT INTO `shop`.`shop_car` (`uid`, `gid`, `num`) VALUES (?, ?, ?);";
		Object[] o = { shopCar.getUserId(), shopCar.getGoodsId(), shopCar.getNum() };
		return this.exceuteUpdate(sql, o);
	}

	@Override
	public int delShopCar(ShopCar shopCar) {
		String sql = "DELETE FROM `shop`.`shop_car` WHERE `cid`=?;";
		Object[] o = { shopCar.getShopCarId() };
		return this.exceuteUpdate(sql, o);
	}

	@Override
	public int updateShopCar(ShopCar shopCar) {
		String sql = "UPDATE `shop`.`shop_car` SET `uid`=?, `gid`=?, `num`=? WHERE `cid`=?;";
		Object[] o = { shopCar.getUserId(), shopCar.getGoodsId(), shopCar.getNum(), shopCar.getShopCarId() };
		return this.exceuteUpdate(sql, o);
	}

	@Override
	public ArrayList<ShopCar> findShopCarByUid(int uid) {
		String sql = "SELECT * FROM shop.shop_car where uid =?;";
		Object[] o = { uid };
		ResultSet rs = this.execeuteQuary(sql, o);
		ArrayList<ShopCar> arrayListShopCar = new ArrayList<>();
		try {
			while (rs.next()) {
				ShopCar sc = new ShopCar(rs.getInt("cid"), rs.getInt("num"), rs.getInt("uid"), rs.getInt("gid"));
				arrayListShopCar.add(sc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return arrayListShopCar;
	}

	@Override
	public ArrayList<ShopCar> findShopCarByUidPage(int uid, int page) {
		String sql = "SELECT * FROM shop.shop_car where uid=? limit ?,10";
		Object[] o = { uid, (page - 1) * 10 };
		ResultSet rs = this.execeuteQuary(sql, o);
		ArrayList<ShopCar> arrayListShopCar = new ArrayList<>();

		try {
			while (rs.next()) {
				ShopCar sc = new ShopCar(rs.getInt("cid"), rs.getInt("num"), rs.getInt("uid"), rs.getInt("gid"));
				arrayListShopCar.add(sc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return arrayListShopCar;
	}

	@Override
	public ShopCar findShopCarByUidEntity(int uid) {
		ArrayList<ShopCar> shopcar = this.findShopCarByUid(uid);
		if (shopcar.isEmpty()) {
			return null;
		}
		return shopcar.get(0);
	}

	@Override
	public int delShopCarByUidAndGid(ShopCar shopCar) {
		String sql = "DELETE FROM `shop`.`shop_car` WHERE `gid`=? and `uid`=?;";
		Object[] o = { shopCar.getGoodsId(), shopCar.getUserId() };
		System.out.println(shopCar.getGoodsId() + "     " + shopCar.getUserId());
		return this.exceuteUpdate(sql, o);
	}

	@Override
	public int updateNum(int uid, int gid, int num) {
		String sql = "UPDATE `shop`.`shop_car` SET  `num`=? WHERE `uid`=? and `gid`=?;";
		Object[] o = { num, uid, gid };
		return this.exceuteUpdate(sql, o);
	}

	@Override
	public ShopCar findShopCarByUidAndGid(int uid, int gid) {
		String sql = "SELECT * FROM shop.shop_car where uid =? and gid =?;";
		Object[] o = { uid, gid };
		ResultSet rs = this.execeuteQuary(sql, o);
		ArrayList<ShopCar> arrayListShopCar = new ArrayList<>();
		try {
			while (rs.next()) {
				ShopCar sc = new ShopCar(rs.getInt("cid"), rs.getInt("num"), rs.getInt("uid"), rs.getInt("gid"));
				arrayListShopCar.add(sc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		if (arrayListShopCar.isEmpty()) {
			return null;
		}
		return arrayListShopCar.get(0);
	}

	@Override
	public int addShopCarNum(int uid, int gid) {
		String sql = "UPDATE `shop`.`shop_car` SET  `num`=`num`+1 WHERE `uid`=? and `gid`=?;";
		Object[] o = { uid, gid };
		return this.exceuteUpdate(sql, o);
	}

	@Override
	public int delUidShopCar(int uid) {
		String sql = "DELETE FROM `shop`.`shop_car` WHERE `uid`=?;";
		return this.exceuteUpdate(sql, new Object[] { uid });
	}
}
