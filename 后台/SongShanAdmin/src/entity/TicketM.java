package entity;

import java.util.ArrayList;
import java.util.List;

import dao.impl.GoodsDaoImpl;
import dao.impl.TicketDaoImpl;
import dao.impl.TicketMDaoImpl;

public class TicketM {

	private int id;
	private int goodsId;
	private String ticketId;
	private String user;
	private int buyCount;
	private String beginTime;
	private String endTime;
	private String okTime;
	private int money;
	private GoodsM goodsM;
	private String imgSrc;
	private int state;
	private List list;

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
		// 拆解ID
		String[] ids = ticketId.split(",");
		List arr = new ArrayList();
		for (int i = 0; i < ids.length; i++) {
			arr.add(new TicketDaoImpl().getTicket(Integer.parseInt(ids[i])));
		}
		// 获取集合
		this.list = arr;
	}

	public String getOkTime() {
		return okTime;
	}

	public void setOkTime(String okTime) {
		this.okTime = okTime;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getBuyCount() {
		return buyCount;
	}

	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public GoodsM getGoodsM() {
		return goodsM;
	}

	public void setGoodsM(GoodsM goodsM) {
		this.goodsM = goodsM;
	}

}
