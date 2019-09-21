package dao.impl;

import java.util.ArrayList;
import java.util.List;


import dao.BaseDao;
import dao.spotDao;
import entity.Page;
import entity.spot;

public class spotDaoImpl extends BaseDao implements spotDao {

	@Override
	public int add(spot s) {
		String sql="insert into spot(spotname,spotcontext) values(?,?)";
		return super.executeUpdate(sql, s.getSpotname(),s.getSpotcontext());
	}

	@Override
	public int delete(int id) {
		String sql="delete from spot where spotid=?";
		return super.executeUpdate(sql, id);
	}

	@Override
	public int update(spot s) {
		String sql="update spot set spotname=?,spotcontext=? where spotid=?";
		return super.executeUpdate(sql, s.getSpotname(),s.getSpotcontext(),s.getSpotid());
	}

	@Override
	public List<spot> list(String name) {
		List<spot> list=new ArrayList<spot>();
		try {
			String sql="select * from spot where spotname like '%"+name+"%'";
			super.executeQuery(sql);
			while (set.next()) {
				spot s=new spot();
				s.setSpotid(set.getInt("spotid"));
				s.setSpotname(set.getString("spotname"));
				s.setSpotcontext(set.getString("spotcontext"));
				
				
				list.add(s);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			super.close();
		}
		return list;
	}

	@Override
	public spot GetById(int id) {
		spot s=null;
		try {
			String sql="select * from spot where spotid=?";
			super.executeQuery(sql,id);
			while (set.next()) {
				s=new spot();
				s.setSpotid(set.getInt("spotid"));
				s.setSpotname(set.getString("spotname"));
				
				s.setSpotcontext(set.getString("spotcontext"));
				
				
				
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			super.close();
		}
		return s;
	}

	@Override
	public int GetByAll() {
		int count=0;
		try {
			String sql="select count(*) from spot";
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
	public List list(Page Page) {
		List list=new ArrayList();
		try {
			String sql="select * from spot limit ?,?";
			super.executeQuery(sql,(Page.getPageIndex()-1)*Page.getPageSize(),Page.getPageSize());
			while (set.next()) {
				spot s=new spot();
				s.setSpotid(set.getInt("spotid"));
				s.setSpotname(set.getString("spotname"));
				
				s.setSpotcontext(set.getString("spotcontext"));
				
				
				
				
				
				list.add(s);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			super.close();
		}
		return list;
	}

	@Override
	public int chname(String name) {
		int count=0;
		try {
			String sql="select count(*) from spot where spotname=?";
			super.executeQuery(sql,name);
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
	public void getPage(Page Page, String name) {
		List<spot> list=new ArrayList<spot>();
		try {
			String sql="select * from spot where 1=1";
			if(name!=""){
				sql+=" and spotname like '%"+name+"%'";
			}
			sql+=" limit ?,?";
			super.executeQuery(sql,(Page.getPageIndex()-1)*Page.getPageSize(),Page.getPageSize());
			while(set.next()){
				spot s=new spot();
				s.setSpotid(set.getInt("spotid"));
				s.setSpotname(set.getString("spotname"));
				
				s.setSpotcontext(set.getString("spotcontext"));
				
				
				list.add(s);
			}
			Page.setList(list);
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
		String sql="select count(*) from spot where 1=1";
		if(name!=""){
			sql+=" and spotname like '%"+name+"%'";
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
