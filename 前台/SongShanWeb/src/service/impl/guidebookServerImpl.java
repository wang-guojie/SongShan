package service.impl;

import java.util.List;

import service.guidebookServer;
import dao.impl.guidebookDaoImpl;
import entity.Page;
import entity.guidebook;

public class guidebookServerImpl implements guidebookServer {
	guidebookDaoImpl gl=new guidebookDaoImpl();
	@Override
	public int add(guidebook g) {
		// TODO Auto-generated method stub
		return gl.add(g);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return gl.delete(id);
	}

	@Override
	public int update(guidebook g) {
		// TODO Auto-generated method stub
		return gl.update(g);
	}

	@Override
	public List<guidebook> list(String name) {
		// TODO Auto-generated method stub
		return gl.list(name);
	}

	@Override
	public guidebook GetById(int id) {
		// TODO Auto-generated method stub
		return gl.GetById(id);
	}

	@Override
	public int GetByAll() {
		// TODO Auto-generated method stub
		return gl.GetByAll();
	}

	@Override
	public List list(Page page) {
		// TODO Auto-generated method stub
		return gl.list(page);
	}

}
