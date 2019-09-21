package dao;

import java.util.List;

import entity.Goods;


public interface GoodsDao {
	
	// �����ֲ�����
	int upd(Goods goods);
	
	// ����
	int nameCount(String goodsName);
	
	// �޸���Ʒ״̬
	int state(int id, int state);
	
	// ��ȡ��Ʒ������
	int getGoodsCount(int id);
	
	// ��ȡ��������
	int sum(int state);
	
	// ����
	int add(Goods goods);
	
	// ɾ��
	int del(int id);
	
	// ����
	Goods getGoods(int id);
	
	// ��ѯ
	List<Goods> arrSell(int page, int limit, int state);
	
}
