package lzj.entity;

import java.util.Arrays;

public class Goods {
	private int goodsId;// 商品id
	private String goodsName;// 商品名
	private String goodsUpUserName;// 商品上传者名
	private String goodsInfo;// 商品介绍
	private Category goodsCategory;// 商品类别
	private String[] goodsimg = new String[5];// 商品图片名
	private double goodsPrice;// 商品价格
	private int num;// 数量

	public Goods() {
		super();
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsUpUserName() {
		return goodsUpUserName;
	}

	public void setGoodsUpUserName(String goodsUpUserName) {
		this.goodsUpUserName = goodsUpUserName;
	}

	public String getGoodsInfo() {
		return goodsInfo;
	}

	public void setGoodsInfo(String goodsInfo) {
		this.goodsInfo = goodsInfo;
	}

	public Category getGoodsCategory() {
		return goodsCategory;
	}

	public void setGoodsCategory(Category goodsCategory) {
		this.goodsCategory = goodsCategory;
	}

	public String[] getGoodsimg() {
		return goodsimg;
	}

	public void setGoodsimg(String[] goodsimg) {
		this.goodsimg = goodsimg;
	}

	public double getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Goods(int goodsId, String goodsName, String goodsUpUserName, String goodsInfo, Category goodsCategory,
			String[] goodsimg, double goodsPrice, int num) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsUpUserName = goodsUpUserName;
		this.goodsInfo = goodsInfo;
		this.goodsCategory = goodsCategory;
		this.goodsimg = goodsimg;
		this.goodsPrice = goodsPrice;
		this.num = num;
	}

	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodsUpUserName=" + goodsUpUserName
				+ ", goodsInfo=" + goodsInfo + ", goodsCategory=" + goodsCategory + ", goodsimg="
				+ Arrays.toString(goodsimg) + ", goodsPrice=" + goodsPrice + ", num=" + num + "]";
	}

}
