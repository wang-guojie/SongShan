package service.impl;

import java.util.List;

import dao.impl.CarouselDaoImpl;
import entity.Carousel;
import service.CarouselService;

public class CarouselServiceImpl implements CarouselService {
	
	CarouselDaoImpl idi = new CarouselDaoImpl();
	
	@Override
	public int upd(Carousel index) {
		return idi.upd(index);
	}

	@Override
	public List<Carousel> arrSell(int typeid) {
		return idi.arrSell(typeid);
	}

	@Override
	public int add(Carousel index) {
		return idi.add(index);
	}

	@Override
	public int del(int id) {
		return idi.del(id);
	}

	@Override
	public Carousel carousel(int id) {
		return idi.carousel(id);
	}

}
