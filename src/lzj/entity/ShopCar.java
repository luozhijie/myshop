package lzj.entity;

public class ShopCar {
	private int shopCarId;
	private int num;
	private int userId;
	private int goodsId;

	public ShopCar() {
		super();
	}

	public ShopCar(int shopCarId, int num, int userId, int goodsId) {
		super();
		this.shopCarId = shopCarId;
		this.num = num;
		this.userId = userId;
		this.goodsId = goodsId;
	}

	public int getShopCarId() {
		return shopCarId;
	}

	public void setShopCarId(int shopCarId) {
		this.shopCarId = shopCarId;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	@Override
	public String toString() {
		return "ShopCar [shopCarId=" + shopCarId + ", num=" + num + ", userId=" + userId + ", goodsId=" + goodsId + "]";
	}

}
