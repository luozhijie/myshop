package lzj.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import lzj.DAO.BaseDao;
import lzj.DAO.RememberMeDao;
import lzj.entity.RememberMe;

public class RememberMeDaoImpl extends BaseDao implements RememberMeDao {

	@Override
	public int addRemeberMe(RememberMe rememberMe) {
		String sql = "INSERT INTO `shop`.`remberme` (`uid`, `md5`, `ip`) VALUES (?, ?, ?);";
		Object[] o = { rememberMe.getUid(), rememberMe.getMd5(), rememberMe.getIp() };
		return this.exceuteUpdate(sql, o);
	}

	@Override
	public int delRemeberMe(RememberMe rememberMe) {
		String sql = "DELETE FROM `shop`.`remberme` WHERE `uid`=?;";
		Object[] o = { rememberMe.getUid() };
		return this.exceuteUpdate(sql, o);
	}

	@Override
	public int updateRemeberMe(RememberMe rememberMe) {
		String sql = "UPDATE `shop`.`remberme` SET `md5`=?, `ip`=? WHERE `uid`=?;";
		Object[] o = { rememberMe.getMd5(), rememberMe.getIp(), rememberMe.getUid() };
		return this.exceuteUpdate(sql, o);
	}

	@Override
	public RememberMe findRemeberMeByUid(int uid) {
		String sql = "SELECT * FROM shop.remberme where uid = ?;";
		Object[] o = { uid };
		ResultSet rs = this.execeuteQuary(sql, o);
		RememberMe rememberMe = null;
		try {
			if (rs.next()) {
				rememberMe = new RememberMe(rs.getInt("uid"), rs.getString("md5"), rs.getString("ip"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rememberMe;
	}

	@Override
	public RememberMe findRemeberMeByMd5(String md5) {
		String sql = "SELECT * FROM shop.remberme where md5 = ?;";
		Object[] o = { md5 };
		ResultSet rs = this.execeuteQuary(sql, o);
		RememberMe rememberMe = null;
		try {
			if (rs.next()) {
				rememberMe = new RememberMe(rs.getInt("uid"), rs.getString("md5"), rs.getString("ip"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rememberMe;
	}

}
