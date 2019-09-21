package service.impl;

import java.util.List;

import service.messagescrvice;
import dao.BaseDao;
import dao.impl.messagedaoimpl;
import entity.Page;
import entity.message;

public class messagesimpl extends BaseDao implements messagescrvice {
	messagedaoimpl mm=new messagedaoimpl();
	@Override
	public int add(message m) {
		// TODO Auto-generated method stub
		return mm.add(m);
	}

	@Override
	public int update(message m) {
		// TODO Auto-generated method stub
		return mm.update(m);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return mm.delete(id);
	}

	@Override
	public List<message> getAll(String name) {
		// TODO Auto-generated method stub
		return mm.getAll(name);
	}

	@Override
	public message checkname(int id) {
		// TODO Auto-generated method stub
		return mm.checkname(id);
	}

	@Override
	public List page(Page p) {
		// TODO Auto-generated method stub
		return mm.page(p);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return mm.count();
	}

	@Override
	public void getPage(Page pa, String name) {
	
		mm.getPage(pa, name);
	}

	@Override
	public int getAllCount(String name) {
		// TODO Auto-generated method stub
		return mm.getAllCount(name);
	}

}
