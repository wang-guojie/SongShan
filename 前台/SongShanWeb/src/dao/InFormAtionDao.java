package dao;

import java.util.List;

import entity.InFormAtion;
import entity.Page;

public interface InFormAtionDao {

	// 显示所有新闻信息
	List<InFormAtion> search();

	// 分页展示
	int getAllCount();

	List list(Page page);
	
	
	InFormAtion getById(int id);
	


}
