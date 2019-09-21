package dao;

import java.util.List;

import entity.Scenic;

public interface ScenicDao {
		
	 List getList();
	
	 Scenic getById(int id);
}
