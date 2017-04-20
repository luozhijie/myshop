import java.util.ArrayList;

import lzj.DAO.AddressDao;
import lzj.DAO.GoodsDao;
import lzj.DaoImpl.AddressDaoImpl;
import lzj.DaoImpl.GoodsDaoImpl;
import lzj.DaoImpl.OrderDaoImpl;
import lzj.DaoImpl.ShopCarDaoImpl;
import lzj.DaoImpl.UserDaoImpl;
import lzj.entity.Address;
import lzj.entity.Category;
import lzj.entity.Goods;
import lzj.entity.Order;
import lzj.entity.ShopCar;
import lzj.entity.User;

public class Test {

	public static void main(String[] args) {
		// Address a = new Address(1,"asd","123213","aaa",1);
		// AddressDao ad = new AddressDaoImpl();
		//// ad.addAddress(a);
		// ArrayList<Address> al = ad.findAddressByUid(1);
		// for (Address address : al) {
		// System.out.println(address.getPhoneNumber());
		// }

		// GoodsDao gd = new GoodsDaoImpl();
		// ArrayList<Goods> a =gd.findGoodsByGoodsName("1");
		// for (Goods goods : a) {
		// System.out.println(goods.toString());
		// }
		// ArrayList<Goods> a = new ArrayList<>();
		// Goods g = new Goods(3, "asd", "aaa", "asdsadasdada", new
		// Category(1,"aaa"),new String[]{"","","","",""} ,111 , 2);
		// a.add(g);
		// OrderDaoImpl od = new OrderDaoImpl();

		// ShopCarDaoImpl sc = new ShopCarDaoImpl();
		// ShopCar shopCar = new ShopCar(111, 12, 1, 2);
		// sc.addShopCar(shopCar);
		// ArrayList<ShopCar> a = sc.findShopCarByUid(1);
		// for (ShopCar shopCar2 : a) {
		// System.out.println(shopCar2.toString());
		// }
		// GoodsDaoImpl gd = new GoodsDaoImpl();
		//
		// ArrayList<Goods> g = gd.findGoodsByGoodsName("1");
		// OrderDaoImpl od =new OrderDaoImpl();
		// AddressDaoImpl adi = new AddressDaoImpl();
		//
		// Address ad = adi.findAddressByUid(1).get(0);
		//
		// Order order = new Order(1, g, null, 111, 0, null, ad);
		// od.addOrder(order);
		// Order o = od.findOrderByOid(2).get(0);
		// System.out.println(o.toString());
		UserDaoImpl ud = new UserDaoImpl();
		ArrayList<User> userlist = ud.findUserByUid(1);
		for (User user : userlist) {
			System.out.println(user.toString());
		}
	}

}
