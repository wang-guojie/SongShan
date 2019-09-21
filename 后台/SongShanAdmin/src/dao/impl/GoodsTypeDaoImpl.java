package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.GoodsTypeDao;
import entity.GoodsType;

public class GoodsTypeDaoImpl extends BaseDao implements GoodsTypeDao {

	@Override
	public GoodsType arrSell(int id) {
		String Sql = "Select * From goodsType Where typeId = ?";
		super.executeQuery(Sql, id);
		GoodsType goods = new GoodsType();
		try {
			while (super.set.next()) {
				goods.setId(super.set.getInt("typeId"));
				goods.setName(super.set.getString("typeName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return goods;
	}

	@Override
	public List<GoodsType> arrSell() {
		String Sql = "Select * From goodsType";
		super.executeQuery(Sql);
		List<GoodsType> arr = new ArrayList<GoodsType>();
		try {
			while (super.set.next()) {
				GoodsType goods = new GoodsType();
				goods.setId(super.set.getInt("typeId"));
				goods.setName(super.set.getString("typeName"));
				arr.add(goods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return arr;
	}

}
