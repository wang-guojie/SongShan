package service;

import java.util.List;

import entity.InFormAtion;
import entity.Page;

public interface InFormAtionService {

	// ������Ѷ ���
	int inFormAtionAdd(InFormAtion info);

	// ������Ѷ �޸�
	int inFormAtionUpdate(InFormAtion info);

	// ������Ѷ ɾ��
	int inFormAtionDelete(int id);

	// ��ʾ����������Ϣ
	List<InFormAtion> search(String name);

	// ����ID�޸�����
	InFormAtion getById(int id);

	// ��Ѷ����
	int checkeName(String name);

	// ��ҳչʾ
	int getAllCount();

	List list(Page page);
	
	//��ҳ+��ѯ+ɾ��
	void get4Page(Page page, String name, int typeid);
	
	int getAllCount(String name,int typeid);

}
