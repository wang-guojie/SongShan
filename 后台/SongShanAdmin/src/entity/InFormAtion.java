package entity;

public class InFormAtion {
	// ��ѶID
	private int inforid;
	// ��Ѷ������
	private String inforname;
	// ��Ѷ����
	private String inforcontent;
	// ��Ѷʱ��
	private String infortime;

	// ����
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
	}

}
