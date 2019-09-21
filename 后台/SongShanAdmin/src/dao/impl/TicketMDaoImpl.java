package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.TicketDao;
import dao.TicketMDao;
import entity.GoodsM;
import entity.Ticket;
import entity.TicketM;

public class TicketMDaoImpl extends BaseDao implements TicketMDao {

	@Override
	public int sum(int state) {
		String Sql = "Select count(*) as c From ticketM Where state = ?";
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
	public int state(int id, int state) {
		String Sql = "Update ticketM Set state = ? Where id = ?";
		return super.executeUpdate(Sql, state, id);
	}
	
	GoodsDaoImpl gdi = new GoodsDaoImpl();
	GoodsMDaoImpl gdmi = new GoodsMDaoImpl();
	
	@Override
	public List<TicketM> arrSell(int page, int limit, int state) {
		String Sql = "Select * From ticketM Where state = ? order by id desc Limit ?,? ";
		List<TicketM> arr = new ArrayList<TicketM>();
		super.executeQuery(Sql, state, (page - 1) * limit, limit);
		try {
			while (super.set.next()) {
				TicketM t = new TicketM();
				t.setId(super.set.getInt("id"));
				t.setGoodsId(super.set.getInt("goodsId"));
				t.setUser(super.set.getString("user"));
				t.setBuyCount(super.set.getInt("buyCount"));
				t.setBeginTime(super.set.getString("beginTime"));
				t.setEndTime(super.set.getString("endTime"));
				t.setOkTime(super.set.getString("okTime"));
				t.setState(super.set.getInt("state"));
				t.setMoney(super.set.getInt("money"));
				t.setGoodsM(gdmi.getGoodsM(t.getGoodsId()));
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
	public List<TicketM> arrSell(int page, int limit, int state,
			String goodName, String user) {
		String Sql = "Select * From ticketM Where state = ? and goodsId in(Select id From goodsM Where goodName Like '%"
				+ goodName + "%') and user Like '%" + user + "%' order by id desc Limit ?,?";
		List<TicketM> arr = new ArrayList<TicketM>();
		super.executeQuery(Sql, state, (page - 1) * limit, limit);
		try {
			while (super.set.next()) {
				TicketM t = new TicketM();
				t.setId(super.set.getInt("id"));
				t.setGoodsId(super.set.getInt("goodsId"));
				t.setUser(super.set.getString("user"));
				t.setBuyCount(super.set.getInt("buyCount"));
				t.setBeginTime(super.set.getString("beginTime"));
				t.setEndTime(super.set.getString("endTime"));
				t.setOkTime(super.set.getString("okTime"));
				t.setState(super.set.getInt("state"));
				t.setMoney(super.set.getInt("money"));
				t.setGoodsM(gdmi.getGoodsM(t.getGoodsId()));
				arr.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return arr;
	}

}
