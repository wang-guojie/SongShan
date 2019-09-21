package service.impl;

import service.AdminService;
import dao.impl.AdminDaoImpl;
import entity.Admin;

public class AdminServiceImpl implements AdminService {
	AdminDaoImpl add=new AdminDaoImpl();
	@Override
	public int adminAdd(Admin ad) {
		
		return add.adminAdd(ad);
	}
	@Override
	public int checkeName(Admin ad) {
		
		return add.checkeName(ad);
	}



}
