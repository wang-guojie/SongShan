package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.InFormAtionDao;
import entity.InFormAtion;
import entity.Page;

public class InFormAtionDaoImpl extends BaseDao implements InFormAtionDao {

	@Override
	public List<InFormAtion> search() {
		List<InFormAtion> list = new ArrayList<InFormAtion>();
		try {
			String sql = "SELECT * FROM information";
			super.executeQuery(sql);
			while (set.next()) {
				InFormAtion f = new InFormAtion();
				f.setInforid(set.getInt("informationid"));
				f.setInforname(set.getString("informationname"));
				f.setInforcontent(set.getString("informationcontent"));
				f.setInfortime(set.getString("informationtime"));
				f.setTypeid(set.getInt("typeid"));
				ScenicDaoImpl sd = new ScenicDaoImpl();
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
	public InFormAtion getById(int id) {
		InFormAtion f = null;
		try {
			String sql = "SELECT * FROM information WHERE informationid=?";
			super.executeQuery(sql, id);
			while (set.next()) {
				f = new InFormAtion();
				f.setInforid(set.getInt("informationid"));
				f.setInforname(set.getString("informationname"));
				f.setInforcontent(set.getString("informationcontent"));
				f.setInfortime(set.getString("informationtime"));
				f.setTypeid(set.getInt("typeid"));
				ScenicDaoImpl sd = new ScenicDaoImpl();
				f.setScenic(sd.getById(set.getInt("typeid")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return f;
	}

}
