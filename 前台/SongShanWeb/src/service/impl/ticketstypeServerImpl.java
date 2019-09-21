package service.impl;

import java.util.List;

import service.ticketstypeServer;
import dao.impl.ticketstypeDaoImpl;
import entity.ticketstype;

public class ticketstypeServerImpl implements ticketstypeServer {
	ticketstypeDaoImpl tl=new ticketstypeDaoImpl();
	@Override
	public ticketstype GetById(int id) {
		// TODO Auto-generated method stub
		return tl.GetById(id);
	}

	@Override
	public List<ticketstype> GetByAll() {
		// TODO Auto-generated method stub
		return tl.GetByAll();
	}

}
