package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.InFormAtionDao;
import entity.InFormAtion;
import entity.Page;

public class InFormAtionDaoImpl extends BaseDao implements InFormAtionDao {

	@Override
	// 添加
	public int inFormAtionAdd(InFormAtion info) {
		String sql = "INSERT INTO information (informationname,informationcontent,informationtime,typeid) VALUES(?,?,now(),?)";
		return super.executeUpdate(sql, info.getInforname(),
				info.getInforcontent(),info.getTypeid());
	}

	@Override
	// 查询
	public List<InFormAtion> search(String name) {
		List<InFormAtion> list = new ArrayList<InFormAtion>();
		try {
			String sql = "SELECT * FROM information WHERE informationname LIKE '%"+name+"%'";
			super.executeQuery(sql);
			while (set.next()) {
				InFormAtion f = new InFormAtion();
				f.setInforid(set.getInt("informationid"));
				f.setInforname(set.getString("informationname"));
				f.setInforcontent(set.getString("informationcontent"));
				f.setInfortime(set.getString("informationtime"));
				f.setTypeid(set.getInt("typeid"));
				ScenicDaoImpl sd=new ScenicDaoImpl();
				f.setScenic(sd.getById(set.getInt("typeid")));
				// 对象添加到集合
				list.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return list;
	}

	@Override
	// 修改
	public int inFormAtionUpdate(InFormAtion info) {
		String sql = "UPDATE information SET informationname=?,informationcontent=?,typeid=? WHERE informationid=?";
		return super.executeUpdate(sql, info.getInforname(),
				info.getInforcontent(),info.getTypeid(), info.getInforid());
	}

	@Override
	// 删除
	public int inFormAtionDelete(int id) {
		String sql = "DELETE FROM information WHERE informationid=?";
		return super.executeUpdate(sql, id);
	}

	@Override
	public InFormAtion getById(int id) {
		InFormAtion f = null;
		try {
			String sql = "SELECT * FROM information where informationid=?";
			super.executeQuery(sql,id);
			while (set.next()) {
				f = new InFormAtion();
				f.setInforid(set.getInt("informationid"));
				f.setInforname(set.getString("informationname"));
				f.setInforcontent(set.getString("informationcontent"));
				f.setInfortime(set.getString("informationtime"));
				f.setTypeid(set.getInt("typeid"));
				ScenicDaoImpl sd=new ScenicDaoImpl();
				f.setScenic(sd.getById(set.getInt("typeid")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return f;
	}

	@Override
	public int checkeName(String name) {
		int count = 0;
		try {
			String sql = "SELECT COUNT(*) FROM information WHERE informationname=?";
			super.executeQuery(sql, name);
			while (set.next()) {
				count = set.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return count;
	}

	@Override
	public int getAllCount() {
		int count = 0;
		try {
			String sql = "SELECT COUNT(*) FROM information";
			super.executeQuery(sql);
			while (set.next()) {
				count = set.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return count;
	}

	@Override
	public List list(Page page) {
		List list = new ArrayList();
		try {
			String sql = "SELECT * FROM information LIMIT ?,?";
			super.executeQuery(sql,
					(page.getPageIndex() - 1) * page.getPageSize(),
					page.getPageSize());
			while (set.next()) {
				InFormAtion f = new InFormAtion();
				f.setInforid(set.getInt("informationid"));
				f.setInforname(set.getString("informationname"));
				f.setInforcontent(set.getString("informationcontent"));
				f.setInfortime(set.getString("informationtime"));
				f.setTypeid(set.getInt("typeid"));
				ScenicDaoImpl sd = new ScenicDaoImpl();
				f.setScenic(sd.getById(set.getInt("typeid")));
				list.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return list;
	}

	@Override
	public void get4Page(Page page, String name, int typeid) {
		List<InFormAtion> list = new ArrayList<InFormAtion>();
		try {
			String sql = "select * from information where 1=1 ";
			if(!(name.equals(""))){
				sql += "         and informationname like '%"+name+"%'";
			}
			if(typeid != -1){
				sql += "        and typeid = "+typeid;
			}
			sql += " order by informationid desc  limit ?,?";
			super.executeQuery(sql,(page.getPageIndex()-1)*page.getPageSize(),page.getPageSize());
			while(set.next()){
				InFormAtion f = new InFormAtion();
				f.setInforid(set.getInt("informationid"));
				f.setInforname(set.getString("informationname"));
				f.setInforcontent(set.getString("informationcontent"));
				f.setInfortime(set.getString("informationtime"));
				f.setTypeid(set.getInt("typeid"));
				ScenicDaoImpl sd=new ScenicDaoImpl();
				f.setScenic(sd.getById(set.getInt("typeid")));
				// 对象添加到集合
				list.add(f);
			}
			page.setList(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		
	}

	@Override
	public int getAllCount(String name, int typeid) {
		int count = 0;
		try {
			String sql = "select count(*) from information where 1=1";
			if(!(name.equals(""))){
				sql += " and informationname like '%"+name+"%'";
			}
			if(typeid != -1){
				sql += " and typeid = "+typeid;
			}
			super.executeQuery(sql);
			while(set.next()){
				count = set.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			super.close();
		}
		return count;
	}


}
