package com.ch.ch08.model;
// model(or DTO,VO)
import lombok.Data;

@Data
public class Dept {
	private int deptno;
	private String dname;
	private String loc;
}
