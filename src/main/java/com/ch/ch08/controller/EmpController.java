package com.ch.ch08.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ch.ch08.model.Dept;
import com.ch.ch08.model.Emp;
import com.ch.ch08.service.DeptService;
import com.ch.ch08.service.EmpService;

@Controller
public class EmpController {
	@Autowired
	private DeptService ds;
	@Autowired
	private EmpService es;
	@RequestMapping("empList")
	public String empList(int deptno, Model model) {
		Dept dept = ds.select(deptno);
		List<Emp> empList = es.list(deptno);
		// 부서명
		model.addAttribute("dept", dept);
		model.addAttribute("empList", empList);
		return "/emp/empList";
	}
	@RequestMapping("empUpdateForm")
	public String empUpdateForm(int empno, Model model) {
		Emp emp = es.select(empno);
		List<Dept> deptList = ds.list();
		List<Emp> empList = es.empList();
		model.addAttribute("deptList", deptList);  	// 부서코드 선택
		model.addAttribute("empList", empList);  	// 관리자 선택
		model.addAttribute("emp", emp);  			// 현재 수정할 직원 정보
		return "/emp/empUpdateForm";
	}
	@RequestMapping("empUpdate")
	public String empUpdate(Emp emp, Model model) {
		int result = es.update(emp);
		model.addAttribute("result", result);
		model.addAttribute("emp",emp);
		return "/emp/empUpdate";
	}
	@RequestMapping("empDelete")
	public String empDelete(int empno, Model model) {
		Emp emp = es.select(empno);
		int result = es.delete(empno);
		model.addAttribute("result", result);
		model.addAttribute("emp",emp);
		return "/emp/empDelete";
	}
	@RequestMapping("empInsertForm")
	public String empInsertForm(int deptno, Model model) {
		List<Dept> deptList = ds.list();
		List<Emp> empList = es.empList();
		// jsp로 보내는 용도
		model.addAttribute("deptno", deptno);
		model.addAttribute("deptList", deptList);
		model.addAttribute("empList", empList);
		return "/emp/empInsertForm";
	}
	@RequestMapping("empInsert")
	public String empInsert(Emp emp, Model model) {
		int result = 0;
		// emp2는 DB에 있는 emp
		Emp emp2 = es.select(emp.getEmpno());
		if (emp2 == null) result = es.insert(emp);
		else result = -1;
		model.addAttribute("emp", emp);
		model.addAttribute("result", result);
		return "/emp/empInsert";
	}
	@RequestMapping("empSelect")
	// Model : jsp에 데이터를 보내는 역할
	public String empSelect(int empno, Model model) {
		System.out.println("empno="+empno);
		Emp emp = es.select(empno);
		model.addAttribute("emp", emp);
		return "/emp/empSelect";
	}
	@RequestMapping("allEmpList")
	public String allEmpList(Model model) {
		List<Emp> list = es.allEmpList();
		model.addAttribute("list", list);
		return "/emp/allEmpList";
	}
	@RequestMapping(value = "empChk",
		produces = "text/html;charset=utf-8")
	@ResponseBody
	public String empChk(int empno) {
		String data = "";
		Emp emp = es.select(empno);
		if (emp == null) data = "사용 가능한 사번입니다.";
		else data = "사용중인 사번이니 다른 번호를 쓰세요";
		return data;
	}
}
