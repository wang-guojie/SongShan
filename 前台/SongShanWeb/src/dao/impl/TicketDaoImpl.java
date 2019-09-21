package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.TicketDao;
import entity.Ticket;

public class TicketDaoImpl extends BaseDao implements TicketDao {

	@Override
	public String add(Ticket ticket) {
		int id = 0;
		String Sql = "Insert Into ticket(goodsId,user,buyCount,beginTime,endTime,money,imgSrc) Values(?,?,?,?,?,?,?);";
		// 获取插入结果
		super.executeUpdate(Sql, ticket.getGoodsId(), ticket.getUser(),
				ticket.getBuyCount(), ticket.getBeginTime(),
				ticket.getEndTime(), ticket.getMoney(), ticket.getImgSrc());
		// 获取新增的ID
		Sql = "SELECT MAX(id) From ticket";
		super.executeQuery(Sql);
		try {
			if (super.set.next()) {
				id = super.set.getInt(1);
			}
			super.close();
			Sql = "Update ticket set imgSrc = ? Where id = ?";
			String src = "";
			src += "http://qr.topscan.com/api.php";
			src += "?text=http://" + ticket.getImgSrc() + "/SongShanWeb/TicketServlet?op=user_" + id;
			super.executeUpdate(Sql, src, id);
			return src;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return "0";
	}

	GoodsDaoImpl gdi = new GoodsDaoImpl();

	@Override
	public List<Ticket> arrSell() {
		String Sql = "Select * From ticket";
		List<Ticket> arr = new ArrayList<Ticket>();
		super.executeQuery(Sql);
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
				t.setMoney(super.set.getInt("money"));
				t.setState(super.set.getInt("state"));
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
		String Sql = "Select * From ticket Where id = ?";
		Ticket t = new Ticket();
		super.executeQuery(Sql, id);
		try {
			while (super.set.next()) {
				t.setId(super.set.getInt("id"));
				t.setGoodsId(super.set.getInt("goodsId"));
				t.setUser(super.set.getString("user"));
				t.setBuyCount(super.set.getInt("buyCount"));
				t.setBeginTime(super.set.getString("beginTime"));
				t.setEndTime(super.set.getString("endTime"));
				t.setOkTime(super.set.getString("okTime"));
				t.setMoney(super.set.getInt("money"));
				t.setImgSrc(super.set.getString("imgSrc"));
				t.setState(super.set.getInt("state"));
				t.setGoods(gdi.getGoods(t.getGoodsId()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return t;
	}
	
	// 实时刷新
	public int ticketUpdateDay() {
		String Sql = "Update ticket set state = 2 where id in(select * from (select id from ticket where to_days(endTime) - to_days(NOW() and state = 1) < 0) as ticket2);";
		return super.executeUpdate(Sql);
	}

	@Override
	public List<Ticket> arrSell(String user) {
		System.out.println("成功刷新了： " + ticketUpdateDay() + "条数据！");
		String Sql = "Select * From ticket Where user = ? order by id desc";
		List<Ticket> arr = new ArrayList<Ticket>();
		super.executeQuery(Sql, user);
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
				t.setMoney(super.set.getInt("money"));
				t.setImgSrc(super.set.getString("imgSrc"));
				t.setState(super.set.getInt("state"));
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
	public int upd(int id, int state) {
		String Sql = "Update ticket set state = ?, okTime = NOW() Where id = ?";
		// 获取插入结果
		return super.executeUpdate(Sql, state, id);
	}

	@Override
	public int dayCount() {
		String Sql = "Select SUM(buyCount) From Ticket Where to_days(okTime) = to_days(NOW())";
		int num = 0;
		super.executeQuery(Sql);
		try {
			while (super.set.next()) {
				num = super.set.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return num;
	}

	@Override
	public int getAddId(Ticket ticket) {
		int id = 0;
		String Sql = "Insert Into ticket(goodsId,user,buyCount,beginTime,endTime,money,imgSrc) Values(?,?,?,?,?,?,?);";
		// 获取插入结果
		super.executeUpdate(Sql, ticket.getGoodsId(), ticket.getUser(),
				ticket.getBuyCount(), ticket.getBeginTime(),
				ticket.getEndTime(), ticket.getMoney(), ticket.getImgSrc());
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
