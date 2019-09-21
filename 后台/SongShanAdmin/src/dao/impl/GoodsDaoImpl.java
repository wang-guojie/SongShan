package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.GoodsDao;
import entity.Goods;

public class GoodsDaoImpl extends BaseDao implements GoodsDao {
		
	GoodsTypeDaoImpl gtdi = new GoodsTypeDaoImpl();
	
	@Override
	public int upd(Goods goods) {
		String Sql = "Update goods Set goodName=?,goodDesc=?,inventory=?,imgSrc=?,money=?,typeid=? Where id=?";
		return super.executeUpdate(Sql, goods.getGoodName(), goods.getGoodDesc(), goods.getInventory(), 
										goods.getImgSrc(), goods.getMoney(), goods.getTypeId(), goods.getId());
	}
	
	@Override
	public int state(int id, int state) {
		String Sql = "Update goods Set state=? Where id=?";
		return super.executeUpdate(Sql, state, id);
	}
	
	@Override
	public List<Goods> arrSell(int page, int limit, int state) {
		String Sql = "Select * From goods Where state = ? order by id desc Limit ?,?";
		super.executeQuery(Sql, state, (page-1)*limit, limit);
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
				goods.setType(gtdi.arrSell(goods.getTypeId()));
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
				goods.setType(gtdi.arrSell(goods.getId()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return goods;
	}

	@Override
	public int getGoodsCount(int id) {
		String Sql = "Select inventory From goods Where id = ?";
		int sum = 0;
		super.executeQuery(Sql, id);
		Goods goods = new Goods();
		try {
			while (super.set.next()) {
				sum = super.set.getInt("inventory");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return sum;
	}

	@Override
	public int sum(int state) {
		String Sql = "Select count(*) as c From goods Where state = ?";
		super.executeQuery(Sql, state);
		int sum = 0;
		try {
			while (super.set.next()) {
				sum = super.set.getInt("c");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return sum;
	}

	@Override
	public int nameCount(String goodsName) {
		String Sql = "Select count(*) as c From goods Where goodName = ?";
		super.executeQuery(Sql, goodsName);
		int num = 0;
		try {
			while (super.set.next()) {
				num = super.set.getInt("c");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return num;
	}

}
