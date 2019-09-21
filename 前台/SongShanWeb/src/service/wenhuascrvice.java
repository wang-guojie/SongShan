package service;

import java.util.List;

import entity.message;
import entity.wenhua;

public interface wenhuascrvice {
int add(wenhua w);
int update(wenhua w);
int delete(int id);
public List<wenhua> getAll();
wenhua checkname(int id);
}
