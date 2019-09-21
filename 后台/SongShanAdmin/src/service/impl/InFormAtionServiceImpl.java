package service.impl;

import java.util.List;

import dao.impl.InFormAtionDaoImpl;
import entity.InFormAtion;
import entity.Page;
import service.InFormAtionService;

public class InFormAtionServiceImpl implements InFormAtionService {
	InFormAtionDaoImpl ifa = new InFormAtionDaoImpl();

	@Override
	public int inFormAtionAdd(InFormAtion info) {
		// TODO Auto-generated method stub
		return ifa.inFormAtionAdd(info);
	}

	@Override
	public List<InFormAtion> search(String name) {
		// TODO Auto-generated method stub
		return ifa.search(name);
	}

	@Override
	public int inFormAtionUpdate(InFormAtion info) {
		// TODO Auto-generated method stub
		return ifa.inFormAtionUpdate(info);
	}

	@Override
	public int inFormAtionDelete(int id) {
		// TODO Auto-generated method stub
		return ifa.inFormAtionDelete(id);
	}

	@Override
	public InFormAtion getById(int id) {
		// TODO Auto-generated method stub
		return ifa.getById(id);
	}

	@Override
	public int checkeName(String name) {
		// TODO Auto-generated method stub
		return ifa.checkeName(name);
	}

	@Override
	public int getAllCount() {
		// TODO Auto-generated method stub
		return ifa.getAllCount();
	}

	@Override
	public List list(Page page) {
		// TODO Auto-generated method stub
		return ifa.list(page);
	}

	@Override
	public void get4Page(Page page, String name, int typeid) {
		ifa.get4Page(page, name, typeid);
	}

	@Override
	public int getAllCount(String name, int typeid) {
		// TODO Auto-generated method stub
		return ifa.getAllCount(name, typeid);
	}

}
