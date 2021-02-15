<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${result > 0 }">
	<script type="text/javascript">
		alert("입력 성공 대박!!");
		location.href = "deptList.do";
	</script>
</c:if>
<c:if test="${result == -1 }">
	<script type="text/javascript">
		alert("이미 존재하는 데이터입니다.");
		history.go(-1);
	</script>
</c:if>
</body>
</html>