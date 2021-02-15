<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function deptNoChk() {
		if (!frm.deptno.value) {
			alert("부서코드 입력 후에 중복확인 하세요");
			frm.deptno.focus();
			return false;
		}
		// id가 disp인 위치에 data를 넣는데 html형식으로 나타냄
		// #은 id, .은 class
		$.post("deptNoChk.do","deptno="+frm.deptno.value, function (data) {
			$('#disp').html(data); // html형식으로 보여줌
		});
	}
</script>
</head>
<body>
<div class="container">
	<h2 class="text-primary">부서정보 입력</h2>
<form action="deptInsert.do" method="post" name="frm">
<table class="table table-bordered">
	<tr>
		<td>부서코드</td>
		<td><input type="number" name="deptno"
			required="required" autofocus="autofocus">
			<input type="button" value="중복체크" onclick="deptNoChk()"
				class="btn btn-warning btn-sm">
			<div id="disp" class="err"></div></td>
	</tr>
	<tr>
		<td>부서명</td>
		<td><input type="text" name="dname"
			required="required"></td>
	</tr>
	<tr>
		<td>근무지</td>
		<td><input type="text" name="loc"
			required="required"></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit"
			class="btn btn-success" value="확인"></td>
	</tr>
</table>
</form>
<a href="deptList.do" class="btn btn-info">부서 목록</a>
</div>
</body>
</html>