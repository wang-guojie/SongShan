package dao;

import java.util.List;

import entity.Goods;


public interface GoodsDao {
	
	// 更新轮播内容
	int upd(Goods goods);
	
	// 查询
	List<Goods> arrSell(int typeid, int state);
	
	// 新增
	int add(Goods goods);
	
	// 删除
	int del(int id);
	
	// 详情
	Goods getGoods(int id);
	
	// 获取商品的数量
	int getGoodsCount(int id, int sum, int state);
	
	// 更新商品数量
	int updGoods(int id, int sum);
	
}
