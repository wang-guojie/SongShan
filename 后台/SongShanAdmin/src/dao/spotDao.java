package dao;

import java.util.List;

import entity.Page;
import entity.spot;

public interface spotDao {
	int add(spot s);
	int delete(int id);
	int update(spot s);
	List<spot> list(String name);
	spot GetById(int id);
	
	int GetByAll();
	List list(Page page);
	
	int chname(String name);
	
	//·ÖÒ³ +É¾³ý+ÐÞ¸Ä+²éÑ¯
	
	void getPage(Page page,String name);
	
	int getAllCount(String name);
}
