package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.messagedao;
import entity.Page;
import entity.message;


public class messagedaoimpl extends BaseDao implements messagedao {

	@Override
	public int add(message m) {
		int result=0;
		try {
			String sql="INSERT INTO message(titlename,context,messagetime)VALUES(?,?,?)";
			result=super.executeUpdate(sql,m.getTitlename(),m.getContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(message m) {
		int result=0;
		try {
			String sql="UPDATE message SET titlename=?,context=?,messagetime=?  WHERE messageid=?";
			result=super.executeUpdate(sql,m.getTitlename(),m.getContext(),m.getMessagetime(),m.getMessageid());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(int id) {
		int result=0;
		String sql="delete from message where messageid=?";
		result=super.executeUpdate(sql,id);
		return result;
	}

	@Override
	public List<message> getAll(String name) {
		List<message> list=new ArrayList<message>();
		try {
			String sql="select * from message where titlename like '%"+name+"%' order by messageid desc ";
			super.executeQuery(sql);
			while(set.next()){
				message m=new message();
				m.setMessageid(set.getInt("messageid"));
				m.setTitlename(set.getString("titlename"));
				m.setContext(set.getString("context"));
				m.setMessagetime(set.getString("messagetime"));
				list.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			super.close();
		}
		return list;
	}

	@Override
	public message checkname(int id) {
		message m=null;
		try{
		String sql="select * from message where messageid=?";
		super.executeQuery(sql,id);
		while(set.next()){
			 m=new message();
			m.setMessageid(set.getInt("messageid"));
			m.setTitlename(set.getString("titlename"));
			m.setContext(set.getString("context"));
			m.setMessagetime(set.getString("messagetime"));
			
		}
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		super.close();
	}
		
		return m;
	}

	@Override
	public List page(Page p) {
		List list=new ArrayList();
		try {
		String sql="select * from message order by messageid desc  limit ?,? ";
		super.executeQuery(sql,(p.getPageIndex()-1)*p.getPageSize(),p.getPageSize());
		while(set.next()){
			message m=new message();
			m.setMessageid(set.getInt("messageid"));
			m.setTitlename(set.getString("titlename"));
			m.setContext(set.getString("context"));
			m.setMessagetime(set.getString("messagetime"));
			list.add(m);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		super.close();
	}
	return list;
}

	@Override
	public int count() {
		int count=0;
		String sql="select count(*) from message";
		super.executeQuery(sql);
		try {
			while(set.next()){
				count=set.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.close();
		}
		return count;
	}

	@Override
	public void getPage(Page pa, String name) {
		List<message> list=new ArrayList<message>();
		try {
			String sql="select * from message where 1=1 ";
			if(!(name.equals(""))){
				sql+=" and titlename like '%"+name+"%'";
			}
			sql+=" ORDER BY messageid desc limit ?,?";
			super.executeQuery(sql,(pa.getPageIndex()-1)*pa.getPageSize(),pa.getPageSize());
			while(set.next()){
				message m=new message();
				m.setMessageid(set.getInt("messageid"));
				m.setTitlename(set.getString("titlename"));
				m.setContext(set.getString("context"));
				m.setMessagetime(set.getString("messagetime"));
				list.add(m);
			}
			pa.setList(list);
		} catch (Exception e) {
		e.printStackTrace();
		}finally{
			super.close();
		}
		
	}

	@Override
	public int getAllCount(String name) {
		int count=0;
		try {
			String sql="select count(*) from message where 1=1";
			if(name!=""){
				sql+=" and titlename like '%"+name+"%'";
			}
			super.executeQuery(sql);
			while(set.next()){
				count=set.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			super.close();
		}
		return count;
	}

}
