package dao.impl;

import dao.AdminDao;
import dao.BaseDao;
import entity.Admin;

public class AdminDaoImpl extends BaseDao implements AdminDao {

	@Override
	public int adminAdd(Admin ad) {
		String sql="INSERT INTO admin (adminname,adminpwd) VALUES(?,?)";
		return super.executeUpdate(sql,ad.getAdminname(),ad.getAdminpwd());
	}

	@Override
	public int checkeName(Admin ad) {
		//Admin a=null;
		int count=0;
		try {
			String sql="SELECT count(*) FROM admin WHERE adminname=? AND adminpwd=?";
			super.executeQuery(sql,ad.getAdminname(),ad.getAdminpwd());
			while(set.next()){
				/*a=new Admin();
				a.setAdminid(set.getInt("adminid"));
				a.setAdminname(set.getString("adminname"));
				a.setAdminpwd(set.getString("adminpwd"));*/
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
