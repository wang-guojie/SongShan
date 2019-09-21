package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.wenhuadao;
import entity.wenhua;

public class wenhuadaoimpl extends BaseDao implements wenhuadao {

	@Override
	public int add(wenhua w) {
		int resetult = 0;
		try {
			String sql = "INSERT INTO culture(culturename,cultureexplanation) values(?,?)";
			resetult = super.executeUpdate(sql, w.getCulturename(),
					w.getCultureexplanation());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resetult;
	}

	@Override
	public int update(wenhua w) {
		int resetult = 0;
		try {
			String sql = "UPDATE culture set culturename=?,cultureexplanation=? WHERE cultureid=?";
			resetult = super.executeUpdate(sql, w.getCulturename(),
					w.getCultureexplanation(), w.getCultureid());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resetult;
	}

	@Override
	public int delete(int id) {
		int resetult = 0;
		String sql = "delete from culture where cultureid=?";
		resetult = super.executeUpdate(sql, id);
		return resetult;
	}

	@Override
	public List<wenhua> getAll(String name) {
		List<wenhua> lisett = new ArrayList<wenhua>();
		try {
			String sql = "select * from culture where culturename like '%"+ name + "%'";
			super.executeQuery(sql);
			while (set.next()) {
				wenhua w = new wenhua();
				w.setCultureid(set.getInt("cultureid"));
				w.setCulturename(set.getString("culturename"));
				w.setCultureexplanation(set.getString("cultureexplanation"));

				lisett.add(w);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			super.close();
		}
		return lisett;
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
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			super.close();
		}
		return w;
	}

}
