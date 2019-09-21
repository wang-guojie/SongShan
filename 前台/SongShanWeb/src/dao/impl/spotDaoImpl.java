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
		String sql="insert into spot(spotname,spotcontext,imagesrc)value(?,?,?)";
		return super.executeUpdate(sql, s.getSpotname(),s.getSpotcontext(),s.getImagesrc());
	}

	@Override
	public int delete(int id) {
		String sql="delete from spot where spotid=?";
		return super.executeUpdate(sql, id);
	}

	@Override
	public int update(spot s) {
		String sql="executeUpdate spot set spotname=?,spotcontext=?,imagesrc=? where spotid=?";
		return super.executeUpdate(sql, s.getSpotname(),s.getSpotcontext(),s.getImagesrc(),s.getSpotid());
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
				s.setImagesrc(set.getString("imagesrc"));
				
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
				
				s.setImagesrc(set.getString("imagesrc"));
				
				
				
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
	public List list(Page page) {
		List list=new ArrayList();
		try {
			String sql="select * from spot limit ?,?";
			super.executeQuery(sql,(page.getPageIndex()-1)*page.getPageSize(),page.getPageSize());
			while (set.next()) {
				spot s=new spot();
				s.setSpotid(set.getInt("spotid"));
				s.setSpotname(set.getString("spotname"));
				
				s.setSpotcontext(set.getString("spotcontext"));
				
				s.setImagesrc(set.getString("imagesrc"));
				
				
				
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
			String sql="select count(*) from spot where name=?";
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
	
}
