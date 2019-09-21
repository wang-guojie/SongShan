package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.CarouselDao;
import entity.Carousel;

public class CarouselDaoImpl extends BaseDao implements CarouselDao {
	
	// 更新
	@Override
	public int upd(Carousel index) {
		String Sql = "Update carousel Set indexTitle=?, indexDesc=?, imageSrc=?, indexUrl=? Where indexId=?";
		return super.executeUpdate(Sql, index.getIndexTitle(),
				index.getIndexDesc(), index.getImageSrc(), 
				index.getIndexUrl(), index.getIndexId());
	}

	// 查询
	@Override
	public List<Carousel> arrSell(int typeid) {
		List<Carousel> arr = new ArrayList<Carousel>();
		String Sql = "Select * From carousel Where typeid = ?";
		super.executeQuery(Sql, typeid);
		try {
			while (super.set.next()) {
				Carousel index = new Carousel();
				index.setIndexId(set.getInt("indexId"));
				index.setIndexTitle(set.getString("indexTitle"));
				index.setIndexDesc(set.getString("indexDesc"));
				index.setImageSrc(set.getString("imageSrc"));
				index.setIndexUrl(set.getString("indexUrl"));
				arr.add(index);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return arr;
	}

	// 新增 
	@Override
	public int add(Carousel index) {
		String Sql = "Insert Into carousel(indexTitle,indexDesc,imageSrc,indexUrl) Values(?,?,?,?)";
		return super.executeUpdate(Sql, index.getIndexTitle(),
				index.getIndexDesc(), index.getImageSrc(), 
				index.getIndexUrl());
	}

	// 删除
	@Override
	public int del(int id) {
		String Sql = "Delete From carousel Where id=?";
		return super.executeUpdate(Sql, id);
	}

}
