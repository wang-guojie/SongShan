package service;

import java.util.List;

import entity.Carousel;

public interface CarouselService {
	
	// �����ֲ�����
	int upd(Carousel index);
	
	// ��ѯ
	List<Carousel> arrSell(int typeid);
	
	// ����
	int add(Carousel index);
	
	// ɾ��
	int del(int id);
	
}
