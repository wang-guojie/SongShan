package dao;

import java.util.List;

import entity.Ticket;

public interface TicketDao {
	
	// ���������¼
	int add(Ticket ticket);
	
	// ��ȡ��������
	int sum(int state);
	
	int getAddId(Ticket ticket);
	
	// ɾ����ǰ��¼
	int del(int id);
	
	// ���¼�¼״̬
	int state(int id, int state);
	
	// ��ǰҳ�����ݼ���
	List<Ticket> arrSell(int page, int limit, int state);
	
	// ������ѯ�����ݼ���
	List<Ticket> arrSell(int page, int limit, int state, String goodName, String user);
	
	// ���ص�ǰ�����¼����
	Ticket getTicket(int id);
	
}
