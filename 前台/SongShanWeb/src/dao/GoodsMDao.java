package dao;

import java.util.List;

import entity.Goods;
import entity.GoodsM;


public interface GoodsMDao {
	
	// ����
	int add(GoodsM g);
	
	// ɾ��
	int del(int id);
	
	// ����
	GoodsM getGoodsM(int id);
	
	// ��ѯ
	List<GoodsM> arrSell(int state);
	
	// ��ȡ��Ʒ������
	int getGoodsCount(int id, int sum, int state);
	
	// ������Ʒ����
	int updGoods(int id, int sum);
	
}
