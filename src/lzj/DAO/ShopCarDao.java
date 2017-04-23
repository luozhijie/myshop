package lzj.DAO;

import java.util.ArrayList;

import lzj.entity.ShopCar;

public interface ShopCarDao {
	public int addShopCar(ShopCar shopCar);

	public int delShopCar(ShopCar shopCar);

	public int updateShopCar(ShopCar shopCar);

	public ArrayList<ShopCar> findShopCarByUid(int uid);

	public ArrayList<ShopCar> findShopCarByUidPage(int uid, int page);
	
	public ShopCar findShopCarByUidEntity(int uid);
	
	public int delShopCarByUidAndGid(ShopCar shopCar);
	
	public int updateNum(int uid, int gid, int num);
}
