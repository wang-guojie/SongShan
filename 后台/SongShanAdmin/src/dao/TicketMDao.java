package dao;

import java.util.List;
import entity.TicketM;

public interface TicketMDao {
	
	// ��ȡ��������
	int sum(int state);
	
	// ���¼�¼״̬
	int state(int id, int state);
	
	// ��ǰҳ�����ݼ���
	List<TicketM> arrSell(int page, int limit, int state);
	
	// ������ѯ�����ݼ���
	List<TicketM> arrSell(int page, int limit, int state, String goodName, String user);
	
}
