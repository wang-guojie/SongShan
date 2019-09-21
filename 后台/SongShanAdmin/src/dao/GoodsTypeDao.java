package dao;

import java.util.List;

import entity.GoodsType;

public interface GoodsTypeDao {
	
	// 获取当前选中的商品分类对象
	GoodsType arrSell(int id);
	
	// 获取全体商品分类对象
	List<GoodsType> arrSell();
	
}
