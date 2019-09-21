package service.impl;

import java.util.List;

import service.wenhuascrvice;
import dao.impl.wenhuadaoimpl;
import entity.wenhua;

public class wenhuascrviceimpl implements wenhuascrvice {
	wenhuadaoimpl  we=new wenhuadaoimpl();
	@Override
	public int add(wenhua w) {
		// TODO Auto-generated method stub
		return we.add(w);
	}

	@Override
	public int update(wenhua w) {
		// TODO Auto-generated method stub
		return we.update(w);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return we.delete(id);
	}

	@Override
	public List<wenhua> getAll() {
		// TODO Auto-generated method stub
		return we.getAll();
	}

	@Override
	public wenhua checkname(int id) {
		// TODO Auto-generated method stub
		return we.checkname(id);
	}

}
