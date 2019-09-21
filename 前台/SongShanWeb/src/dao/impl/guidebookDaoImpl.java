package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.guidebookDao;
import entity.Page;
import entity.guidebook;
import entity.ticketstype;

public class guidebookDaoImpl extends BaseDao implements guidebookDao {

	@Override
	public int add(guidebook g) {
		String sql="insert into guidebook(ticketsname,ticketsprice,ticketstype,remark,transport,imagesrc)value(?,?,?,?,?,?)";
		return super.executeUpdate(sql, g.getTicketsname(),g.getTicketsprice(),g.getTicketstype(),g.getRemark(),g.getTransport(),g.getImagesrc());
	}

	@Override
	public int delete(int id) {
		String sql="delete from guidebook where ticketsid=?";
		return super.executeUpdate(sql, id);
	}

	@Override
	public int update(guidebook g) {
		String sql="UPDATE guidebook SET ticketsname=?,ticketsprice=?,ticketstype=?,remark=?,transport=?,imagesrc=? WHERE ticketsid=?";
		return super.executeUpdate(sql, g.getTicketsname(),g.getTicketsprice(),g.getTicketstype(),g.getRemark(),g.getTransport(),g.getImagesrc(),g.getTicketsid());
	}

	@Override
	public List<guidebook> list(String name) {
		List<guidebook> list=new ArrayList<guidebook>();
		try {
			String sql="select * from guidebook where ticketsname like '%"+name+"%'";
			super.executeQuery(sql);
			while (set.next()) {
				guidebook g=new guidebook();
				g.setTicketsid(set.getInt("ticketsid"));
				g.setTicketsname(set.getString("ticketsname"));
				g.setTicketsprice(set.getFloat("ticketsprice"));
				g.setTicketstype(set.getInt("ticketstype"));
				g.setRemark(set.getString("remark"));
				g.setTransport(set.getString("transport"));
				g.setImagesrc(set.getString("imagesrc"));
				
				ticketstypeDaoImpl ca=new ticketstypeDaoImpl();
				ticketstype t=ca.GetById(set.getInt("ticketstype"));
				g.setTicketstypes(t);
				
				list.add(g);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			super.close();
		}
		return list;
	}

	@Override
	public int GetByAll() {
		int count=0;
		try {
			String sql="select count(*) from guidebook";
			super.executeQuery(sql);
			while (set.next()) {
				count=set.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			super.close();
		}
		return count;
	}

	@Override
	public List list(Page page) {
		List list=new ArrayList();
		try {
			String sql="select * from guidebook limit ?,?";
			super.executeQuery(sql,(page.getPageIndex()-1)*page.getPageSize(),page.getPageSize());
			while (set.next()) {
				guidebook g=new guidebook();
				g.setTicketsid(set.getInt("ticketsid"));
				g.setTicketsname(set.getString("ticketsname"));
				g.setTicketsprice(set.getFloat("ticketsprice"));
				g.setTicketstype(set.getInt("ticketstype"));
				g.setRemark(set.getString("remark"));
				g.setTransport(set.getString("transport"));
				g.setImagesrc(set.getString("imagesrc"));
				ticketstypeDaoImpl ca=new ticketstypeDaoImpl();
				ticketstype t=ca.GetById(set.getInt("ticketstype"));
				g.setTicketstypes(t);
				
				list.add(g);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			super.close();
		}
		return list;
	}

	@Override
	public guidebook GetById(int id) {
		guidebook g=null;
		try {
			String sql="select * from guidebook where ticketsid=?";
			super.executeQuery(sql,id);
			while (set.next()) {
				g=new guidebook();
				g.setTicketsid(set.getInt("ticketsid"));
				g.setTicketsname(set.getString("ticketsname"));
				g.setTicketsprice(set.getFloat("ticketsprice"));
				g.setTicketstype(set.getInt("ticketstype"));
				g.setRemark(set.getString("remark"));
				g.setTransport(set.getString("transport"));
				g.setImagesrc(set.getString("imagesrc"));
				
				ticketstypeDaoImpl ca=new ticketstypeDaoImpl();
				ticketstype t=ca.GetById(set.getInt("ticketstype"));
				
				g.setTicketstypes(t);
					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			super.close();
		}
		return g;
	}

}
