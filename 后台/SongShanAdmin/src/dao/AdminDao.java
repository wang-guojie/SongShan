package dao;

import entity.Admin;

public interface AdminDao {

	int adminAdd(Admin ad);

	int checkeName(Admin ad);
}
