package entity;

public class Ticket {

	// ID
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	// 商品ID
	private int goodsId;
	
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	
	// 商品对象
	private Goods goods;
	
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	
	// 用户信息
	private String user;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	// 购买数量
	private int buyCount;
	
	public int getBuyCount() {
		return buyCount;
	}
	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}
	
	// 预约日期
	private String beginTime;
	
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	
	// 结束日期
	private String endTime;
	
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	// 金额
	private int money;
	
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	// 状态
	private int state;

	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	// 激活日期
	private String okTime;

	public String getOkTime() {
		return okTime;
	}
	public void setOkTime(String okTime) {
		this.okTime = okTime;
	}

}
