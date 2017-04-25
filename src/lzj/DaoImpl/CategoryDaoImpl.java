package lzj.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lzj.DAO.BaseDao;
import lzj.DAO.CategoryDao;
import lzj.entity.Category;

public class CategoryDaoImpl extends BaseDao implements CategoryDao {

	@Override
	public int addCategory(Category category) {
		String sql = "INSERT INTO `shop`.`good_category` (`categoryname`) VALUES (?);";
		Object[] o = { category.getCateGoryName() };
		return this.exceuteUpdate(sql, o);
	}

	@Override
	public int delAdderss(Category category) {
		String sql = "DELETE FROM `shop`.`good_category` WHERE `cid`=?;";
		Object[] o = { category.getCid() };
		return this.exceuteUpdate(sql, o);
	}

	@Override
	public int updateCategory(Category category) {
		String sql = "UPDATE `shop`.`good_category` SET `categoryname`=? WHERE `cid`=?;";
		Object[] o = { category.getCateGoryName(), category.getCid() };
		return this.exceuteUpdate(sql, o);
	}

	@Override
	public ArrayList<Category> findCategoryByCid(int cid) {
		String sql = "SELECT * FROM shop.good_category where cid=?;";
		Object[] o = { cid };
		ArrayList<Category> arrayList = new ArrayList<>();
		ResultSet rs = this.execeuteQuary(sql, o);
		try {
			while (rs.next()) {
				Category c = new Category(rs.getInt("cid"), rs.getString("categoryname"));
				arrayList.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return arrayList;
	}

	@Override
	public ArrayList<Category> findAllCategory() {
		String sql = "SELECT * FROM shop.good_category;";
		ArrayList<Category> arrayList = new ArrayList<>();
		ResultSet rs = this.execeuteQuary(sql, null);
		try {
			while (rs.next()) {
				Category c = new Category(rs.getInt("cid"), rs.getString("categoryname"));
				arrayList.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return arrayList;
	}

}
