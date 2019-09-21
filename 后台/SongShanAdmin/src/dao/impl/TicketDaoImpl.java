package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.TicketDao;
import entity.Ticket;

public class TicketDaoImpl extends BaseDao implements TicketDao {

	@Override
	public int add(Ticket ticket) {
		String Sql = "Insert Into ticket(goodsId,user,buyCount,beginTime,endTime,money) Values(?,?,?,?,?,?)";
		return super.executeUpdate(Sql, ticket.getGoodsId(), ticket.getUser(),
				ticket.getBuyCount(), ticket.getBeginTime(),
				ticket.getEndTime(), ticket.getMoney());
	}

	GoodsDaoImpl gdi = new GoodsDaoImpl();

	@Override
	public List<Ticket> arrSell(int page, int limit, int state) {
		String Sql = "Select * From ticket Where state = ? order by id desc Limit ?,? ";
		List<Ticket> arr = new ArrayList<Ticket>();
		super.executeQuery(Sql, state, (page - 1) * limit, limit);
		try {
			while (super.set.next()) {
				Ticket t = new Ticket();
				t.setId(super.set.getInt("id"));
				t.setGoodsId(super.set.getInt("goodsId"));
				t.setUser(super.set.getString("user"));
				t.setBuyCount(super.set.getInt("buyCount"));
				t.setBeginTime(super.set.getString("beginTime"));
				t.setEndTime(super.set.getString("endTime"));
				t.setOkTime(super.set.getString("okTime"));
				t.setState(super.set.getInt("state"));
				t.setMoney(super.set.getInt("money"));
				t.setGoods(gdi.getGoods(t.getGoodsId()));
				arr.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return arr;
	}

	@Override
	public Ticket getTicket(int id) {
		String Sql = "Select * From ticket";
		Ticket t = new Ticket();
		super.executeQuery(Sql);
		try {
			while (super.set.next()) {
				t.setId(super.set.getInt("id"));
				t.setGoodsId(super.set.getInt("goodsId"));
				t.setUser(super.set.getString("user"));
				t.setBuyCount(super.set.getInt("buyCount"));
				t.setBeginTime(super.set.getString("beginTime"));
				t.setEndTime(super.set.getString("endTime"));
				t.setOkTime(super.set.getString("okTime"));
				t.setState(super.set.getInt("state"));
				t.setMoney(super.set.getInt("money"));
				t.setGoods(gdi.getGoods(t.getGoodsId()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return t;
	}

	@Override
	public int sum(int state) {
		String Sql = "Select count(*) as c From ticket Where state = ?";
		super.executeQuery(Sql, state);
		int sum = 0;
		try {
			while (super.set.next()) {
				sum = super.set.getInt("c");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return sum;
	}

	@Override
	public int del(int id) {
		String Sql = "Delete From ticket Where id = ?";
		return super.executeUpdate(Sql, id);
	}

	@Override
	public int state(int id, int state) {
		String Sql = "Update ticket Set state = ? Where id = ?";
		return super.executeUpdate(Sql, state, id);
	}

	@Override
	public List<Ticket> arrSell(int page, int limit, int state,
			String goodName, String user) {
		String Sql = "Select * From ticket Where state = ? and goodsId in(Select id From goods Where goodName Like '%"
				+ goodName + "%') and user Like '%" + user + "%' order by id desc Limit ?,?";
		List<Ticket> arr = new ArrayList<Ticket>();
		super.executeQuery(Sql, state, (page - 1) * limit, limit);
		try {
			while (super.set.next()) {
				Ticket t = new Ticket();
				t.setId(super.set.getInt("id"));
				t.setGoodsId(super.set.getInt("goodsId"));
				t.setUser(super.set.getString("user"));
				t.setBuyCount(super.set.getInt("buyCount"));
				t.setBeginTime(super.set.getString("beginTime"));
				t.setEndTime(super.set.getString("endTime"));
				t.setOkTime(super.set.getString("okTime"));
				t.setState(super.set.getInt("state"));
				t.setMoney(super.set.getInt("money"));
				t.setGoods(gdi.getGoods(t.getGoodsId()));
				arr.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return arr;
	}

	@Override
	public int getAddId(Ticket ticket) {
		int id = 0;
		String Sql = "Insert Into ticket(goodsId,user,buyCount,beginTime,endTime,money) Values(?,?,?,?,?,?)";
		// 获取插入结果
		super.executeUpdate(Sql, ticket.getGoodsId(), ticket.getUser(),
				ticket.getBuyCount(), ticket.getBeginTime(),
				ticket.getEndTime(), ticket.getMoney());
		// 获取新增的ID
		Sql = "SELECT MAX(id) From ticket";
		super.executeQuery(Sql);
		try {
			if (super.set.next()) {
				id = super.set.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return id;
	}

}
