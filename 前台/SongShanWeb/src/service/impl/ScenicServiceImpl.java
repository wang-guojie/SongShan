package service.impl;

import java.util.List;

import dao.impl.ScenicDaoImpl;
import entity.Scenic;
import service.ScenicService;

public class ScenicServiceImpl implements ScenicService {
	ScenicDaoImpl sd = new ScenicDaoImpl();

	@Override
	public List getList() {
		// TODO Auto-generated method stub
		return sd.getList();
	}

	@Override
	public Scenic getById(int id) {
		// TODO Auto-generated method stub
		return sd.getById(id);
	}

}
