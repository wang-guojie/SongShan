package service;

import java.util.List;

import entity.Carousel;

public interface CarouselService {
	
	// 更新轮播内容
	int upd(Carousel index);
	
	// 查询
	List<Carousel> arrSell(int typeid);
	
	// 新增
	int add(Carousel index);
	
	// 删除
	int del(int id);
	
}
