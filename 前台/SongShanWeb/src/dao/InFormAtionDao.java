package dao;

import java.util.List;

import entity.InFormAtion;
import entity.Page;

public interface InFormAtionDao {

	// ��ʾ����������Ϣ
	List<InFormAtion> search();

	// ��ҳչʾ
	int getAllCount();

	List list(Page page);
	
	
	InFormAtion getById(int id);
	


}
