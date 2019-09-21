package service;

import java.util.List;

import entity.Page;
import entity.message;

public interface messagescrvice {
	int add(message m);
	int update(message m);
	int delete(int id);
	public List<message> getAll();
	public List page(Page p);
	int count();
}
