package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.ScenicDao;
import entity.Scenic;

public class ScenicDaoImpl extends BaseDao implements ScenicDao {

	@Override
	public Scenic getById(int id) {
		Scenic sc = null;
		try {
			String sql = "SELECT * FROM scenic WHERE Scenicid=?";
			super.executeQuery(sql,id);
			while (set.next()) {
				sc = new Scenic();
				sc.setScenicid(set.getInt("Scenicid"));
				sc.setScenicname(set.getString("Scenicname"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return sc;
	}

	@Override
	public List getList() {
		List<Scenic> list = new ArrayList<Scenic>();
		try {
			String sql = "SELECT * FROM scenic";
			super.executeQuery(sql);
			while (set.next()) {
				Scenic sc = new Scenic();
				sc.setScenicid(set.getInt("Scenicid"));
				sc.setScenicname(set.getString("Scenicname"));
				list.add(sc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return list;
	}

}
