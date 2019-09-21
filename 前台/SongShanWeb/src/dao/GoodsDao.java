package dao;

import java.util.List;

import entity.Goods;


public interface GoodsDao {
	
	// �����ֲ�����
	int upd(Goods goods);
	
	// ��ѯ
	List<Goods> arrSell(int typeid, int state);
	
	// ����
	int add(Goods goods);
	
	// ɾ��
	int del(int id);
	
	// ����
	Goods getGoods(int id);
	
	// ��ȡ��Ʒ������
	int getGoodsCount(int id, int sum, int state);
	
	// ������Ʒ����
	int updGoods(int id, int sum);
	
}
