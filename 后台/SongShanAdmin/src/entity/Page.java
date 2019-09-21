package entity;

import java.util.List;

public class Page {
	private int pageIndex;
	private int pageSize;
	private int pageCount;
	private int dataCount;
	private List list;

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		if (pageIndex < 1) {
			this.pageIndex = 1;
		} else if (pageIndex > this.pageCount) {
			this.pageIndex = this.pageCount == 0 ? 1 : this.pageCount;
		} else {
			this.pageIndex = pageIndex;
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getDataCount() {
		return dataCount;
	}

	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
		this.pageCount=this.dataCount%this.pageSize==0?(this.dataCount/this.pageSize):(this.dataCount/this.pageSize+1);
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

}
