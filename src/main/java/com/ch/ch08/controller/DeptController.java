package com.ch.ch08.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ch.ch08.model.Dept;
import com.ch.ch08.service.DeptService;

@Controller
public class DeptController {
	@Autowired
	private DeptService ds;
	@RequestMapping("deptList")
	public String deptList(Model model) {
		List<Dept> deptList = ds.list();
		model.addAttribute("deptList", deptList);
		return "/dept/deptList";
	}
	@RequestMapping("insertDeptForm")
	public String insertDeptForm() {
		return "/dept/insertDeptForm";
	}
	
	@RequestMapping("deptInsert")
	// Dept dept는 화면에서 들어온 데이터(부서정보)
	public String deptInsert(Dept dept, Model model) {
		// 부서코드가 중복됐는지 체크
		// dt : 테이블에 저장되어 있는 부서정보
		Dept dt = ds.select(dept.getDeptno());
		int result = 0;
		if (dt == null) result = ds.insert(dept);
		else result = -1;
		model.addAttribute("result", result);
		return "/dept/deptInsert";
	}
	@RequestMapping("updateDeptForm")
	public String updateDeptForm(int deptno, Model model) {
		Dept dept = ds.select(deptno);
		model.addAttribute("dept", dept);
		return "/dept/updateDeptForm";
	}
	@RequestMapping("deptUpdate")
	public String deptUpdate(Dept dept, Model model) {
		int result = ds.update(dept);
		model.addAttribute("result",result);
		return "/dept/deptUpdate";
	}
	@RequestMapping("deleteDept")
	public String deleteDept(int deptno, Model model) {
		int result = ds.delete(deptno);
		model.addAttribute("result", result);
		return "/dept/deleteDept";
	}
	
	@RequestMapping(value = "deptNoChk", produces = "text/html;charset=utf-8")
	// jsp로 보내지말고 바로 보내줌
	@ResponseBody
	public String deptNoChk(int deptno) {
		String data = "";
		Dept dept = ds.select(deptno);
		if (dept == null) data = "사용가능한 부서코드입니다.";
		else data = "사용중이니 다른 부서코드를 사용하세요";
		return data;
	}
	
}
