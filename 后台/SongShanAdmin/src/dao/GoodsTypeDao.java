package dao;

import java.util.List;

import entity.GoodsType;

public interface GoodsTypeDao {
	
	// ��ȡ��ǰѡ�е���Ʒ�������
	GoodsType arrSell(int id);
	
	// ��ȡȫ����Ʒ�������
	List<GoodsType> arrSell();
	
}
