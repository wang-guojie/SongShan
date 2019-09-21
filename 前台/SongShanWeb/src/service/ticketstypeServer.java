package service;

import java.util.List;

import entity.ticketstype;

public interface ticketstypeServer {
	ticketstype GetById(int id);
	List<ticketstype> GetByAll();
}
