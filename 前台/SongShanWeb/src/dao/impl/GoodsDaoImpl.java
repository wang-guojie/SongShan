package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.GoodsDao;
import entity.Goods;

public class GoodsDaoImpl extends BaseDao implements GoodsDao {
	
	@Override
	public int upd(Goods goods) {
		String Sql = "Update goods Set goodName=?,goodDesc=?,inventory=?,imgSrc=?,money=? Where id=?";
		return super.executeUpdate(Sql, goods.getGoodName(), goods.getGoodDesc(), goods.getInventory(), 
										goods.getImgSrc(), goods.getMoney(), goods.getId());
	}

	@Override
	public List<Goods> arrSell(int typeid, int state) {
		String Sql = "Select * From goods Where typeId = ? and state = ?";
		super.executeQuery(Sql, typeid, state);
		List<Goods> arr = new ArrayList<Goods>();
		try {
			while (super.set.next()) {
				Goods goods = new Goods();
				goods.setId(super.set.getInt("id"));
				goods.setTypeId(super.set.getInt("typeId"));
				goods.setGoodName(super.set.getString("goodName"));
				goods.setGoodDesc(super.set.getString("goodDesc"));
				goods.setInventory(super.set.getInt("inventory"));
				goods.setImgSrc(super.set.getString("imgSrc"));
				goods.setMoney(super.set.getInt("money"));
				goods.setState(super.set.getInt("state"));
				arr.add(goods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return arr;
	}

	@Override
	public int add(Goods goods) {
		String Sql = "Insert Into goods(typeId,goodName,goodDesc,inventory,imgSrc,money) Values(?,?,?,?,?,?)";
		return super.executeUpdate(Sql, goods.getTypeId(), goods.getGoodName(), goods.getGoodDesc(), goods.getInventory(), 
				goods.getImgSrc(), goods.getMoney());
	}

	@Override
	public int del(int id) {
		String Sql = "Delete From goods Where id = ?";
		return super.executeUpdate(Sql, id);
	}

	@Override
	public Goods getGoods(int id) {
		String Sql = "Select * From goods Where id = ?";
		super.executeQuery(Sql, id);
		Goods goods = new Goods();
		try {
			while (super.set.next()) {
				goods.setId(super.set.getInt("id"));
				goods.setTypeId(super.set.getInt("typeId"));
				goods.setGoodName(super.set.getString("goodName"));
				goods.setGoodDesc(super.set.getString("goodDesc"));
				goods.setInventory(super.set.getInt("inventory"));
				goods.setImgSrc(super.set.getString("imgSrc"));
				goods.setMoney(super.set.getInt("money"));
				goods.setState(super.set.getInt("state"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return goods;
	}

	@Override
	public int getGoodsCount(int id, int sum, int state) {
		String Sql = "Select inventory From goods Where id = ? and state = ?";
		int num = 0;
		super.executeQuery(Sql, id, state);
		Goods goods = new Goods();
		try {
			while (super.set.next()) {
				num = super.set.getInt("inventory");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		
		if (num < sum) {
			return -1;
		} else {
			return 1;
		}
		
	}

	@Override
	public int updGoods(int id, int sum) {
		String Sql = "Update goods Set inventory=(inventory-?) Where id=?";
		return super.executeUpdate(Sql, sum, id);
	}

}
