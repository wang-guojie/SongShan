package dao;

import java.sql.*;

public class BaseDao {
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected Connection con;
	protected ResultSet set;
	protected PreparedStatement pre;
	
	protected void connection() {
		try {
			if (con == null || con.isClosed()) {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cnsongshan2","root","ok");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void close() {
		try {
			if (set != null) {
				set.close();
			}
			if (pre != null) {
				pre.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected int executeUpdate(String Sql, Object...o) {
		int sum = 0;
		connection();
		try {
			pre = con.prepareStatement(Sql);
			for (int i = 0; i < o.length; i++) {
				pre.setObject(i+1, o[i]);
			}
			sum = pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return sum;
	}
	
	protected void executeQuery(String Sql, Object...o) {
		connection();
		try {
			pre = con.prepareStatement(Sql);
			for (int i = 0; i < o.length; i++) {
				pre.setObject(i+1, o[i]);
			}
			set = pre.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
