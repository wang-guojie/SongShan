package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.ticketstypeDao;
import entity.ticketstype;

public class ticketstypeDaoImpl extends BaseDao implements ticketstypeDao {

	@Override
	public ticketstype GetById(int id) {
		ticketstype t=null;
		try {
			String sql="select * from ticketstype where ticketsId=?";
			super.executeQuery(sql, id);
			while (set.next()) {
				t=new ticketstype();
				t.setTicketsId(set.getInt("ticketsId"));
				t.setTicketstypename(set.getString("ticketstypename"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			super.close();
		}
		return t;
	}

	@Override
	public List<ticketstype> GetByAll() {
		List<ticketstype> list=new ArrayList<ticketstype>();
		try {
			String sql="select * from ticketstype";
			super.executeQuery(sql);
			while (set.next()) {
				ticketstype t=new ticketstype();
				t.setTicketsId(set.getInt("ticketsId"));
				t.setTicketstypename(set.getString("ticketstypename"));
				list.add(t);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			super.close();
		}
		return list;
	}

}
