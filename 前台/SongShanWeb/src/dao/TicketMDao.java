package dao;

import java.util.List;

import entity.TicketM;

public interface TicketMDao {
	
	String add(TicketM ticket);
	
	int upd(int id, int state);
	
	List<TicketM> arrSell();
	
	TicketM getTicketM(int id);
	
	List<TicketM> arrSell(String user);
	
	int dayCount();
	
}
