package lzj.entity;

import java.util.ArrayList;

public class Order {
	private int userId;
	private ArrayList<Goods> arrayListGoods;// 商品集合
	private String time;// 时间
	private double totalPrice;// 总价格
	private int orderId;// 订单ID
	private String orderInfo;// 订单详情
	private Address adress;// 送货地址

	public Order() {
		super();
	}

	public Order(int userId, ArrayList<Goods> arrayListGoods, String time, double totalPrice, int orderId,
			String orderInfo, Address adress) {
		super();
		this.userId = userId;
		this.arrayListGoods = arrayListGoods;
		this.time = time;
		this.totalPrice = totalPrice;
		this.orderId = orderId;
		this.orderInfo = orderInfo;
		this.adress = adress;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public ArrayList<Goods> getArrayListGoods() {
		return arrayListGoods;
	}

	public void setArrayListGoods(ArrayList<Goods> arrayListGoods) {
		this.arrayListGoods = arrayListGoods;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(String orderInfo) {
		this.orderInfo = orderInfo;
	}

	public Address getAdress() {
		return adress;
	}

	public void setAdress(Address adress) {
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "Order [userId=" + userId + ", arrayListGoods=" + arrayListGoods + ", time=" + time + ", totalPrice="
				+ totalPrice + ", orderId=" + orderId + ", orderInfo=" + orderInfo + ", adress=" + adress + "]";
	}

	public void caculterTotalPrice() {
		this.totalPrice = 0;
		for (Goods goods : arrayListGoods) {
			this.totalPrice += goods.getGoodsPrice();
		}
	}

}
