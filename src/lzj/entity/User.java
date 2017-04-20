package lzj.entity;

import java.util.ArrayList;

public class User {// 用户实体
	private int uid;// 用户id
	private String username;// 用户名
	private String password;// 密码
	private String icon;// 用户头像
	private ArrayList<Address> arrayListAdress = new ArrayList<>();// 用户地址信息
	private int userType;// 用户类型
	private ArrayList<ShopCar> shopCar;// 用户购物车
	private ArrayList<Order> arrayListOrder = new ArrayList<>();// 订单集合

	public User() {
		super();
	}

	public User(int uid, String username, String password, String icon, ArrayList<Address> arrayListAdress,
			int userType, ArrayList<ShopCar> shopCar, ArrayList<Order> arrayListOrder) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.icon = icon;
		this.arrayListAdress = arrayListAdress;
		this.userType = userType;
		this.shopCar = shopCar;
		this.arrayListOrder = arrayListOrder;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public ArrayList<Address> getArrayListAdress() {
		return arrayListAdress;
	}

	public void setArrayListAdress(ArrayList<Address> arrayListAdress) {
		this.arrayListAdress = arrayListAdress;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public ArrayList<ShopCar> getShopCar() {
		return shopCar;
	}

	public void setShopCar(ArrayList<ShopCar> shopCar) {
		this.shopCar = shopCar;
	}

	public ArrayList<Order> getArrayListOrder() {
		return arrayListOrder;
	}

	public void setArrayListOrder(ArrayList<Order> arrayListOrder) {
		this.arrayListOrder = arrayListOrder;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", icon=" + icon
				+ ", arrayListAdress=" + arrayListAdress + ", userType=" + userType + ", shopCar=" + shopCar
				+ ", arrayListOrder=" + arrayListOrder + "]";
	}

	

}