<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function () {
		$('#empDisp').load('empList.do', 'deptno=${emp.deptno}');
	});
	function delConfirm(empno) {
		var cf = confirm("정말 삭제하시겠습니까?");
		if (cf) location.href = "empDelete.do?empno="+empno;
		else alert("삭제가 취소되었습니다.");
	}
</script>
</head>
<body>
<div class="container" align="center">
	<h2 class="text-primary">직원 상세정보</h2>
<table class="table table-bordered table-striped">
	<tr>
		<td>사번</td>
		<td>${emp.empno }</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>${emp.ename}</td>
	</tr>
	<tr>
		<td>업무</td>
		<td>${emp.job}</td>
	</tr>
	<tr>
		<td>관리자</td>
		<td>${emp.mgr}</td>
	</tr>
	<tr>
		<td>입사일</td>
		<td>${emp.hiredate}</td>
	</tr>
	<tr>
		<td>급여</td>
		<td>${emp.sal}</td>
	</tr>
	<tr>
		<td>보너스</td>
		<td>${emp.comm}</td>
	</tr>
	<tr>
		<td>부서코드</td>
		<td>${emp.deptno}</td>
	</tr>
	<tr>	
		<td colspan="2" align="center">
		<a href="empList.do?deptno=${emp.deptno }"
			class="btn btn-info">직원목록</a>
		<a href="empUpdateForm.do?empno=${emp.empno }"
			class="btn btn-warning">수정</a>
		<a onclick="delConfirm(${emp.empno})"
			class="btn btn-danger">삭제</a>
		<a href="deptList.do"
			class="btn btn-success">부서목록</a>
</table>
<div id="empDisp"></div>
</div>
</body>
</html>