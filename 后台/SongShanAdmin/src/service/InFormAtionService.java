package service;

import java.util.List;

import entity.InFormAtion;
import entity.Page;

public interface InFormAtionService {

	// 景区资讯 添加
	int inFormAtionAdd(InFormAtion info);

	// 景区资讯 修改
	int inFormAtionUpdate(InFormAtion info);

	// 景区资讯 删除
	int inFormAtionDelete(int id);

	// 显示所有新闻信息
	List<InFormAtion> search(String name);

	// 根据ID修改数据
	InFormAtion getById(int id);

	// 资讯查重
	int checkeName(String name);

	// 分页展示
	int getAllCount();

	List list(Page page);
	
	//分页+查询+删除
	void get4Page(Page page, String name, int typeid);
	
	int getAllCount(String name,int typeid);

}
