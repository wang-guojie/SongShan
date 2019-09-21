package dao;

import java.util.List;

import entity.Ticket;

public interface TicketDao {
	
	String add(Ticket ticket);
	
	int getAddId(Ticket ticket);
	
	int upd(int id, int state);
	
	List<Ticket> arrSell();
	
	Ticket getTicket(int id);
	
	List<Ticket> arrSell(String user);
	
	int dayCount();
	
}
