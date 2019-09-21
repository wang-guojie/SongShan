package service;

import java.util.List;

import entity.Scenic;

public interface ScenicService {
	 List getList();
		
	 Scenic getById(int id);
}
