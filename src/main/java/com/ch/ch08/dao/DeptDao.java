package com.ch.ch08.dao;
// Dao : DB접근
import java.util.List;

import com.ch.ch08.model.Dept;

public interface DeptDao {

	List<Dept> list();

	Dept select(int deptno);

	int insert(Dept dept);

	int update(Dept dept);

	int delete(int deptno);

}
