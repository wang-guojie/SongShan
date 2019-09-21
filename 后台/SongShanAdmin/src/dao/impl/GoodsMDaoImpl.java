package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.GoodsMDao;
import entity.Goods;
import entity.GoodsM;

public class GoodsMDaoImpl extends BaseDao implements GoodsMDao {

	GoodsTypeDaoImpl gtdi = new GoodsTypeDaoImpl();

	@Override
	public int upd(GoodsM g) {
		String Sql = "Update goodsM Set goodsId=?,goodName=?,goodDesc=?,inventory=?,imgSrc=?,money=? Where id=?";
		return super.executeUpdate(Sql, g.getGoodsId(), g.getGoodName(),
				g.getGoodDesc(), g.getInventory(), g.getImgSrc(), g.getMoney(),
				g.getId());
	}

	@Override
	public int state(int id, int state) {
		String Sql = "Update goodsM Set state=? Where id=?";
		return super.executeUpdate(Sql, state, id);
	}

	@Override
	public int sum(int state) {
		String Sql = "Select count(*) as c From goodsM Where state = ?";
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
	public int add(GoodsM g) {
		String Sql = "Insert Into goodsM(goodsId,goodName,goodDesc,inventory,imgSrc,money) Values(?,?,?,?,?,?)";
		return super.executeUpdate(Sql, g.getGoodsId(), g.getGoodName(),
				g.getGoodDesc(), g.getInventory(), g.getImgSrc(), g.getMoney());
	}

	@Override
	public int del(int id) {
		return 0;
	}

	@Override
	public GoodsM getGoodsM(int id) {
		String Sql = "Select * From goodsM Where id = ?";
		super.executeQuery(Sql, id);
		GoodsM goods = new GoodsM();
		try {
			while (super.set.next()) {
				goods.setId(super.set.getInt("id"));
				goods.setGoodsId(super.set.getString("goodsId"));
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
	public List<GoodsM> arrSell(int state) {
		String Sql = "Select * From goodsM Where state = ?";
		super.executeQuery(Sql, state);
		List<GoodsM> arr = new ArrayList<GoodsM>();
		try {
			while (super.set.next()) {
				GoodsM goods = new GoodsM();
				goods.setId(super.set.getInt("id"));
				goods.setGoodsId(super.set.getString("goodsId"));
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
	public int nameCount(String goodsMName) {
		String Sql = "Select count(*) as c From goodsM Where goodName = ?";
		super.executeQuery(Sql, goodsMName);
		int num = 0;
		Goods goods = new Goods();
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
