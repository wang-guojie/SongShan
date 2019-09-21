package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.messagedao;
import dao.wenhuadao;
import entity.message;
import entity.wenhua;

public class wenhuadaoimpl extends BaseDao implements wenhuadao {

	@Override
	public int add(wenhua w) {
		int result = 0;
		try {
			String sql = "INSERT INTO culture(culturename,cultureexplanation) VALUES(?,?,?)";
			result = super.executeUpdate(sql, w.getCulturename(),
					w.getCultureexplanation());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(wenhua w) {
		int result = 0;
		try {
			String sql = "UPDATE culture SET culturename=?,cultureexplanation=? WHERE cultureid=?";
			result = super.executeUpdate(sql, w.getCulturename(),
					w.getCultureexplanation(), w.getCultureid());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(int id) {
		int result = 0;
		String sql = "delete from culture where cultureid=?";
		result = super.executeUpdate(sql, id);
		return result;
	}

	@Override
	public List<wenhua> getAll() {
		List<wenhua> list = new ArrayList<wenhua>();
		try {
			String sql = "select * from culture";
			super.executeQuery(sql);
			while (set.next()) {
				wenhua w = new wenhua();
				w.setCultureid(set.getInt("cultureid"));
				w.setCulturename(set.getString("culturename"));
				w.setCultureexplanation(set.getString("cultureexplanation"));
				w.setCulImage(set.getString("culImage"));

				list.add(w);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			super.close();
		}
		return list;
	}

	@Override
	public wenhua checkname(int id) {
		wenhua w = null;
		String sql = "select * from culture where cultureid=?";
		super.executeQuery(sql, id);
		try {
			while (set.next()) {
				w = new wenhua();
				w.setCultureid(set.getInt("cultureid"));
				w.setCulturename(set.getString("culturename"));
				w.setCultureexplanation(set.getString("cultureexplanation"));
				w.setCulImage(set.getString("culImage"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.close();
		}
		return w;
	}

}
