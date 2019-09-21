package dao;

import java.util.List;

import entity.Goods;


public interface GoodsDao {
	
	// 更新轮播内容
	int upd(Goods goods);
	
	// 查重
	int nameCount(String goodsName);
	
	// 修改商品状态
	int state(int id, int state);
	
	// 获取商品的数量
	int getGoodsCount(int id);
	
	// 获取数据总量
	int sum(int state);
	
	// 新增
	int add(Goods goods);
	
	// 删除
	int del(int id);
	
	// 详情
	Goods getGoods(int id);
	
	// 查询
	List<Goods> arrSell(int page, int limit, int state);
	
}
