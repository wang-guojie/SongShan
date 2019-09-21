package service;

import java.util.List;

import entity.Page;
import entity.spot;

public interface spotServer {
	int add(spot s);
	int delete(int id);
	int update(spot s);
	List<spot> list(String name);
	spot GetById(int id);
	
	int GetByAll();
	List list(Page Page);
	
	int chname(String name);
	
	//·ÖÒ³ +É¾³ý+ÐÞ¸Ä+²éÑ¯
	
		void getPage(Page Page,String name);
		
		int getAllCount(String name);
}
