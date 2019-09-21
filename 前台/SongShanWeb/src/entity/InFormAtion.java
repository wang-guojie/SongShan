package entity;

public class InFormAtion {
	// 资讯ID
	private int inforid;
	// 资讯标题名
	private String inforname;
	// 资讯正文
	private String inforcontent;
	// 资讯时间
	private String infortime;

	// 拆解时间
	private String m;
	private String y;

	public String getM() {
		return m;
	}

	public void setM(String m) {
		this.m = m;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	// 类型
	private int typeid;

	private Scenic scenic;

	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	public Scenic getScenic() {
		return scenic;
	}

	public void setScenic(Scenic scenic) {
		this.scenic = scenic;
	}

	public int getInforid() {
		return inforid;
	}

	public void setInforid(int inforid) {
		this.inforid = inforid;
	}

	public String getInforname() {
		return inforname;
	}

	public void setInforname(String inforname) {
		this.inforname = inforname;
	}

	public String getInforcontent() {
		return inforcontent;
	}

	public void setInforcontent(String inforcontent) {
		this.inforcontent = inforcontent;
	}

	public String getInfortime() {
		return infortime;
	}

	public void setInfortime(String infortime) {
		this.infortime = infortime;
		String times[] = this.infortime.split("-");
		this.y = times[0].substring(2);
		this.m = times[1];

	}

}
