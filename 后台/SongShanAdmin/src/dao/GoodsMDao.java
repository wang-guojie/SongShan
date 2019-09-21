package dao;

import java.util.List;

import entity.Goods;
import entity.GoodsM;


public interface GoodsMDao {
	
	// �����ֲ�����
	int upd(GoodsM g);
	
	// ����
	int nameCount(String goodsMName);
	
	// �޸���Ʒ״̬
	int state(int id, int state);
	
	// ��ȡ��������
	int sum(int state);
	
	// ����
	int add(GoodsM g);
	
	// ɾ��
	int del(int id);
	
	// ����
	GoodsM getGoodsM(int id);
	
	// ��ѯ
	List<GoodsM> arrSell(int state);
	
}
