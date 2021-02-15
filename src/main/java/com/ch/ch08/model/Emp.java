package com.ch.ch08.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Emp {
	private int empno;
	private String ename;
	private String job;
	// Integer : null값이 들어올 수 있다.
	// int : 숫자만 들어가고 null은 0으로 표시된다.
	private Integer mgr;
	private Date hiredate;
	private int sal;
	private Integer comm;
	private int deptno;
	// 관리자명
	private String mgrName;
	// join용 부서정보
	private Dept dept;
}
