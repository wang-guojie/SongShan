package service;

import java.util.List;

import entity.InFormAtion;
import entity.Page;

public interface InFormAtionService {

	// ��ʾ����������Ϣ
	List<InFormAtion> search();

	// ��ҳչʾ
	int getAllCount();

	InFormAtion getById(int id);

	List list(Page page);

}
