package entity;

import java.util.ArrayList;
import java.util.List;

import dao.impl.GoodsDaoImpl;

public class GoodsM {

	// ID
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	// 商品集合ID
	private String goodsId;
	
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
		// 拆解ID
		String[] ids = goodsId.split(",");
		List arr = new ArrayList();
		for (int i = 0; i < ids.length; i++) {
			arr.add(new GoodsDaoImpl().getGoods(Integer.parseInt(ids[i])));
		}
		// 获取集合
		this.list = arr;
	}
	
	// 数据集合
	private List<Goods> list;

	public List<Goods> getList() {
		return list;
	}
	public void setList(List<Goods> list) {
		this.list = list;
	}

	// 商品状态
	private int state;
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	// 商品名称
	private String goodName;
	
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	
	// 商品描述
	private String goodDesc;

	public String getGoodDesc() {
		return goodDesc;
	}
	public void setGoodDesc(String goodDesc) {
		this.goodDesc = goodDesc;
	}
	
	// 商品数量
	private int inventory;

	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	
	// 商品图片地址
	private String imgSrc;
	
	public String getImgSrc() {
		return imgSrc;
	}
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	// 商品价格
	private int money;

	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	// 商品类型对象
	private GoodsType type;
	
	public GoodsType getType() {
		return type;
	}
	public void setType(GoodsType type) {
		this.type = type;
	}
	
}
