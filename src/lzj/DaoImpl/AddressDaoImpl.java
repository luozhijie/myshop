package lzj.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lzj.DAO.AddressDao;
import lzj.DAO.BaseDao;
import lzj.entity.Address;

public class AddressDaoImpl extends BaseDao implements AddressDao {

	@Override
	public int addAddress(Address address) {
		String sql = "INSERT INTO `shop`.`send_address_list` (`uid`, `address`, `phonenumber`, `name`) VALUES (?, ?, ?, ?);";
		return this.exceuteUpdate(sql, new Object[] { address.getUserId(), address.getAdress(),
				address.getPhoneNumber(), address.getSendName() });
	}

	@Override
	public int delAdderss(Address address) {
		String sql = "DELETE FROM `shop`.`send_address_list` WHERE `sid`=?;";
		return this.exceuteUpdate(sql, new Object[] { address.getAdressId() });
	}

	@Override
	public int updateAddress(Address address) {
		String sql = "UPDATE `shop`.`send_address_list` SET `uid`=?, `address`=?, `phonenumber`=?, `name`=? WHERE `sid`=?;";
		Object[] o = { address.getUserId(), address.getAdress(), address.getPhoneNumber(), address.getSendName(),
				address.getAdressId() };
		return this.exceuteUpdate(sql, o);
	}

	@Override
	public ArrayList<Address> findAddressByUid(int uid) {
		String sql = "SELECT * FROM shop.send_address_list where uid= ? ;";
		ResultSet rs = this.execeuteQuary(sql, new Object[] { uid });
		ArrayList<Address> arrayListAdress = new ArrayList<>();
		try {
			while (rs.next()) {
				Address address = new Address(rs.getInt("sid"), rs.getString("address"), rs.getString("phonenumber"),
						rs.getString("name"), rs.getInt("uid"));
				arrayListAdress.add(address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return arrayListAdress;
	}

	@Override
	public Address findAddressByAid(int sid) {
		String sql = "SELECT * FROM shop.send_address_list where sid= ? ;";
		ResultSet rs = this.execeuteQuary(sql, new Object[] { sid });
		ArrayList<Address> arrayListAdress = new ArrayList<>();
		try {
			while (rs.next()) {
				Address address = new Address(rs.getInt("sid"), rs.getString("address"), rs.getString("phonenumber"),
						rs.getString("name"), rs.getInt("uid"));
				arrayListAdress.add(address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return arrayListAdress.get(0);
	}

}
