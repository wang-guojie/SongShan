package service.impl;

import java.util.List;

import service.spotServer;
import dao.impl.spotDaoImpl;
import entity.Page;
import entity.spot;

public class spotServerImpl implements spotServer {
	spotDaoImpl sl=new spotDaoImpl();
	@Override
	public int add(spot s) {
		// TODO Auto-generated method stub
		return sl.add(s);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return sl.delete(id);
	}

	@Override
	public int update(spot s) {
		// TODO Auto-generated method stub
		return sl.update(s);
	}

	@Override
	public List<spot> list(String name) {
		// TODO Auto-generated method stub
		return sl.list(name);
	}

	@Override
	public spot GetById(int id) {
		// TODO Auto-generated method stub
		return sl.GetById(id);
	}

	@Override
	public int GetByAll() {
		// TODO Auto-generated method stub
		return sl.GetByAll();
	}

	@Override
	public List list(Page page) {
		// TODO Auto-generated method stub
		return sl.list(page);
	}

	@Override
	public int chname(String name) {
		// TODO Auto-generated method stub
		return sl.chname(name);
	}

}
