package service;

import java.util.List;

import entity.InFormAtion;
import entity.Page;

public interface InFormAtionService {

	// 显示所有新闻信息
	List<InFormAtion> search();

	// 分页展示
	int getAllCount();

	InFormAtion getById(int id);

	List list(Page page);

}
