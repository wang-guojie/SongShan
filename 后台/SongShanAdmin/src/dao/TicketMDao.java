package dao;

import java.util.List;
import entity.TicketM;

public interface TicketMDao {
	
	// 获取数据总量
	int sum(int state);
	
	// 更新记录状态
	int state(int id, int state);
	
	// 当前页的数据集合
	List<TicketM> arrSell(int page, int limit, int state);
	
	// 条件查询的数据集合
	List<TicketM> arrSell(int page, int limit, int state, String goodName, String user);
	
}
