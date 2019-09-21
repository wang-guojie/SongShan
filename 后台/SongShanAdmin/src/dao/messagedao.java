package dao;

import java.util.List;

import entity.Page;
import entity.message;

public interface messagedao {
int add(message m);
int update(message m);
int delete(int id);
List<message> getAll(String name);
message checkname(int id);
public List page(Page p);
int count();


//分頁+刪除+查詢

public void getPage(Page pa,String name);

int getAllCount(String name);

}
