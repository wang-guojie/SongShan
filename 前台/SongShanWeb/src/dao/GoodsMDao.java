package dao;

import java.util.List;

import entity.Goods;
import entity.GoodsM;


public interface GoodsMDao {
	
	// 新增
	int add(GoodsM g);
	
	// 删除
	int del(int id);
	
	// 详情
	GoodsM getGoodsM(int id);
	
	// 查询
	List<GoodsM> arrSell(int state);
	
	// 获取商品的数量
	int getGoodsCount(int id, int sum, int state);
	
	// 更新商品数量
	int updGoods(int id, int sum);
	
}
