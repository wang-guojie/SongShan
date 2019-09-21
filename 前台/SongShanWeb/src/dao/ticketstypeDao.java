package dao;

import java.util.List;

import entity.ticketstype;

public interface ticketstypeDao {
	ticketstype GetById(int id);
	List<ticketstype> GetByAll();
}
