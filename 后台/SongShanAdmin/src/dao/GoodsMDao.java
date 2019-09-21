package dao;

import java.util.List;

import entity.Goods;
import entity.GoodsM;


public interface GoodsMDao {
	
	// 更新轮播内容
	int upd(GoodsM g);
	
	// 查重
	int nameCount(String goodsMName);
	
	// 修改商品状态
	int state(int id, int state);
	
	// 获取数据总量
	int sum(int state);
	
	// 新增
	int add(GoodsM g);
	
	// 删除
	int del(int id);
	
	// 详情
	GoodsM getGoodsM(int id);
	
	// 查询
	List<GoodsM> arrSell(int state);
	
}
