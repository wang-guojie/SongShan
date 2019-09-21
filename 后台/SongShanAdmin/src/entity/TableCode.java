package entity;

import java.util.ArrayList;
import java.util.List;

public class TableCode {
	
	// ״̬  0:�ɹ�
	private int code=0; 
	// �ɹ������ʾ��Ϣ
    private String msg; 
    // ����������
    private int count; 
    // ǰ̨��ǰҳ������
    private List data = new ArrayList(); 
	
	// �����캯��
	public TableCode(int code, int count, String msg, List data) {
		this.code = code;
		this.count = count;
		this.msg = msg;
		this.data = data;
	}
	
	// �����캯��
	public TableCode() {}
	
	
	// ��װ
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
