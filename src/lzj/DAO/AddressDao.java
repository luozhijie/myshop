package lzj.DAO;

import java.util.ArrayList;
import lzj.entity.Address;

public interface AddressDao {
	public int addAddress(Address address);

	public int delAdderss(Address address);

	public int updateAddress(Address address);

	public ArrayList<Address> findAddressByUid(int uid);
	
	public Address findAddressByAid(int sid);
}