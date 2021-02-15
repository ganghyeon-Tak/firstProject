package com.ch.ch08.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ch.ch08.model.Dept;

@Repository
public class DeptDaoImpl implements DeptDao{
	@Autowired
	private SqlSessionTemplate sst;

	public List<Dept> list() {
		// dept.xml로 보냄
		return sst.selectList("deptns.list");
	}
	public Dept select(int deptno) {
		return sst.selectOne("deptns.select", deptno);
	}
	public int insert(Dept dept) {
		return sst.insert("deptns.insert", dept);
	}
	public int update(Dept dept) {
		return sst.update("deptns.update", dept);
	}
	@Override
	public int delete(int deptno) {
		return sst.delete("deptns.delete", deptno);
	}
}
