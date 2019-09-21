package entity;

import java.util.ArrayList;
import java.util.List;

public class TableCode {
	
	// 状态  0:成功
	private int code=0; 
	// 成功后的显示信息
    private String msg; 
    // 数据总条数
    private int count; 
    // 前台当前页的数据
    private List data = new ArrayList(); 
	
	// 主构造函数
	public TableCode(int code, int count, String msg, List data) {
		this.code = code;
		this.count = count;
		this.msg = msg;
		this.data = data;
	}
	
	// 辅构造函数
	public TableCode() {}
	
	
	// 封装
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
    
    
    
}
