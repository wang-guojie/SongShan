package dao;

import java.util.List;

import entity.Ticket;

public interface TicketDao {
	
	// 新增购买记录
	int add(Ticket ticket);
	
	// 获取数据总量
	int sum(int state);
	
	int getAddId(Ticket ticket);
	
	// 删除当前记录
	int del(int id);
	
	// 更新记录状态
	int state(int id, int state);
	
	// 当前页的数据集合
	List<Ticket> arrSell(int page, int limit, int state);
	
	// 条件查询的数据集合
	List<Ticket> arrSell(int page, int limit, int state, String goodName, String user);
	
	// 返回当前购物记录对象
	Ticket getTicket(int id);
	
}
