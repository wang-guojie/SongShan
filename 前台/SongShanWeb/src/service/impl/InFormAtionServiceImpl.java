package service.impl;

import java.util.List;

import dao.impl.InFormAtionDaoImpl;
import entity.InFormAtion;
import entity.Page;
import service.InFormAtionService;

public class InFormAtionServiceImpl implements InFormAtionService {
	InFormAtionDaoImpl ifa = new InFormAtionDaoImpl();

	@Override
	public List<InFormAtion> search() {
		// TODO Auto-generated method stub
		return ifa.search();
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
	public InFormAtion getById(int id) {
		// TODO Auto-generated method stub
		return ifa.getById(id);
	}

	


}
