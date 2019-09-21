package dao;

import java.util.List;

import entity.Page;
import entity.guidebook;


public interface guidebookDao {
	int add(guidebook g);
	int delete(int id);
	int update(guidebook g);
	List<guidebook> list(String name);
	guidebook GetById(int id);
	
	int GetByAll();
	List list(Page page);
}
