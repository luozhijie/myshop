package lzj.DAO;

import java.util.ArrayList;

import lzj.entity.Goods;

public interface GoodsDao {
	public int addGoods(Goods goods);

	public int delGoods(Goods goods);

	public int updateGoods(Goods goods);

	public ArrayList<Goods> findGoodsByGid(int gid);

	public ArrayList<Goods> findGoodsByGoodsName(String goodName);
	
	public ArrayList<Goods> findGoodsByPage(int page);
}
