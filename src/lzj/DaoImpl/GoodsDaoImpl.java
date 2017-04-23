package lzj.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lzj.DAO.BaseDao;
import lzj.DAO.GoodsDao;
import lzj.entity.Category;
import lzj.entity.Goods;

public class GoodsDaoImpl extends BaseDao implements GoodsDao {

	@Override
	public int addGoods(Goods goods) {
		String sql = "INSERT INTO `shop`.`good_list` (`num`,`uid`, `goodname`, `goodinfo`, `goodcategoryid`, `goodimg1`, `goodimg2`, `goodimg3`, `goodimg4`, `goodimg5`,`goodprice`) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?,?);";
		Object[] o = { goods.getNum(), goods.getGoodsUpUserName(), goods.getGoodsName(), goods.getGoodsInfo(),
				goods.getGoodsCategory().getCid(), goods.getGoodsimg()[0], goods.getGoodsimg()[1],
				goods.getGoodsimg()[2], goods.getGoodsimg()[3], goods.getGoodsimg()[4], goods.getGoodsPrice() };
		return this.exceuteUpdate(sql, o);
	}

	@Override
	public int delGoods(Goods goods) {
		String sql = "DELETE FROM `shop`.`good_list` WHERE `gid`=?;";
		Object[] o = { goods.getGoodsId() };
		return this.exceuteUpdate(sql, o);
	}

	@Override
	public int updateGoods(Goods goods) {
		String sql = "UPDATE `shop`.`good_list` SET `num`=?,`goodprice`=?,`uid`=?, `goodname`=?, `goodinfo`=?, `goodcategoryid`=?, `goodimg1`=?, `goodimg2`=?, `goodimg3`=?, `goodimg4`=?, `goodimg5`=? WHERE `gid`=?;";
		Object[] o = { goods.getNum(), goods.getGoodsPrice(), goods.getGoodsUpUserName(), goods.getGoodsName(),
				goods.getGoodsInfo(), goods.getGoodsCategory().getCid(), goods.getGoodsimg()[0], goods.getGoodsimg()[1],
				goods.getGoodsimg()[2], goods.getGoodsimg()[3], goods.getGoodsimg()[4], goods.getGoodsId() };
		return this.exceuteUpdate(sql, o);
	}

	@Override
	public ArrayList<Goods> findGoodsByGid(int gid) {
		String sql = "SELECT * FROM shop.v_goods_category_username where gid = ?;";
		Object[] o = { gid };
		ArrayList<Goods> arrayListGoods = new ArrayList<>();
		ResultSet rs = this.execeuteQuary(sql, o);
		try {
			while (rs.next()) {
				Category category = new Category(-1, rs.getString("categoryname"));
				String[] img = { rs.getString("goodimg1"), rs.getString("goodimg2"), rs.getString("goodimg3"),
						rs.getString("goodimg4"), rs.getString("goodimg5") };
				Goods goods = new Goods(rs.getInt("gid"), rs.getString("goodname"), rs.getString("username"),
						rs.getString("goodinfo"), category, img, rs.getDouble("goodprice"), rs.getInt("num"));
				arrayListGoods.add(goods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayListGoods;
	}

	@Override
	public ArrayList<Goods> findGoodsByGoodsName(String goodName) {
		String sql = "SELECT * FROM shop.v_goods_category_username where goodname = ?;";
		Object[] o = { goodName };
		ArrayList<Goods> arrayListGoods = new ArrayList<>();
		ResultSet rs = this.execeuteQuary(sql, o);
		try {
			while (rs.next()) {
				Category category = new Category(-1, rs.getString("categoryname"));
				String[] img = { rs.getString("goodimg1"), rs.getString("goodimg2"), rs.getString("goodimg3"),
						rs.getString("goodimg4"), rs.getString("goodimg5") };
				Goods goods = new Goods(rs.getInt("gid"), rs.getString("goodname"), rs.getString("username"),
						rs.getString("goodinfo"), category, img, rs.getDouble("goodprice"), rs.getInt("num"));
				arrayListGoods.add(goods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayListGoods;
	}

	@Override
	public ArrayList<Goods> findGoodsByPage(int page) {
		int num = (page - 1) * 10;
		String sql = "SELECT * FROM shop.v_goods_category_username limit ?,10;";
		Object[] o = { num };
		ArrayList<Goods> arrayListGoods = new ArrayList<>();
		ResultSet rs = this.execeuteQuary(sql, o);
		try {
			while (rs.next()) {
				Category category = new Category(-1, rs.getString("categoryname"));
				String[] img = { rs.getString("goodimg1"), rs.getString("goodimg2"), rs.getString("goodimg3"),
						rs.getString("goodimg4"), rs.getString("goodimg5") };
				Goods goods = new Goods(rs.getInt("gid"), rs.getString("goodname"), rs.getString("username"),
						rs.getString("goodinfo"), category, img, rs.getDouble("goodprice"), rs.getInt("num"));
				arrayListGoods.add(goods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayListGoods;
	}

	@Override
	public Goods findGoods(int gid) {
		ArrayList<Goods> goods = this.findGoodsByGid(gid);
		if (goods.isEmpty()) {
			return null;
		}
		return goods.get(0);
	}

	@Override
	public int downNum(int gid, int num) {
		String sql = "UPDATE `shop`.`good_list` SET `num`=`num`-? WHERE `gid`=?;";
		Object[] o = { num, gid };
		return this.exceuteUpdate(sql, o);
	}

}
